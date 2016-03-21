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

println("a) Print a triangle by a given height.")
triangle()
