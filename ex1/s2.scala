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
  def findWordByUserInput(lines: List[(String, Int)], word: String): Int = {
    if (word == "") 0
    else {
      lines.filter { case(line, _) => line contains word }
           .foreach { case(line, i) => println(i + ": " + line) }
      findWordByUserInput(lines, askForWord())
    }
  }

  def askForWord(): String = {
    println("\nMitä sanaa etsitään? Tyhjä lopettaa.")
    readLine
  }

  try {
    val lines = Source.fromFile(args(0)).getLines().zipWithIndex.toList
    findWordByUserInput(lines, askForWord())
  } catch {
    case e: FileNotFoundException => println("Tiedostoa ei löytynyt!")
    case e: ArrayIndexOutOfBoundsException => println("Anna tiedoston polku parametrina!")
  }
}
