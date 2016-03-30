// Examples for using some list operations

val words = List("tämä", "on", "lista", "joka", "sisältää", "eri", "pituisia", "sanoja")

println(s"count, longer than 4 letters: ${words.count(_.length > 4)}")
println(s"count, equals 'sanoja': ${words.count(_ == "sanoja")}")
println(s"count, you can also do it like this: ${words.count(s => s == "sanoja")}\n")

println(s"exists, word 'sana' or 'sanoja': ${words.exists(s => s == "sana" || s == "sanoja")}")
println(s"exists, a word with even length: ${words.exists(_.length % 2 == 0)}\n")

println(s"filter, words with length 4: ${words.filter(_.length == 4)}")
println(s"filter, words with letter 'ä': ${words.filter(_.contains("ä"))}")
println(s"filter, words starting with 's': ${words.filter(_.startsWith("s"))}\n")

println(s"forall, all words are length 4: ${words.forall(_.length == 4)}")
println(s"forall, all words are shorter than 10 letters: ${words.forall(_.length < 10)}")
println(s"forall, all words contain ääkkösiä: ${words.forall(s => s.contains("ä") || s.contains("ö"))}\n")

println(s"foreach, print each word:")
words.foreach(println)
println(s"\nforeach, print each word twice:")
words.foreach(s => println(s * 2))

println(s"\nmap, reversed list: ${words.map(_.reverse)}")
println(s"map, map ds from list with word lengths: ${words.map(s => s -> s.length) toMap}\n")

println(s"""remove, return list without words containing ääkkösiä:
  (remove is depracated in 2.8 and removed in 2.9, so using filterNot)
  ${words.filterNot(s => s.contains("ä") || s.contains("ö"))}""")
