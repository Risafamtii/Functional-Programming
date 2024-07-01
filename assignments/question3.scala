object question2 extends App {

    def ArithmeticMean(num1 : Int , num2 : Int) : Unit = {
        var mean = (num1+num2)/2 ;

        val floatMean = f"$mean%.2f" ;
        println ("The Arithmetic Mean Of " + num1 + " , " + num2 + " Is : " + floatMean) ;
    }

    ArithmeticMean(12,15) ;
}