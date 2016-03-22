import java.io.FileNotFoundException

import scala.annotation.tailrec
import scala.io.Source
import scala.io.StdIn._

object pelaa extends App {
  val rightAnswer = (10 * math.random).toInt

  println("Make three guesses:")
  val g1, g2, g3 = readInt

  var winnings = 0
  if (g1 == rightAnswer) winnings += 400
  if (g2 == rightAnswer) winnings += 200
  if (g3 == rightAnswer) winnings += 100

  println("Right answer was " + rightAnswer)
  if (winnings > 0) println("You win " + winnings + " virtual euros!")
  else println("You lose 100 virtual euros...")
}

object findWord extends App {
  @tailrec
  def findWordByUserInput(lines: List[String], word: String): Int = {
    if (word == "") 0
    else {
      printLinesWith(lines, word, 1)
      findWordByUserInput(lines, askForWord())
    }
  }

  def askForWord(): String = {
    println("\nMitä sanaa etsitään? Tyhjä lopettaa.")
    readLine
  }

  @tailrec
  def printLinesWith(lines: List[String], wordToSearch: String, line: Int): Int = {
    if (lines.isEmpty) 0
    else {
      if (lines.head contains wordToSearch) println(line + ": " + lines.head)
      printLinesWith(lines.tail, wordToSearch, line++)
    }
  }

  try {
    val lines = Source.fromFile(args(0)).getLines().toList
    findWordByUserInput(lines, askForWord())
  } catch {
    case e: FileNotFoundException => println("Tiedostoa ei löytynyt!")
    case e: ArrayIndexOutOfBoundsException => println("Anna tiedoston polku parametrina!")
  }
}
