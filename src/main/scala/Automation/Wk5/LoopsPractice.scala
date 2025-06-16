package Automation.Wk5

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

import scala.jdk.CollectionConverters.CollectionHasAsScala

object LoopsPractice extends App {

  /**
   * for (item <- collection) {
   * // do something with item
   * }
   */

  val fruits = List("Apple", "Banana", "Cherry")

  for (fruit <- fruits) {
    println(fruit)
  }

  //How this looks in Selenium?
  /**
   * for (cell <- cells.asScala) {
   * println(cell.getText)
   * }
   */

  val driver = new ChromeDriver()
  driver.get("https://example.com")

  //loop through a list of elements by class name
  val items = driver.findElements(By.id("item")) //find element by the id
  for (item <- items.asScala) { //Loop over each WebElement in this Java list (converted it to a Scala collection), and call it item.
    println(item.getText) //For every item you find, get the text and print it to console
  }

  // click all buttons in a selection
  val buttons = driver.findElements(By.cssSelector(".my-section button"))
  for (button <- buttons.asScala) { // must be .asScala here as .findElements is a Java Util. Allows you to use Scala for loop comp.
    button.click()
  }

  //find a specific element (within a loop)
  val links = driver.findElements(By.tagName("a"))
  for (link <- links.asScala) {
    if (link.getText.contains("Contact")) {
      link.click()
      println("Clicked the Contact link")
      // Optional: break out of the loop
      // Scala doesn’t have break by default, but you can use a workaround if needed
      // or use `.find` instead of a loop
    }
  }

  //TABLES
//  <table>
//      <td>Apple</td> <td>Red</td>
//      <td>Banana</td> <td>Yellow</td>
//  </table>

  //loop through table rows
  val rows = driver.findElements(By.cssSelector("table tr")) //Selenium's findElements finds all <tr> elements inside any <table> on the page.
  // This returns a java.util.List[WebElement] representing each table row.

  //Read and print all cells text
  for ((row, index) <- rows.asScala.zipWithIndex) { //rows.asScala converts the Java list into a Scala collection..zipWithIndex pairs each row with its index (starting from 0).
    val cells = row.findElements(By.tagName("td"))
    val texts = cells.asScala.map(_.getText).mkString(" | ")
    println(s"Row $index: $texts")
  }

  //  zipWithIndex:
  //Row 0: Apple | Red
  //Row 1: Banana | Yellow

  //.map(_.getText)
  //Extracts the text from each cell (<td>) in the row.
  //Result: a Seq[String], like Seq("Apple", "Red", "1.00")
  //  .mkString(" | ")
  //"mkString" takes all the cell texts and joins them into a single line, separating them with " | " so it's readable.
  //  Seq("Apple", "Red", "1.00") becomes "Apple | Red | 1.00"

  // Does a value exist?
  val found = rows.asScala.exists { row =>
    val cells = row.findElements(By.tagName("td")).asScala
    cells.exists(_.getText == "Banana")
  }
  assert(found, "Expected value 'Banana' not found in the table")

  //Find or click a button/link
  for (row <- rows.asScala) {
    val cells = row.findElements(By.tagName("td")).asScala
    if (cells.exists(_.getText.contains("Banana"))) {
      row.findElement(By.tagName("button")).click()
      println("Clicked the button for Banana row")
    }
  }

  //How many times does a value appear?
  val bananaCount = rows.asScala.count { row =>
    val cells = row.findElements(By.tagName("td")).asScala
    cells.exists(_.getText == "Banana")
  }
  println(s"'Banana' appears in $bananaCount rows")

}
