import scala.language.postfixOps

trait KoristellenTulostettava {
  def koristettava: String
  def koristemerkki: Char
  def reunusta = println(koristemerkki + koristettava + koristemerkki)
  def alleviivaa = println(koristettava + "\n" + koristemerkki.toString * koristettava.length)
  def ylleviivaa = println(koristemerkki.toString * koristettava.length + "\n" + koristettava)
  def ymparoi = {
    val viivaus = koristemerkki.toString * (koristettava.length + 2)
    println(viivaus)
    reunusta
    println(viivaus)
  }
}

class Kuka(var nimi: String) extends KoristellenTulostettava {
  override def koristettava = nimi
  override val koristemerkki = '*'
}

class Luku(var arvo: Int) extends KoristellenTulostettava {
  override def koristettava = " " + arvo * 2 + " "
  override def koristemerkki = math.abs(arvo)%256 toChar
}

class Huutaen(val sana: String) extends KoristellenTulostettava {
  override def koristettava = sana.toUpperCase
  override val koristemerkki = '!'
}

val pm = new Kuka("Putin")
pm.reunusta                    // *Putin*
pm.nimi = "Obama"
pm.reunusta                    // *Obama*

println
pm.alleviivaa
println
pm.ylleviivaa
println
pm.ymparoi
println

val se = new Luku(42)
se.reunusta           // * 84 *
se.arvo = 93
se.reunusta           // ] 186 ]
se.arvo = -3301
se.reunusta           // å -6602 å

println
se.alleviivaa
println
se.ylleviivaa
println
se.ymparoi
println

val iso = new Huutaen("Heippa")
iso.reunusta
println
iso.alleviivaa
println
iso.ylleviivaa
println
iso.ymparoi
