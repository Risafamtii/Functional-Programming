def isPrime(x : Int) : Boolean = {
    if (x<=1) {
        false 
    }
    else {
        var prime = true ;
        for (i<- 2 to math.sqrt(x).toInt) {
            if (x%i == 0) {
                prime = false ;
            }
        }
        prime ;
    }
}

def filterPrime(array : Array[Int]) : Array[Int] = {
    array.filter(x=> isPrime(x) ) ;
}



object question3 extends App {
    println("How Many Numbers Do You Want To Enter : ") ;
    val num = scala.io.StdIn.readInt() ;
    val numbers = new Array[Int](num) ;

    for (i<-0 until num) {
        println("Enter Number " + (i+1)) ;
        numbers(i) = scala.io.StdIn.readInt() ;
    }

    val primeNumber = filterPrime(numbers)
    println("The Prime Numbers In The Numbers You Entered Are : ") ;

    for (i<-0 until primeNumber.length) {
        println(primeNumber(i)) ;
    }

}