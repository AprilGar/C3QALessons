package Automation.Wk5.Wed

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

object HandlingButtonsAndLinks extends App {

  val driver = new ChromeDriver

  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  driver.manage().window().maximize()

  //Handling buttons

  val button = driver.findElement(By.cssSelector("[type=\"submit\"]"))

  if (button.isEnabled) {
    println("Button text: " + button.getText)
    button.click()
  } else {
    println("Button is not enabled")
  }

  //Handling hyperlinks

  driver.get("https://www.selenium.dev/")
  val myLink = driver.findElement(By.linkText("Documentation"))
  println("Get 'href' attribute for destination url: " + myLink.getAttribute("href"))

    driver.quit()

}
