def filterEvenNumber(array : Array[Int]) : Array[Int] = {
    array.filter(x=> x%2==0) ;
}

object question1 extends App {
    println("How Many Numbers Do You Want To Enter : ") ;
    val num = scala.io.StdIn.readInt() ;
    val numbers = new Array[Int](num) ;

    for (i<-0 until num) {
        println("Enter Number " + (i+1)) ;
        numbers(i) = scala.io.StdIn.readInt() ;
    }

    val evenNumbers = filterEvenNumber(numbers)
    println("The Even Numbers In The Numbers You Entered Are : ") ;

    for (i<-0 until evenNumbers.length) {
        println(evenNumbers(i)) ;
    }

}