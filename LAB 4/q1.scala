object one{
  var names = Array("dog", "cat", "rat")
  var quantities = Array(5, 10, 15)


  def displayInventory(i: Int = 0): Unit = {
    if(i < names.length){
      println(s"${names(i)} : ${quantities(i)}")
      displayInventory(i + 1)
    }
  }

  def restockItem(name: String, quantity: Int): Unit = {
    val i = names.indexOf(name)
    if( i >= 0){
      quantities(i) += quantity
      println(s"new quantity of $name is ${quantities(i)}")
    }
    else{
      println(s"$name does not exist in array")
    }
  }

  def sellItem(name: String, quantity: Int): Unit = {
    val i = names.indexOf(name)
    if(i >= 0){
      if(quantities(i) >= quantity){
        quantities(i) -= quantity
        println(s"Sold $quantity of $name")
      }
      else{
        println(s"Only ${quantities(i)} of $name is available")
      }
    }
    else{
      println(s"$name does not exist")
    }
  }
    
  def main(args: Array[String]): Unit = {
    displayInventory()
    restockItem("dog", 5)
    displayInventory()
    sellItem("dog", 3)
    sellItem("cat", 25)
    displayInventory()
  }
}
    
