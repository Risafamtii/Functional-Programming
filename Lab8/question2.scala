object question2 extends App {
    println("Enter a number: ") ;
    val num = scala.io.StdIn.readInt() ;

    val message = num match {
        case num if (num%3==0 && num%5==0) => "Multiple of Both Three and Five"  ;
        case num if (num%3==0) => "Multiple of Three" ;
        case num if (num%5==0) => "Multiple of Five" ;
        case _ => "Not a Multiple of Three or Five" ;
    }

    println(message) ;
}