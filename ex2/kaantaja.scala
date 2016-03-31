import java.io.FileNotFoundException

import scala.annotation.tailrec
import scala.io.Source
import scala.io.StdIn._

object kaantaja extends App {
  @tailrec
  def translate(dictionary: Map[String, String]): Int = {
    val word = readLine
    if (word == "") 0
    else {
      try {
        println(dictionary(word))
      } catch {
        case e: NoSuchElementException => println("VIRHE: En tunne sanaa " + word)
      }
      translate(dictionary)
    }
  }

  try {
    val lines = Source.fromFile(args(0)).getLines().grouped(2).toList
    val dictionary = lines.map(s => s(0) -> s(1)).toMap

    println("Sanat opittu! (tyhjä kysymysrivi lopettaa)")
    translate(dictionary)
  } catch {
    case e: FileNotFoundException => println("Sanakirjaa ei löytynyt!")
    case e: ArrayIndexOutOfBoundsException => println("Anna sanakirjan polku parametrina!")
  }
}
