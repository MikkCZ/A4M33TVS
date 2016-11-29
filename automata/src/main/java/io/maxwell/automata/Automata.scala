package io.maxwell.automata

/**
  * @author Marek Timr
  */
class Automata(val entryNode: Node, val exitNode: Node, val defaultOutput: Output, val nodes: Map[String, Node]) {

  def output(input: List[Event]): List[Output] = {
    def step(node: Node, input: List[Event], output: List[Output]): List[Output] = {
      input match {
        case e::rest =>
          val transition = node.transitions(e)
          step(transition.target,
              rest,
              output :+ transition.output)
        case _ => output
      }
    }
    step(entryNode, input, List.empty)
  }
}

case class Node(name: String, var transitions: Map[Event, Transition]) {
  def addTransition(event: Event, transition: Transition): Unit = {
    transitions = transitions + (event -> transition)
  }

  override def toString: String = name
}

case class Event(name: String)

case class Output(name: String)

case class Transition(event: Event, output: Output, target: Node){
}
