package Automation.Revision

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

object StaticTables extends App {

  // <tBody> = table tag
//  <tr> = rows seperated in tr tags
//  <td> = cell values
  val driver: WebDriver = new ChromeDriver()
  driver.get("https://www.w3schools.com/html/html_tables.asp")

  val rows = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[position()>1]")) //must put \ so you escape out of the "". This xpath will capture all data, from all rows, expect the first one with the column headers.

  for (i <- 0 until rows.size()){ //iterate through each row from 0 until the final row
    val column = rows.get(i).findElements(By.tagName("td")) //pick up value inside td tags
    //convert elements to text and print
    val rowText = column.toArray.map(_.asInstanceOf[org.openqa.selenium.WebElement].getText).mkString(" | ")
    println("Row " + (i + 1) + ": "+ rowText) //Just printing it pretty in terminal
  }

  driver.quit()

}
