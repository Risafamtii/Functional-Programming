object question1 extends App {
    def ReverseString(string : String) : String = {
        if (string.nonEmpty) {
            ReverseString(string.tail) + string.head ;
        }
        else {
            "" ;
        }
    }
    println("Enter The string You Want To Reverse : ") ;
    val string = scala.io.StdIn.readLine() ;

    val Reversed = ReverseString(string) ;
    println("The Reverse Of " + string + " Is : " + Reversed) ;
}
