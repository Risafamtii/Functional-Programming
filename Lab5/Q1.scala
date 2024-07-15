import scala.io.StdIn;

def getProductList():List[String]={
    var list:List[String] = List();
    var str:String = "";
    print("Enter product =");
    str = StdIn.readLine();
    while(str !="done"){
        print("Enter product =");
        str = StdIn.readLine();
        list = list :+ str;
    }
    return list;
}

def printProductList(list:List[String]):Unit = {
    list.zipWithIndex.foreach { case (product, index) =>
        var k:Int = index+1
        println(s"$k. $product")
    }
}

def getTotalProducts(list:List[String]):Int = {
    list.length;
}


object k1{
    def main(args: Array[String]):Unit = {
        var list:List[String] = getProductList();
        println("\n\t\tList")
        printProductList(list);
        println("")
        println(s"Total number of products = ${getTotalProducts(list)}");
    }
}