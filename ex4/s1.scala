
def f(n: String, i: Int) = println(n + ": " + i)
def g(n: String) (i: Int) = println(n + ": " + i)

f("n", 1)
g("n")(1)

