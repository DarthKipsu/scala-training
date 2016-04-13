import java.io.File

import scala.annotation.tailrec
import scala.io.StdIn.readLine

object interpreter extends App {
  def newCommand() = readLine("repl> ").trim.toLowerCase

  def printUsageInstrucions() {
    println("""|Unknown command!
               |Usage: ls [option]... Lists filenames in current directory in alphabetical order
               |          -e Lists filenames ending with the given argument
               |          -b Lists filenames starting with the given argument
               |          -c Lists filenames containing the given argument
               |       lo Guits program""".stripMargin)
    interpret(newCommand)
  }

  def printFilteredFileNames(x: String, filterFn: String => Boolean) {
    if (x.nonEmpty) directoryFileNames.filter(filterFn).foreach(println)
    else println("Add parameter after option!")
    interpret(newCommand)
  }

  @tailrec
  def interpret(command: String): Unit = {
    command match {
      case "lo" => // exit program
      case "ls" => directoryFileNames.foreach(println)
                   interpret(newCommand)
      case nameEndsIn(x) => printFilteredFileNames(x, _.endsWith(x))
      case nameBeginsWith(x) => printFilteredFileNames(x, _.startsWith(x))
      case nameContains(x) => printFilteredFileNames(x, _.contains(x))
      case _ => printUsageInstrucions()
    }
  }

  val nameEndsIn = "ls -e ?(.*)".r
  val nameBeginsWith = "ls -b ?(.*)".r
  val nameContains = "ls -c ?(.*)".r
  val directoryFileNames = new File(System.getProperty("user.dir"))
      .listFiles.filter(_.isFile).map(_.getName()).toList.sorted

  interpret(newCommand)
}
