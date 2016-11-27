package io.maxwell.automata

import com.typesafe.config.ConfigFactory

import scala.collection.immutable.HashSet

/**
  * @author Marek Timr
  */
object Application {
  def eventForRow(qarow: Row, qbrow: Row, events: Array[Event]): (Event, State, State) = {
    if (qarow.next1.group != qbrow.next1.group) {
      (events.head, qarow.next1.node, qbrow.next1.node)
    } else if (qarow.next2.group != qbrow.next2.group) {
      (events(1), qarow.next2.node, qbrow.next2.node)
    } else if (qarow.next3.group != qbrow.next3.group) {
      (events(2), qarow.next3.node, qbrow.next3.node)
    } else {
      (events(2), qarow.next3.node, qbrow.next3.node)
    }
  }

  def main(args: Array[String]): Unit = {
    val settings = ConfigFactory.load().getConfig("automata")
    val inputFileName = settings.getString("input-csv")
    val inputParser = new AutomataParser(inputFileName)
    val automata = inputParser.getAutomata
    val events = inputParser.getEvents
    val eqFinder = new EquivalenceFinder(automata, events)
    val tables = eqFinder.findEquivalence()
    val states = tables.head.rows.map(r => r.state)

    val scFinder = new StateCoverageFinder(automata, events)
    // Mnozina vstupnich eventu, diky kterym lze navstivit kazdou lokaci
    val setL = scFinder.find()
    println(setL)
    val trCreator = new TransitionCoverageCreator(setL, events)
    val setT = trCreator.create()
    // Ke vsem lokacim se pokusime zkonstruovat vstup do vsech ostatnich
    println(setT)


    var pairToWord: Map[(State, State), List[Event]] = Map.empty
    for (pair <- states.combinations(2)) {
      var pairSet: Set[(State, State)] = HashSet.empty
      val qa = pair.head
      val qb = pair.drop(1).head
      val traditionalTouple = (qa,qb)
      var touple = (qa,qb)
      while(!pairSet.contains(touple) && !pairSet.contains((touple._2, touple._1))) {
        val (event: Event, nextPair: (State, State)) = findDistinctEvent(events, tables, touple)
        pairSet = pairSet + touple
        if (pairToWord.contains(traditionalTouple)) {
          val list = pairToWord(traditionalTouple) :+ event
          pairToWord = pairToWord + (traditionalTouple -> list)
        } else {
          pairToWord = pairToWord + (traditionalTouple -> List(event))
        }
        touple = nextPair
      }
    }
    val w = pairToWord.values.toSet
    w.map{
      word =>
        word.map {event => event.name}.mkString(", ")
    }.foreach(println)


  }

  def findDistinctEvent(events: Array[Event], tables: List[Table], touple: (State, State)): (Event,(State, State)) = {
    val different = tables.find { table =>
      val qarow = table.rows.find(row => row.state == touple._1).get
      val qbrow = table.rows.find(row => row.state == touple._2).get
      qarow.group != qbrow.group
    }.get
    val qarow = different.rows.find(row => row.state == touple._1).get
    val qbrow = different.rows.find(row => row.state == touple._2).get
    val event = eventForRow(qarow, qbrow, events)
    (event._1, (event._2, event._3))
  }
}
