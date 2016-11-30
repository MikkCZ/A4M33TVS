package io.maxwell.automata

import scala.io.Source

/**
  * @author Marek Timr
  */
class AutomataParser(inputFile: String) {
  val headerPattern = """.*,(.*)""".r
  val lines = Source.fromFile(inputFile)
    .getLines()
    .map(line => line.filter(c => !c.isWhitespace))
    .toList
  val entryLine = lines.head
  val exitLine = lines(1)
  val defaultLine = lines(2)
  val tableHeaderLine = lines(5)
  val nodeLines = lines.drop(6)
  val events = tableHeaderLine
    .split(",")
    .drop(1)
    .takeWhile(!_.isEmpty)
    .map(Event.apply)
    .toList


  var nodeMap: Map[String, Node] = Map.empty
  var eventMap: Map[String, Event] = Map.empty
  var outputMap: Map[String, Output] = Map.empty
  nodeLines.foreach { line =>
    val parts = line.split(",")
    val sourceNode = getOrCreateNode(parts(0))
    val targets = parts.slice(1, events.size + 1)
    val outputs = parts.slice(2 + events.size, 2 + 2 * events.size)
    for (eventWithIndex <- events.zipWithIndex) {
      sourceNode.addTransition(
        eventWithIndex._1,
        Transition(
          eventWithIndex._1,
          getOrCreateOutput(outputs(eventWithIndex._2)),
          getOrCreateNode(targets(eventWithIndex._2))))
    }
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
      val node = Node(name, Map.empty)
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

  def getEvents = {
    events.toArray
  }

}


