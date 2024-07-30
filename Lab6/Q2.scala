import scala.io.StdIn._

object StudentRecords extends App {

  // Function to validate input
  def validateInput(name: String, marks: Int, totalMarks: Int): (Boolean, Option[String]) = {
    if (name.isEmpty) {
      (false, Some("Name cannot be empty."))
    } else if (marks < 0 || totalMarks < 0) {
      (false, Some("Marks and total possible marks must be positive integers."))
    } else if (marks > totalMarks) {
      (false, Some("Marks cannot exceed total possible marks."))
    } else {
      (true, None)
    }
  }

  // Function to get student info
  def getStudentInfo(): (String, Int, Int, Double, Char) = {
    val name = readLine("Enter student's name: ")
    val marks = readLine("Enter student's marks: ").toInt
    val totalMarks = readLine("Enter total possible marks: ").toInt

    val (isValid, errorMessage) = validateInput(name, marks, totalMarks)

    if (!isValid) {
      println(s"Error: ${errorMessage.get}")
      return getStudentInfo()
    }

    val percentage = (marks.toDouble / totalMarks) * 100
    val grade = percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case _ => 'D'
    }

    (name, marks, totalMarks, percentage, grade)
  }

  // Function to print student record
  def printStudentRecord(record: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = record
    println(s"Name: $name")
    println(s"Marks: $marks")
    println(s"Total Possible Marks: $totalMarks")
    println(f"Percentage: $percentage%.2f%%")
    println(s"Grade: $grade")
  }

  // Function to get student info with retry until valid data is provided
  def getStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
    def loop(): (String, Int, Int, Double, Char) = {
      val name = readLine("Enter student's name: ")
      val marks = try { readLine("Enter student's marks: ").toInt } catch { case _: NumberFormatException => -1 }
      val totalMarks = try { readLine("Enter total possible marks: ").toInt } catch { case _: NumberFormatException => -1 }

      validateInput(name, marks, totalMarks) match {
        case (true, _) => 
          val percentage = (marks.toDouble / totalMarks) * 100
          val grade = percentage match {
            case p if p >= 90 => 'A'
            case p if p >= 75 => 'B'
            case p if p >= 50 => 'C'
            case _ => 'D'
          }
          (name, marks, totalMarks, percentage, grade)
        case (false, Some(errorMessage)) =>
          println(s"Error: $errorMessage")
          loop()
        case (false, None) =>
          println("Invalid input.")
          loop()
      }
    }
    loop()
  }

  // Main application logic
  val studentInfo = getStudentInfoWithRetry()
  printStudentRecord(studentInfo)
}
