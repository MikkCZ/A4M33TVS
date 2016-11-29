package io.maxwell.automata

import com.typesafe.config.ConfigFactory

import scala.collection.immutable.HashSet

/**
  * @author Marek Timr
  */
object Application {

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
    println("State cover set:")
    println("{"+setL.map{
      word =>
        word.map {event => event.name}.mkString("")
    }.mkString(",")+"}")
    println()
    val trCreator = new TransitionCoverageCreator(setL, events)
    val setT = trCreator.create()
    // Ke vsem lokacim se pokusime zkonstruovat vstup do vsech ostatnich
    println("Transition cover set:")
    println("{"+setT.map{
      word =>
        word.map {event => event.name}.mkString("")
    }.mkString(",")+"}")
    println()


    var pairToWord: Map[(State, State), List[Event]] = Map.empty
    for (pair <- states.combinations(2)) {
      var pairSet: Set[(State, State)] = HashSet.empty
      val qa = pair.head
      val qb = pair.drop(1).head
      val traditionalTouple = if (qa.name.compareTo(qb.name) < 0) {
        (qa,qb)
      } else {
        (qb, qa)
      }
      var touple = (qa,qb)
      while(!pairSet.contains(touple) && !pairSet.contains((touple._2, touple._1)) && !touple._1.equals(touple._2)) {
        val (event: Event, nextPair: (State, State)) = eqFinder.findDistinctEvent(events, tables, touple)
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

    println("Characterization set:")
    val w = pairToWord.values.toSet
    println("{"+w.map{
      word =>
        word.map {event => event.name}.mkString("")
    }.mkString(",")+"}")
    pairToWord.keySet.map{
      pair =>
        s"(${pair._1.name},${pair._2.name}): ${pairToWord(pair).map{ ev => ev.name}.mkString("")}"
    }.toList.sorted.foreach(println)
    println()

    println("Output traces:")
    for (state <- automata.nodes.keySet.toList.sorted; word <- w) {
      print(s"$state -> ${word.map { event => event.name}.mkString("")}: ")
      var node = automata.nodes(state)
      println(
        word.map(event => {
          val transition = node.transitions(event)
          node = transition.target
          s"${transition.output.name}"
        }
        ).mkString(",")
      )
    }
  }

}
