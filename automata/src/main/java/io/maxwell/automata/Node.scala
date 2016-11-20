package io.maxwell.automata

/**
  * @author Marek Timr
  */
case class Node(name: String, var transitions: Map[Event, Transition]) {
  def addTransition(event: Event, transition: Transition): Unit = {
    transitions = transitions + (event -> transition)
  }
}
