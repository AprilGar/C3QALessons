import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object ChromeInvokeScala extends App {
  //FIRST WEB DRIVER SCRIPT WHICH WILL INVOKE THE CHROME BROWSER

  println("Invoking Chrome Browser!")

  val driver: WebDriver = new ChromeDriver()
  driver.get("https://www.google.com")
  println("Title of the page: " + driver.getTitle)
  driver.quit()
}


