import scala.math.pow

object complex_numbers extends App {
  val a = Complex(5.16, 2.97)
  val b = Complex(-3.7, -9.813)
  println("a: " + a)
  println("b: " + b)

  println("\n-a: " + -a)
  println("-b: " + -b)

  println("\na+b: " + (a+b))
  println("a-b: " + (a-b))
  println("a*b: " + (a*b))
  println("b^-1: " + b.inverse)
  println("a/b: " + (a/b))
}

object Complex {
  def apply(re: Double, im: Double) = {
    new Complex(re, im)
  }
}

class Complex(val re: Double, val im: Double) {

  def +(that: Complex) = Complex(re + that.re, im + that.im)
  def unary_- = Complex(-re, -im)
  def -(that: Complex) = this + -that
  def *(that: Complex) = Complex(re * that.re - im * that.im, re * that.im + im * that.re)
  def inverse = Complex(re / (pow(re,2) + pow(im,2)), im / (pow(re,2) + pow(im,2)))
  def /(that: Complex) = this * that.inverse

  override def toString = {
    if (im < 0) s"${re}${im}i"
    else s"${re}+${im}i"
  }
}
