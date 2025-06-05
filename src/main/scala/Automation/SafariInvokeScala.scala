import org.openqa.selenium.WebDriver
import org.openqa.selenium.safari.SafariDriver

object SafariInvokeScala extends App {

  println("Invoking Chrome Browser!")
  // Set path for ChromeDriver (ensure ChromeDriver is in your PATH or specify location)
  //     System.setProperty("webdriver.chrome.driver", "/Users/april.garlington/Desktop/Browser/chromedriver")

  val driver: WebDriver = new SafariDriver()
  driver.get("https://www.google.com")
  println("Title of the page: " + driver.getTitle)
  driver.quit()

}
