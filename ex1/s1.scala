import scala.io.StdIn._

def triangle() = {
  print("Give triangle height: ")
  val height = readInt

  for (i <- 1 to height) {
    val spaces = " " * (height - i)
    val stars = "*" * (2 * i - 1)
    println(spaces + stars)
  }
}

def leap() = {

  def isLeapYear(year: Int) = {
    if (year % 100 == 0) (year % 400 == 0 && year != 4000)
    else year % 4 == 0
  }
  
  println("Give years: (separated by enter)")
  val year1, year2 = readInt
  val iterDirection = if (year1 < year2) 1 else -1

  (year1 to year2 by iterDirection).filter(isLeapYear).foreach(println)
}

println("a) Print a triangle by a given height.")
triangle()

println("\nb) Print leap years between (year year).")
leap()

println()
