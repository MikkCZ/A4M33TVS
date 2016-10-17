package tvs.a4m33.tabulator

import java.io.{FileWriter, PrintWriter, Writer}

import scala.io.Source

/**
  * Created by Maxwell
  */
object Tabulator {

  def main(args: Array[String]): Unit = {
    val parsed = parseArgs(args)
    parsed match {
      case Some(config) =>
        implicit val implicitConfig = config
        parseInput match {
          case Some(input) =>
            prettyPrint(input)
          case None =>
            println("Failed to read input")
            System.exit(1)
        }
      case None => printHelp()
    }
  }

  def prettyPrint(input: Seq[Seq[String]])(implicit config: Config): Unit = {
    val writer = getWriter
    writer.append(s"""<table style="${config.flags.getOrElse("css-table", "")}">\n""")
    var toWrite = input
    config.flags get "header" match {
      case Some(_) =>
        writer.append(s"""\t<thead style="${config.flags.getOrElse("css-thead", "")}">\n""")
        toWrite.head.foreach(s => writer.append(s"""\t\t<th style="${config.flags.getOrElse("css-th", "")}">$s</th>\n"""))
        writer.append(s"""\t</thead>\n""")
        toWrite = toWrite.tail
      case None =>
    }
    for (line <- toWrite) {
      writer.append(s"""\t<tr style="${config.flags.getOrElse("css-tr", "")}">\n""")
      config.flags get "vertical-header" match {
        case Some(_) =>
          writer.append(s"""\t\t<th style="${config.flags.getOrElse("css-th", "")}">${line.head}</th>\n""")
          line.tail.foreach(s => writer.append(s"""\t\t<td style="${config.flags.getOrElse("css-td", "")}">$s</td>\n"""))
        case None =>
          line.foreach(s => writer.append(s"""\t\t<td style="${config.flags.getOrElse("css-td", "")}">$s</td>\n"""))
      }
      writer.append(s"""\t</td>\n""")
    }
    writer.append("""</table>""")
    writer.close()
  }

  def getWriter(implicit config: Config): Writer = {
    config.target match {
      case Some(target) => new FileWriter(target)
      case None => new PrintWriter(System.out)
    }
  }

  def parseArgs(args: Array[String]): Option[Config] = {
    if(args.isEmpty || args.head == "help" || args.head == "-h" || args.head == "--help") {
      return None
    }
    val headerFlag = """--header""".r
    val verticalFlag = """--vertical-header""".r
    val delimiterFlag = """--delimiter""".r
    val cssFlag ="""--css-(.*)""".r
    def parseFlag(flags: Map[String, String], args: List[String]): Option[(Map[String, String], List[String])] = {
      args match {
        case flag :: sx => {
          flag match {
            case headerFlag() => parseFlag(flags + ("header" -> ""), args.tail)
            case verticalFlag() => parseFlag(flags + ("vertical-header" -> ""), args.tail)
            case delimiterFlag() if sx.nonEmpty => parseFlag(flags + ("delimiter" -> sx.head), args.drop(2))
            case cssFlag(tag) if sx.nonEmpty => parseFlag(flags + (s"""css-$tag""" -> sx.head), args.drop(2))
            case _ => Some((flags, args))
          }
        }
        case _ => Some((flags, Nil))
      }
    }
    parseFlag(Map.empty, args.toList) match {
      case Some((flags, rest)) =>
        val configWithFlags = buildConfig(flags) _
        rest match {
          case source :: destination :: sx => Some(configWithFlags(source)(Some(destination)))
          case source :: sx => Some(configWithFlags(source)(None))
          case Nil => None
        }
      case None => None
    }
  }

  def buildConfig(flags: Map[String, String])(source: String)(target: Option[String]) = {
    Config(flags, source, target)
  }

  def printHelp() = {
    println(
      """
        | ---- TABULATOR ----
        | pouzij java -jar tabulator.jar [--flags] <soubor> [cilovy_soubor]
        | maformatuje data v souboru do markdownu. hodnoty separovane mezerou, carkou, tabem nebo strednikem.
        | Co najde prvni, to pouzije.
        | tabulku vypise do console nebo do cilovy_soubor
        |
        | Flagy
        | --header              prvni radka dat je header
        | --vertical-header     prvni sloupec obsahuje header data
        | --delimiter "<value>" co ma byt pouzito za delimiter, duh...
        | --css-<tag> "<css>"   tag muze byt table, th, tr, td, thead. Nastavi css pravidla tagu
        |
      """.stripMargin
    )
  }

  def parseInput(implicit config: Config): Option[Seq[Seq[String]]] = {
    def delimiter(line: String): String = {
      config.flags get "delimiter" match {
        case Some(delimiter) => delimiter
        case None => line.find(c => c == ' ' || c == '\t' || c == ';' || c == ',') match {
          case Some(delimiter) => delimiter.toString
          case None => " "
        }
      }
    }
    val lines = Source.fromFile(config.source).getLines().toList
    lines match {
      case first :: rest => Some(lines.map(_.split(delimiter(first)).toSeq))
      case _ => None
    }
  }

  case class Config(flags: Map[String, String], source: String, target: Option[String])

}
