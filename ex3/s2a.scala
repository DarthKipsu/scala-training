
object prime extends App {
  println(Primes.first(15))       // First 15 primes
  println(Primes.upTo(15))        // Primes until 15
  println(Primes.between(15, 50)) // Primes between 15 and 50

  object Primes {
    val primeStream = Stream.from(2).filter(isPrime)

    def isPrime(x: Int) = (x >= 2) && !(2 to (x - 1)).exists(x % _ == 0)

    def first(n: Int) = primeStream.take(n).toList

    def upTo(x: Int) = primeStream.takeWhile(_ <= x).toList

    def between(x: Int, y: Int) = {
      Stream.from(x).filter(isPrime).takeWhile(_ <= y).toList
    }
  }
}
