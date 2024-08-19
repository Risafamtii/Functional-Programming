import scala.io.StdIn.readInt

object A2 {
  val evaluate: Int => Unit = (k: Int) => k match {
    case n if n < 0 => println("Number is negative")
    case 0 => println("The number is zero")
    case n if n % 2 == 0 => println("Number is an even number")
    case _ => println("Number is an odd number")
  }

  def main(args: Array[String]): Unit = {
    print("Enter number = ")
    val number = readInt()
    evaluate(number)  
  }
}
