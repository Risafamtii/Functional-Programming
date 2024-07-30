object InventoryManagement extends App {
  // Define product case class
  case class Product(name: String, quantity: Int, price: Double)

  // Sample inventories
  val inventory1: Map[Int, Product] = Map(
    1 -> Product("Laptop", 10, 1500.0),
    2 -> Product("Smartphone", 25, 800.0),
    3 -> Product("Tablet", 15, 500.0)
  )

  val inventory2: Map[Int, Product] = Map(
    2 -> Product("Smartphone", 10, 850.0),
    4 -> Product("Monitor", 20, 300.0)
  )

  // I. Retrieve all product names from inventory1
  def getProductNames(inventory: Map[Int, Product]): Seq[String] = {
    inventory.values.map(product => product.name).toSeq
  }

  // II. Calculate the total value of all products in inventory1
  def calculateTotalValue(inventory: Map[Int, Product]): Double = {
    inventory.values.map(product => product.quantity * product.price).sum
  }

  // III. Check if inventory1 is empty
  def isInventoryEmpty(inventory: Map[Int, Product]): Boolean = {
    inventory.isEmpty
  }

  // IV. Merge inventory1 and inventory2, updating quantities and retaining the highest price
  def mergeInventories(inventory1: Map[Int, Product], inventory2: Map[Int, Product]): Map[Int, Product] = {
    inventory2.foldLeft(inventory1) { case (acc, (id, product)) =>
      acc.get(id) match {
        case Some(existingProduct) =>
          val mergedProduct = Product(
            existingProduct.name,
            existingProduct.quantity + product.quantity,
            math.max(existingProduct.price, product.price)
          )
          acc.updated(id, mergedProduct)
        case None =>
          acc.updated(id, product)
      }
    }
  }

  // V. Check if a product with a specific ID exists and print its details
  def checkProductExists(inventory: Map[Int, Product], productId: Int): Unit = {
    inventory.get(productId) match {
      case Some(product) =>
        println(s"Product ID: $productId, Name: ${product.name}, Quantity: ${product.quantity}, Price: ${product.price}")
      case None =>
        println(s"Product with ID $productId does not exist.")
    }
  }

  // Test the functions
  println("Product Names in Inventory1: " + getProductNames(inventory1))

  println("Total Value of Inventory1: $" + calculateTotalValue(inventory1))

  println("Is Inventory1 Empty? " + isInventoryEmpty(inventory1))

  val mergedInventory = mergeInventories(inventory1, inventory2)
  println("Merged Inventory: " + mergedInventory)

  println("Check if Product ID 2 exists in Inventory1:")
  checkProductExists(inventory1, 2)
}
