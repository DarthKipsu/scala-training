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

  def +(x: Complex) = Complex(re + x.re, im + x.im)
  def unary_- = Complex(-re, -im)
  def -(x: Complex) = this + -x
  def *(x: Complex) = Complex(re * x.re - im * x.im, re * x.im + im * x.re)
  def inverse = Complex(re / (pow(re,2) + pow(im,2)), im / (pow(re,2) + pow(im,2)))
  def /(x: Complex) = this * x.inverse

  override def toString = {
    if (im < 0) s"${re}${im}i"
    else s"${re}+${im}i"
  }
}
