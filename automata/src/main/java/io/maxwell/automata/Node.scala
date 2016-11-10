package io.maxwell.automata

/**
  * @author Marek Timr
  */
case class Node(name: String, var transitions: List[Transition]) {
  def addTransition(transition: Transition): Unit = {
    transitions = transitions :+ transition
  }
}
