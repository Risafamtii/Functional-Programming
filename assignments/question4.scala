object question4 extends App {

    def EvenSum () : Int = {

        println("How Many Numbers Do You Want To Enter : ") ;
        val num = scala.io.StdIn.readInt() ;

        var Numbers = new Array[Int](num) ;
        var Count = 0 ;

        for (i<-0 until num) {
            println("Enter Number " + (i+1) + " : ") ;
            Numbers(i) = scala.io.StdIn.readInt() ;

            if (Numbers(i)%2 ==0) {
                Count = Count + Numbers(i) ;
            }
        }

        Count ;
    }

    val Sum = EvenSum() ;
    println("The Sum Of Even Numbers In The List Is : " + Sum) ;
}