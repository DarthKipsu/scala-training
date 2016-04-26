class Opiskelija(val nimi: String, var harjoitusPisteet: Int, var koePisteet: Int) {
  def kokonaisPisteet = harjoitusPisteet + koePisteet
  override def toString = nimi + ": " + kokonaisPisteet
}

abstract class OpiskelijaJoukko {
  def vie(x: Opiskelija): Unit
  def poista(x: Opiskelija): Unit
}

class ToteutettuOpiskelijaJoukko extends OpiskelijaJoukko {
  import scala.collection.mutable.HashSet

  private val joukko = new HashSet[Opiskelija]
  def vie(x: Opiskelija) {joukko += x}
  def poista(x: Opiskelija) {joukko -= x}
  override def toString = joukko.toString
}

trait Koeleikkuri extends OpiskelijaJoukko {
  abstract override def vie(x: Opiskelija) = if (x.koePisteet >= 23) super.vie(x)
}

trait Hyvaksytyt extends OpiskelijaJoukko {
  abstract override def vie(x: Opiskelija) = if (x.kokonaisPisteet >= 30) super.vie(x)
}

trait OnnilleViisPlus extends OpiskelijaJoukko {
  abstract override def vie(x: Opiskelija) = {
    if ((x.nimi contains "onni") || (x.nimi contains "Onni")) x.koePisteet += 5
    super.vie(x)
  }
}

val masa = new Opiskelija("Matti Mainio", 7, 36)

println(masa.kokonaisPisteet)  // 43

val kurssi = new  ToteutettuOpiskelijaJoukko

val jusa = new Opiskelija("Jussi Juonio", 2, 18)
kurssi.vie(masa)
kurssi vie jusa
kurssi vie new Opiskelija("Saku Sammakko", 19, 23)

println(kurssi) // Set(Saku Sammakko: 42, Matti Mainio: 43, Jussi Juonio: 20)

kurssi poista jusa

println(kurssi) // Set(Saku Sammakko: 42, Matti Mainio: 43)

println("\nKoeleikkurista läpi:")
val p = new ToteutettuOpiskelijaJoukko with Koeleikkuri
p vie new Opiskelija("Matti Mainio", 7, 36)
p vie new Opiskelija("Saku Sammakko", 19, 23)
p vie new Opiskelija("Lauri Laiskiainen", 0, 25)
p vie new Opiskelija("Onni Tsägälläläpi", 2, 18)
println(p)

println("\nHyväksytyt ilman koeleikkuria:")
val h = new ToteutettuOpiskelijaJoukko with Hyvaksytyt
h vie new Opiskelija("Matti Mainio", 7, 36)
h vie new Opiskelija("Saku Sammakko", 19, 23)
p vie new Opiskelija("Lauri Laiskiainen", 0, 25)
h vie new Opiskelija("Onni Tsägälläläpi", 12, 18)
println(h)

println("\nHyväksytyt ja koeleikkurista läpi kun Onnille +5:")
val v = new ToteutettuOpiskelijaJoukko with Hyvaksytyt with Koeleikkuri with OnnilleViisPlus // Tässä järkällä väliä, jos ei lisätä pojoja Onnille ensin niin se feilaa koeleikkurin
v vie new Opiskelija("Matti Mainio", 7, 36)
v vie new Opiskelija("Saku Sammakko", 19, 23)
p vie new Opiskelija("Lauri Laiskiainen", 0, 25)
v vie new Opiskelija("Onni Tsägälläläpi", 12, 18)
println(v)
