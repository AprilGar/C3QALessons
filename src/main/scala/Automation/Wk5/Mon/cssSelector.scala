package Automation.Wk5.Mon

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

object cssSelector extends App {

  val driver: WebDriver = new ChromeDriver
  driver.get("https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php")

  val emailAddress: WebElement = driver.findElement(By.cssSelector("#email"))
  emailAddress.sendKeys("test@gmail.com")
  println("Email address entered - passed")

  val password: WebElement = driver.findElement(By.cssSelector("#password"))
  password.sendKeys("TestPassword")
  println("Password entered - passed")

  //DIFFERENT WEBPAGE
  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  //Using nested elements (parents and children -- follow the path in inspect tool)
  val passwordTwo: WebElement = driver.findElement(By.cssSelector("body > main > div > form > div > div:nth-child(1) > label:nth-child(2) > input"))
  //  div:nth-child(1) - (1) because this is the first div tag in the nest
  //  label:nth-child(2) - (2) because this is the 2nd label tag in the nest
  passwordTwo.sendKeys("TestPasswordTwo")
  println("PasswordTwo entered - passed")

  driver.quit()
}
