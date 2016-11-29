package io.maxwell.automata

import io.maxwell.automata.JavaHelpers.DoCommand

import scala.collection.mutable

/**
  * @author Vorisek Lukas <lukasvorisek@gmail.com>
  */
class StateCoverageFinder(automata: Automata, events: Array[Event]) {
  private var lastFindMapping: mutable.Map[String, List[Event]] = _

  def find() = {
    val nodes: mutable.MutableList[Node] = mutable.MutableList.empty
    val nodeMap: mutable.Map[String, List[Event]] = mutable.Map.empty
    val outputSet: mutable.Set[List[Event]] = mutable.Set.empty

    // EntryNode
    nodes += automata.entryNode
    nodeMap(automata.entryNode.name) = List.empty
    outputSet += List.empty
    // Scan all nodes
    // Nevim proc, ale Scala zapis mi prosel jen 3 elementy a to i s iteratorem
    //nodes.foreach(node => scan(node, nodes, nodeMap))
    JavaHelpers.forAll[Node](nodes, new DoCommand[Node] {
      override def doCommand(element: Option[Node], index: Int) = {
        scan(element.get, nodes, nodeMap, outputSet)
      }
    })

//    automata.nodes.keys.foreach {
//      nodeKey =>
//        val node = automata.nodes(nodeKey)
//        println(node + " way " + nodeMap(node.name))
//    }

    lastFindMapping = nodeMap
    outputSet
  }

  def findMapping() = {
    if(lastFindMapping == null) {
      find()
    }
    lastFindMapping
  }

  def scan(node: Node, nodes: mutable.MutableList[Node], nodeMap: mutable.Map[String,List[Event]], outputSet: mutable.Set[List[Event]]) = {
    // Pro kazdy dostupny event
    events.foreach {
      ev => {
        val trans = node.transitions(ev)
        if(trans != null) {
          if(!nodes.contains(trans.target)) {
            nodes += trans.target
            nodeMap(trans.target.name) = nodeMap(node.name) :+ ev
            outputSet += (nodeMap(node.name) :+ ev)
          }
        }
      }
    }

  }


}
