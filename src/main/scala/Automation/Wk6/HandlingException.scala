package Automation.Wk6

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, NoSuchElementException}

object HandlingException extends App {

  val driver: WebDriver = new ChromeDriver()

  try{
    driver.get("https://www.selenium.dev/selenium/web/web-form.html") //This is still a link, even if it is a 404 link. API testing is used to confirm this is correct.
    val element = driver.findElement(By.name("I'm-Invalid"))
  }
  catch {
    case e: NoSuchElementException => e.printStackTrace()
    case e: Exception =>
      println("Print any exception: " + e.getMessage)
      e.printStackTrace()
  }
  finally {
    if (driver != null){
      driver.quit()
    }
  }
}
