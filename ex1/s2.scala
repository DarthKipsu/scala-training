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
