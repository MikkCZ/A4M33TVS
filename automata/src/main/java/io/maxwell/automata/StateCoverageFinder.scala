package io.maxwell.automata

import io.maxwell.automata.JavaHelpers.DoCommand

import scala.collection.mutable

/**
  * @author Vorisek Lukas <lukasvorisek@gmail.com>
  */
class StateCoverageFinder(automata: Automata, events: Array[Event]) {

  def find() = {
    val nodes: mutable.MutableList[Node] = mutable.MutableList.empty
    val nodeMap: mutable.Map[String, List[Event]] = mutable.Map.empty
    val outputSet: mutable.Set[List[Event]] = mutable.Set.empty

    // EntryNode
    nodes += automata.entryNode
    nodeMap(automata.entryNode.name) = List.empty
    outputSet += List.empty
    // Scan all nodes
    JavaHelpers.forAll[Node](nodes, new DoCommand[Node] {
      override def doCommand(element: Option[Node], index: Int) = {
        scan(element.get, nodes, nodeMap, outputSet)
      }
    })

    outputSet
  }

  def scan(node: Node, nodes: mutable.MutableList[Node], nodeMap: mutable.Map[String,List[Event]], outputSet: mutable.Set[List[Event]]) = {
    // Pro kazdy dostupny event
    for (event <- events) {
      val transition = node.transitions(event)
      if (transition != null && !nodes.contains(transition.target)) {
        nodes += transition.target
        nodeMap(transition.target.name) = nodeMap(node.name) :+ event
        outputSet += (nodeMap(node.name) :+ event)
      }
    }
  }

}
