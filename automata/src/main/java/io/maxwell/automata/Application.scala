package io.maxwell.automata

import com.typesafe.config.ConfigFactory

/**
  * @author Marek Timr
  */
object Application {
  def main(args: Array[String]): Unit = {
    val settings = ConfigFactory.load().getConfig("automata")
    val inputFileName = settings.getString("input-csv")
    val automata = new AutomataParser(inputFileName).getAutomata

    print(automata.output(
      List(
        Event("e38"),
        Event("e08"),
        Event("e20"),
        Event("e20"),
        Event("e38"))))
  }
}
