
object counter extends App {
  val a = new Seccounter
  val b = Seccounter()
  println("a: " + a)
  println("b: " + b)

  for (i <- 0 to 1000) {
    if (i % 2 == 0) a.incSecond
    b.incSecond
  }
  print("a 500 seconds later: ")
  println(a)
  print("b 1000 seconds later: ")
  println(b)
  for (i <- 0 to 90000) {
    if (i % 2 == 0) a.incSecond
    b.incSecond
  }
  print("a 45 000 seconds later: ")
  println(a)
  print("b 90 000 seconds later: ")
  println(b)
}

object Seccounter {
  def apply() = {
    new Seccounter
  }
}

class Seccounter(private var sec: Int,
                 private var min: Int,
                 private var hour: Int) {
  def this() {
    this(0,0,0)
  }

  def getSeconds = sec
  def getMinutes = min
  def getHours = hour

  def incSecond() = {
    if (sec == 59) {
      if (min == 59) {
        if (hour == 23) hour = 0
        else hour += 1

        min = 0
      } else {
        min += 1
      }
      
      sec = 0
    } else {
      sec += 1
    }
  }

  def stringify(number: Int): String = {
    if (number < 10) s"0${number}"
    else number.toString
  }

  override def toString = {
    s"${stringify(hour)}:${stringify(min)}:${stringify(sec)}"
  }
}