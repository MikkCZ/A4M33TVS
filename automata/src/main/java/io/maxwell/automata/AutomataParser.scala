package io.maxwell.automata

import scala.io.Source

/**
  * @author Marek Timr
  */
class AutomataParser(inputFile: String) {
  val headerPattern = """.*,(.*)""".r
  val tableHeader = """currentstate,(.*?),(.*?),(.*?),.*""".r
  val nodePattern = """(.*?),(.*?),(.*?),(.*?),,(.*?),(.*?),(.*?)""".r
  val lines = Source.fromFile(inputFile)
    .getLines()
    .map(line => line.filter(c => !c.isWhitespace))
    .toList
  val entryLine = lines.head
  val exitLine = lines(1)
  val defaultLine = lines(2)
  val tableHeaderLine = lines(5)
  val nodeLines = lines.drop(6)
  val events = tableHeaderLine match {
    case tableHeader(e1, e2, e3) => (e1, e2, e3)
  }
  var nodeMap: Map[String, Node] = Map.empty
  nodeLines.foreach {
    case nodePattern(name, s1, s2, s3, o1, o2, o3) =>
      val sourceNode = getOrCreateNode(name)
      sourceNode.addTransition(Transition(events._1, o1, getOrCreateNode(s1)))
      sourceNode.addTransition(Transition(events._2, o2, getOrCreateNode(s2)))
      sourceNode.addTransition(Transition(events._3, o3, getOrCreateNode(s3)))
  }

  def getOrCreateNode(name: String) = {
    if (nodeMap.contains(name)) {
      nodeMap(name)
    } else {
      val node = Node(name, List.empty)
      nodeMap = nodeMap + (name -> node)
      node
    }
  }

  val entryNode = getOrCreateNode(entryLine match {
    case headerPattern(name) => name
  })
  val exitNode = getOrCreateNode(exitLine match {
    case headerPattern(name) => name
  })
  val defaultOutput = defaultLine match {
    case headerPattern(name) => name
  }

  def getAutomata = {
    new Automata(entryNode, exitNode, defaultOutput, nodeMap)
  }

}


