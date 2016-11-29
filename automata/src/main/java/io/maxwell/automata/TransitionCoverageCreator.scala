package io.maxwell.automata

import scala.collection.mutable

/**
  * @author Vorisek Lukas <lukasvorisek@gmail.com>
  */
class TransitionCoverageCreator(stateCoverage: mutable.Set[List[Event]], events: Array[Event]) {

  def create() = {
    val coverage : mutable.Set[List[Event]] = mutable.Set.empty

    stateCoverage.foreach {
      list => events.foreach(ev => coverage += (list :+ ev))
    }
    coverage
  }
}
