object question1 extends App {

    def namesLessThan () : Unit = {
        println("How Many Names Do You Want To Enter : ") ;
        val num = scala.io.StdIn.readInt() ;

        var names = new Array[String](num) ;
        var biglNames = new Array[String](num) ;

        for (i <- 0 until num) {
            println("Enter Name " + (i+1) + " : ") ;
            names(i) = scala.io.StdIn.readLine() ;
        }

        var count = 0 ;

        for (i<-0 until num) {
            if(names(i).length>5) {
                biglNames(count) = names(i) ;
                count = count + 1 ;
            }
        }

        println("There are " + count + " Names With More Than 5 Character And They Are : ") ;

        for (i<-0 until count) {
            println(biglNames(i)) ;
        }
    }

    namesLessThan() ;

}