object Q1 {
  def main(args: Array[String]): Unit = {
    val obj = new Rational(1, 2)
    val objj = new Rational(4, 5)

    println(s"Negation of $obj: ${obj.neg}")

    val sum = obj.add(objj)
    println(s"Sum of $obj and $objj: $sum")
  }

  class Rational(n: Int, d: Int) {
    require(
      d > 0,
      "Denominator must be greater than 0"
    )

    def numer: Int = n
    def denom: Int = d

    def add(r: Rational): Rational = new Rational(
      this.numer * r.denom + this.denom * r.numer,
      this.denom * r.denom
    )

    def neg: Rational = new Rational(-this.numer, this.denom)

    override def toString: String = s"$numer/$denom"
  }
}
