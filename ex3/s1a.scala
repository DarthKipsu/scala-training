import scala.math.abs

object timer1 extends App {
  // konstruointi ja negatiiviset parametrit
  var a = new MinSek(2,11)
  println(a)               // 2:11
  a = new MinSek(2,-11)
  println(a)               // 1:49
  a = new MinSek(-2,11)
  println(a)               // -1:49
  a = new MinSek(-2,-11)
  println(a)               // -2:11
  
  a = new MinSek(66)
  println(a)               // 1:06   Huom: sekunnit siis aina 2 numerolla!
  a = new MinSek
  println(a)               // 0:00
  println(new MinSek(-21)) // -0:21
  println(new MinSek(-1))  // -0:01
  a = new MinSek(1,601)
  println(a)               // 11:01
  
  // infix operaatiot + ja - kahdelle MinSek-arvolle
  val b = new MinSek(2,45)
  val c = new MinSek(49)
  println(b + " ja " + c)  // 2:45 ja 0:49
  a = b + c
  println(a)               // 3:34
  println(b - c)           // 1:56
  println(c - b)           // -1:56
  println(b - c + a)       // 5:30
  println(b - a)           // -0:49
  
  // infix-operaatiot * ja / MinSek-arvolle ja kokonaisluvulle
  a = new MinSek(2,11)
  println(a)               // 2:11
  println(a * 2)           // 4:22
  println(a / 2)           // 1:05
  
  println(a * -2)           // -4:22
  println(a / -2)           // -1:05
  
  // prefix-operaatio - vastaluvun laskentaan
  println(-a)               // -2:11
  println(-(-a))            // 2:11
}

class MinSek(val value: Int = 0) {

  def this(min: Int, sec: Int) {
    this(min * 60 + sec)
  }

  def unary_- = new MinSek(-value)

  def +(that: MinSek) = new MinSek(value + that.value)
  def -(that: MinSek) = new MinSek(value - that.value)

  def *(that: Int) = new MinSek(value * that)
  def /(that: Int) = new MinSek(value / that)

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
