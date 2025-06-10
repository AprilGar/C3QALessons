package Automation.Wk5.Tue

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object BrowserMethods extends App {

  //Instantiate the ChromeDriver for interacting with the Chrome  browser
  val driver: WebDriver = new ChromeDriver
  //Accessing the web url the will be used for testing
  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  //maximise window
  driver.manage().window().maximize()

  //minimise window
  driver.manage().window().minimize()

  //navigate to a different URL
  driver.navigate().to("https://the-internet.herokuapp.com")

  //go back in browser history
  driver.navigate().back()

  //go forward in browser history
  driver.navigate().forward()

  //Refresh browser
  driver.navigate().refresh()

  //close current tab
  driver.close()

  //close all windows
  //  driver.quit()

}
