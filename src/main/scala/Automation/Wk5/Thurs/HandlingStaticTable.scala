package Automation.Wk5.Thurs

// Import necessary Selenium classes
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver}

// Define a singleton object with main method
object HandlingStaticTable extends App {

    //   Initialize Chrome WebDriver
    val driver: WebDriver = new ChromeDriver()

    //    Navigate to a web page containing a static HTML table
    driver.get("https://www.w3schools.com/html/html_tables.asp")

    //    Locate all data rows in the table with id 'customers', skipping the header row
    // XPath explained:
    // //table[@id='customers']      → Locate the table with id 'customers'
    // /tbody/tr[position() > 1]    → Get all rows (tr) inside tbody, excluding the first one (usually the header)
    val rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[position() > 1]"))

    //    Iterate through each row
    for (i <- 0 until rows.size()) {
      // Get all columns (td elements) inside the current row
      val cols = rows.get(i).findElements(By.tagName("td"))

      // Convert column elements to text and join with " | " separator
      val rowText = cols.toArray.map(_.asInstanceOf[org.openqa.selenium.WebElement].getText).mkString(" | ")

      // Print the formatted row data
      println(s"Row ${i + 1}: $rowText")
    }

    //   Close the browser after processing
    driver.quit()

}
