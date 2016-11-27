package io.maxwell.automata

import scala.collection.mutable.Set

/**
  * @author Vorisek Lukas <lukasvorisek@gmail.com>
  */
class TransitionCoverageCreator(stateCoverage: Set[List[Event]], events: Array[Event]) {

  def create() = {
    val coverage : Set[List[Event]] = Set.empty

    stateCoverage.foreach {
      list => (
        events.foreach(ev => coverage += (list :+ ev))
        )
    }
    coverage
  }
}
