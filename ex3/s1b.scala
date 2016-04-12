import scala.math.abs

object timer2 extends App {
  val d = new MinSek(3, 14)
  val e = new MinSek(-3, -10)
  println(d + " ja " + e)   // 3:14 ja -3:10
  d += e
  println(d)                // 0:04
  d -= e
  println(d)                // 3:14

  // kasvattava ja vähentävä sijoitusoperatio MinSek-arvolle ja kokonaisluvulle
  val f = new MinSek(3, 14)
  println(f)                // 3:14
  f += 61
  println(f)                // 4:15
  f -= 6000
  println(f)                // -95:45

  // kertova ja jakava sijoitusoperaatio MinSek-arvolle ja kokonaisluvulle
  val g = new MinSek(3, 14)
  println(g)                // 3:14
  g *= 2
  println(g)                // 6:28
  g /= 3
  println(g)                // 2:09

  // onko seuraava vaarallista?
  val h = new MinSek
  val i = h
  println(h + " ja " + i)   // 0:00 ja 0:00
  h += 666
  println(h + " ja " + i)   // 11:06 ja 11:06
}

class MinSek(private var value: Int = 0) {

  def this(min: Int, sec: Int) {
    this(min * 60 + sec)
  }

  def unary_- = new MinSek(-value)

  def +=(that: MinSek) = value += that.value
  def -=(that: MinSek) = value -= that.value

  def +=(that: Int) = value += that
  def -=(that: Int) = value -= that

  def *=(that: Int) = value *= that
  def /=(that: Int) = value /= that

  override def toString = {
    def stringify(num: Int) = {
      if (num < 10) s"0${num}"
      else num.toString
    }
    val sec = abs(value % 60)

    if (value < 0 && value > -60) s"-0:${stringify(sec)}"
    else s"${value / 60}:${stringify(sec)}"
  }
}
