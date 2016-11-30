package io.maxwell.automata

import com.typesafe.config.ConfigFactory

import scala.collection.immutable.HashSet

/**
  * @author Marek Timr
  */
object Application {

  def main(args: Array[String]): Unit = {
    val settings = ConfigFactory.load().getConfig("automata")
    val inputParser = new AutomataParser(settings.getString("input-csv"))
    val automata = inputParser.getAutomata
    val events = inputParser.getEvents
    val eqFinder = new EquivalenceFinder(automata, events)
    val tables = eqFinder.findEquivalence()
    val states = tables.head.rows.map(r => r.state)

    // Mnozina vstupnich eventu, diky kterym lze navstivit kazdou lokaci
    val setL = new StateCoverageFinder(automata, events).find()
    println("State cover set:")
    println(setL.map{
      word =>
        word.map {event => event.name}.mkString("{", " ", "}" )
    }.mkString("{", ", ", "}"))
    println()

    // Ke vsem lokacim se pokusime zkonstruovat vstup do vsech ostatnich
    val setT = new TransitionCoverageCreator(setL, events).create()
    println("Transition cover set:")
    println(setT.map{
      word =>
        word.map {event => event.name}.mkString("{", " ", "}" )
    }.mkString("{", ", ", "}"))


    var pairToWord: Map[(State, State), List[Event]] = Map.empty
    for (pair <- states.combinations(2)) {
      var pairSet: Set[(State, State)] = HashSet.empty
      val qa = pair.head
      val qb = pair.drop(1).head
      val initialPairTuple = if (qa.name.compareTo(qb.name) < 0) {
        (qa,qb)
      } else {
        (qb, qa)
      }
      var tuple = (qa,qb)
      while(!pairSet.contains(tuple) && !pairSet.contains((tuple._2, tuple._1)) && !tuple._1.equals(tuple._2)) {
        val (event: Event, nextPair: (State, State)) = eqFinder.findDistinctEvent(events, tables, tuple)
        pairSet = pairSet + tuple
        if (pairToWord.contains(initialPairTuple)) {
          val list = pairToWord(initialPairTuple) :+ event
          pairToWord = pairToWord + (initialPairTuple -> list)
        } else {
          pairToWord = pairToWord + (initialPairTuple -> List(event))
        }
        tuple = nextPair
      }
    }
    val w = pairToWord.values.toSet

    println("Characterization set:")
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
      println(word.map(
        event => {
          val transition = node.transitions(event)
          node = transition.target
          s"${transition.output.name}"
      }).mkString(","))
    }
  }

}
