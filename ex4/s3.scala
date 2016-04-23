abstract class Elain (nimi:String, private var paino0:Int) {
  if (paino0 < 1) paino0 = 1
  def aantele: Unit
  def paino = paino0
  def asetaPaino(p:Int) = if (p > 0) paino0 = p
  def syo = paino0 += 1
  def ulosta = paino0 -= 1
  override def toString = nimi
}

trait Lypsava extends Elain {
  Lypsava.tunnus += 1
  val tunnus = Lypsava.tunnus
  def lypsa = {
    val maara = paino / 5
    if (paino - maara > 4) {
      asetaPaino(paino - maara)
      maara
    } else {
      println("Liian laiha, ei voida lypsää!")
      0
    }
  }
  def potkaise:Unit
  override def toString = super.toString + " (" + tunnus + ")"
}

object Lypsava {
  private var tunnus = 0
}

trait Peto extends Elain {
  override def syo = {
    super.syo
    super.syo
  }
}

class Kissa(nimi:String, paino:Int, naukumistiheys:Int) extends Elain(nimi, paino)  {
  override def aantele {println("Miau")}
  override def toString = super.toString + "-" + naukumistiheys
}

class Koira(nimi:String, paino:Int) extends Elain(nimi, paino) with Peto  {
  override def aantele {println("Hau")}
}

class Hevonen(nimi:String, paino:Int) extends Elain(nimi, paino)  {
  override def aantele {println("Ihahaa")}
}

class Tamma(nimi:String, paino0:Int) extends Hevonen(nimi, paino0) with Lypsava {
  def potkaise {println("Tamma potkaisee")}
}

class Nauta(nimi:String, paino:Int) extends Elain(nimi, paino)  {
  override def aantele {println("Ammuu")}
}

class Lehma(nimi:String, paino0:Int) extends Nauta(nimi, paino0) with Lypsava {
  def potkaise {println("Lehmä potkaisee")}
}

class Vuohi(nimi:String, paino:Int) extends Elain(nimi, paino)  {
  override def aantele {println("Baa")}
}

class Kuttu(nimi:String, paino0:Int) extends Vuohi(nimi, paino0) with Lypsava {
  def potkaise {println("Kuttu potkaisee")}
}

def juustoa(tuotantoelain: Lypsava):Double = {
  42 * tuotantoelain.lypsa
}

val lehma = new Lehma("Mansikki", -5)
println(lehma)
println(lehma.paino)
lehma.asetaPaino(5)
lehma.asetaPaino(-5)
println(lehma.paino)
println("lehmä syö")
lehma.syo
println(lehma.paino)
println("lehmä ulostaa")
lehma.ulosta
println(lehma.paino)
lehma.lypsa
println("lehmä syö")
lehma.syo
lehma.lypsa
println(lehma.paino)
val tamma = new Tamma("Hepo", 12)
println(tamma)
println(lehma)

println()
val koira = new Koira("Musti", 4)
println(koira)
println(koira.paino)
println("koira syö")
koira.syo
println(koira.paino)
