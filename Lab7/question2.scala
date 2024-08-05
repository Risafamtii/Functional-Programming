def calculateSquare(array : Array[Int]) : Array[Int] = {
    array.map((x:Int) => x*x) ;
}

object question2 extends App {
    println("How Many Numbers Do You Want To Enter : ") ;
    val num = scala.io.StdIn.readInt() ;
    val numbers = new Array[Int](num) ;

    for (i<-0 until num) {
        println("Enter Number " + (i+1)) ;
        numbers(i) = scala.io.StdIn.readInt() ;
    }

    val squareNumbers = calculateSquare(numbers)
    println("The Squared Of The Numbers You Entered Are : ") ;

    for (i<-0 until squareNumbers.length) {
        println(squareNumbers(i)) ;
    }

}