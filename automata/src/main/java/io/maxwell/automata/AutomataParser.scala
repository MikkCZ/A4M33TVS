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
    case tableHeader(e1, e2, e3) => (Event(e1), Event(e2), Event(e3))
  }
  var nodeMap: Map[String, Node] = Map.empty
  var eventMap: Map[String, Event] = Map.empty
  var outputMap: Map[String, Output] = Map.empty
  nodeLines.foreach {
    case nodePattern(name, s1, s2, s3, o1, o2, o3) =>
      val sourceNode = getOrCreateNode(name)
      sourceNode.addTransition(Transition(events._1, getOrCreateOutput(o1), getOrCreateNode(s1)))
      sourceNode.addTransition(Transition(events._2, getOrCreateOutput(o2), getOrCreateNode(s2)))
      sourceNode.addTransition(Transition(events._3, getOrCreateOutput(o3), getOrCreateNode(s3)))
  }

  val entryNode = getOrCreateNode(entryLine match {
    case headerPattern(name) => name
  })
  val exitNode = getOrCreateNode(exitLine match {
    case headerPattern(name) => name
  })
  val defaultOutput = defaultLine match {
    case headerPattern(name) => getOrCreateOutput(name)
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

  def getOrCreateOutput(name: String) = {
    if(outputMap.contains(name)) {
      outputMap(name)
    }else {
      val symbol = Output(name)
      outputMap = outputMap + (name -> symbol)
      symbol
    }
  }

  def getAutomata = {
    new Automata(entryNode, exitNode, defaultOutput, nodeMap)
  }

}


