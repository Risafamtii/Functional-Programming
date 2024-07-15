import scala.io.StdIn

object k2 {

  case class Book(title: String, author: String, ISBN: String)

  def add(library: Set[Book]): Set[Book] = {
    println("\t\tAdd book\n")
    print("Enter book title: ")
    val title: String = StdIn.readLine()
    print("Enter author name: ")
    val author: String = StdIn.readLine()
    print("Enter ISBN: ")
    val ISBN: String = StdIn.readLine()
    val book = Book(title, author, ISBN)
    library + book
  }

  def remove(library: Set[Book]): Set[Book] = {
    println("\t\tRemove book\n")
    print("Enter ISBN: ")
    val number: String = StdIn.readLine()
    library.filterNot(_.ISBN == number)
  }

  def find(library: Set[Book]): Unit = {
    println("\t\tFind book\n")
    print("Enter ISBN: ")
    val number: String = StdIn.readLine()
    val found = library.exists(_.ISBN == number)
    if (found) {
      println("The book is found in the library")
    } else {
      println("The book is not found in the library")
    }
  }

  def display(library: Set[Book]): Unit = {
    println("\n\t\tLibrary")
    library.zipWithIndex.foreach { case (book, index) =>
      println(s"Book ${index + 1}")
      println(s"Title: ${book.title}")
      println(s"Author: ${book.author}")
      println(s"ISBN: ${book.ISBN}")
      println()
    }
  }

  def findByTitle(library: Set[Book]): Unit = {
    println("\n\t\tFind book by title")
    print("Enter title: ")
    val title: String = StdIn.readLine()
    var found:Boolean = false;
    library.filter(_.title == title).foreach { book =>
      println(s"Author: ${book.author}")
      println(s"ISBN: ${book.ISBN}")
      found = true
    }
    if (found!=true){
        println("The book is not found")
    }
  }

  def findByAuthor(library: Set[Book]): Unit = {
    println("\t\tFind book by author")
    println("Enter author: ")
    val author: String = StdIn.readLine()
    library.filter(_.author == author).foreach { book =>
      println(s"Title: ${book.title}")
      println(s"ISBN: ${book.ISBN}")
    }
  }

  def main(args: Array[String]): Unit = {
    var library: Set[Book] = Set(
      Book("1984", "George Orwell", "12345"),
      Book("Brave New World", "Aldous Huxley", "67890"),
      Book("Fahrenheit 451", "Ray Bradbury", "54321")
    )

    display(library)
    library = add(library)
    display(library)

    library = remove(library)
    display(library)

    find(library)
    findByTitle(library)
    findByAuthor(library)
  }
}
