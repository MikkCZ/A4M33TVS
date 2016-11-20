package io.maxwell.automata

import com.typesafe.config.ConfigFactory

/**
  * @author Marek Timr
  */
object Application {
  def main(args: Array[String]): Unit = {
    val settings = ConfigFactory.load().getConfig("automata")
    val inputFileName = settings.getString("input-csv")
    val inputParser = new AutomataParser(inputFileName)
    val automata = inputParser.getAutomata

    val eqFinder = new EquivalenceFinder(automata, inputParser.getEvents)
    val table = eqFinder.findEquivalence()
    print(table)
  }
}
