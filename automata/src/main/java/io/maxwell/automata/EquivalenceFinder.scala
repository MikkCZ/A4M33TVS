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
      state.transitions(events(0)).output,
      state.transitions(events(1)).output,
      state.transitions(events(2)).output,
      state.transitions(events(0)).target,
      state.transitions(events(1)).target,
      state.transitions(events(2)).target)
    }

    val croppedNodes = initialTable.map { //Nebudou existovat cykly v objektech a ja nebudu muset debuggovat StackOverflow errory
      row =>
        (State(row._1.name),
          row._2,
          row._3,
          row._4,
          State(row._5.name),
          State(row._6.name),
          State(row._7.name))
    }

    val tableP0 = croppedNodes.map{node =>
      val state = node._1
      Row(
        new Group(0),
        state,
        StateWithGroup(state, new Group(node._2.name.hashCode)),
        StateWithGroup(state, new Group(node._2.name.hashCode)),
        StateWithGroup(state, new Group(node._2.name.hashCode))
      )
    }

    val grouped = croppedNodes.groupBy { row => (row._2, row._3, row._4) } // seskup je podle stejnych vystupu

    val numberedGroups = grouped
      .values
      .map { group => group.map { row => (row._1, (row._5, row._6, row._7)) } } //orezej vystupy
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
              StateWithGroup(targets._1, stateGroup(targets._1)),
              StateWithGroup(targets._2, stateGroup(targets._2)),
              StateWithGroup(targets._3, stateGroup(targets._3)))
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
         subscriptGroup <- rows.groupBy(row => (row.next1.group, row.next2.group, row.next3.group));
         groupNumber = nextGroupNumber();
         subscriptRow <- subscriptGroup._2) {

      newNaming += (subscriptRow.state -> Group(groupNumber))
    }

    Table(table.rows.map {
      row =>
        Row(
          newNaming(row.state),
          row.state,
          StateWithGroup(row.next1.node, newNaming(row.next1.node)),
          StateWithGroup(row.next2.node, newNaming(row.next2.node)),
          StateWithGroup(row.next3.node, newNaming(row.next3.node))
        )
    }.sortBy(row => row.group.id))
  }

  if (events.length != 3) {
    throw new IllegalArgumentException(s"je tu hardcodovano, ze eventy jsou presne 3. Dostal jsem ${events.length} event")
  }

}

case class State(name: String)

case class Group(id: Int)

case class StateWithGroup(node: State, group: Group)

case class Row(group: Group, state: State, next1: StateWithGroup, next2: StateWithGroup, next3: StateWithGroup)

case class Table(rows: List[Row])
