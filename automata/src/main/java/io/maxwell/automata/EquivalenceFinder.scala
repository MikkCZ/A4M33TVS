package io.maxwell.automata

import scala.collection.mutable

/**
  * @author Marek Timr
  */
class EquivalenceFinder(automata: Automata, events: Array[Event]) {

  def findEquivalence() = {

    val initialStates = automata.nodes.values.toList

    val initialTable = initialStates.map { state => ( //pro kazdy state vygeneruj radku vystupu a prechodu
      state,
      (for (event <- events) yield state.transitions(event).output).toList,
      (for (event <- events) yield state.transitions(event).target).toList)
    }

    val croppedNodes = initialTable.map { //Nebudou existovat cykly v objektech a ja nebudu muset debuggovat StackOverflow errory
      row =>
        (State(row._1.name),
          row._2,
          for(target <- row._3) yield State(target.name))
    }

    val tableP0 = croppedNodes.map{node =>
      val state = node._1
      Row(
        Group(0),
        state,
        for(n <- node._3) yield StateWithGroup(state, Group(n.name.hashCode)))
    }

    val grouped = croppedNodes.groupBy { row => row._2 } // seskup je podle stejnych vystupu

    val numberedGroups = grouped
      .values
      .map { group => group.map { row => (row._1, row._3) } } //orezej vystupy
      .toList.zipWithIndex
      .map { group => (group._1, Group(group._2)) } //Ocisluj skupiny

    val stateGroup = collection.mutable.Map[State, Group]() //mapovani state na skupinu

    for (group <- numberedGroups; states <- group._1) {
      //napln mapovani
      stateGroup += (states._1 -> group._2)
    }

    val tableP1 = numberedGroups.flatMap {
      //Tabulka P1 slide 32 chapter-3.ppt
      group =>
        group._1.map {
          g =>
            val targets = g._2
            Row(
              group._2,
              g._1,
              for(target <- targets) yield StateWithGroup(target, stateGroup(target)))
        }
    }
    constructTables(Table(tableP1), List(Table(tableP0)))

  }

  def constructTables(table: Table, tableList: List[Table]): List[Table] = {
    val next = nextTable(table)
    if (table.rows.map{_.group}.distinct.length == next.rows.map{_.group}.distinct.length) {
      tableList :+ table
    } else {
      constructTables(next, tableList :+ table)
    }
  }

  def nextTable(table: Table): Table = {
    var groupSequence = 0
    def nextGroupNumber(): Int = {
      groupSequence += 1
      groupSequence
    }
    val newNaming: collection.mutable.Map[State, Group] = mutable.Map.empty
    val rowsForGroup = table.rows.groupBy(row => row.group)

    for (grouped <- rowsForGroup; //Pfff ???!!!
         rows = grouped._2;
         subscriptGroup <- rows.groupBy(row => row.next.map{_.group});
         groupNumber = nextGroupNumber();
         subscriptRow <- subscriptGroup._2) {

      newNaming += (subscriptRow.state -> Group(groupNumber))
    }

    Table(table.rows.map {
      row =>
        val targets = row.next
        Row(
          newNaming(row.state),
          row.state,
          for(target <- targets) yield StateWithGroup(target.node, newNaming(target.node))
        )
    }.sortBy(row => row.group.id))
  }

  def findDistinctEvent(events: Array[Event], tables: List[Table], tuple: (State, State)): (Event,(State, State)) = {
    var i = 0
    for (table <- tables) {
      val qarow = table.rows.find(row => row.state == tuple._1).get
      val qbrow = table.rows.find(row => row.state == tuple._2).get
      if (qarow.group == qbrow.group) {
        i = i+1
      }
    }
    val preDifferent = tables(i-1)
    val qarow = preDifferent.rows.find(row => row.state == tuple._1).get
    val qbrow = preDifferent.rows.find(row => row.state == tuple._2).get
    val event = eventForRow(qarow, qbrow, events)
    (event._1, (event._2, event._3))
  }

  def eventForRow(qarow: Row, qbrow: Row, events: Array[Event]): (Event, State, State) = {
    val pairs = (qarow.next zip qbrow.next).zipWithIndex
    val diff = pairs.find{
      p =>
        val left = p._1._1
        val right = p._1._2
        left.group != right.group

    }.get
    (events(diff._2), diff._1._1.node, diff._1._2.node)
  }

}

case class Group(id: Int)

case class Row(group: Group, state: State, next: List[StateWithGroup])

case class State(name: String)

case class StateWithGroup(node: State, group: Group)

case class Table(rows: List[Row])
