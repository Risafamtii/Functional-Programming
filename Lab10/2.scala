object Q2 {
  def main(args: Array[String]): Unit = {
    val x = new RationalNumber(3, 4)
    val y = new RationalNumber(5, 8)
    val z = new RationalNumber(2, 7)

    val a = x - y - z

    println(a)
  }
}

class RationalNumber(n: Int, d: Int) {
  require(d > 0, "Denominator must be greater than 0")

  def numer: Int = n
  def denom: Int = d

  def neg: RationalNumber = new RationalNumber(-this.numer, this.denom)

  def add(r: RationalNumber): RationalNumber = {
    val numerator = this.numer * r.denom + this.denom * r.numer
    val denominator = this.denom * r.denom
    new RationalNumber(numerator, denominator).simplify
  }

  def -(r: RationalNumber): RationalNumber = this.add(r.neg)

  def simplify: RationalNumber = {
    val gcd = greatestCommonDivisor(numer.abs, denom.abs)
    new RationalNumber(numer / gcd, denom / gcd)
  }

  private def greatestCommonDivisor(a: Int, b: Int): Int = {
    if (b == 0) a else greatestCommonDivisor(b, a % b)
  }

  override def toString: String = s"$numer/$denom"
}
