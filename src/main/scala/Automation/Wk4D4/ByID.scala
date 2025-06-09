package Automation.Wk4D4

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object ByID extends App {

  //Must instantiate a new instance of our WebDriver which is of type ChromeDriver for interacting with the browser
  val driver: WebDriver = new ChromeDriver

  //Accessing the URL for testing
  driver.get("https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php")

  // Inspect element in webpage to find the names you need to search for
  val emailAddress: WebElement = driver.findElement(By.id("email")) //find the element by id (find through inspecting webpage
  emailAddress.sendKeys("test@gmail.com") //this is allowing us to enter an input (text) to a field (the email box in this case)
  println("Email address entered")
  val password: WebElement = driver.findElement(By.id("password"))
  password.sendKeys("TestPassword")
  println("Password entered")

  //Not working currently - don't know enough yet. (Might need to wait.)
//  val login: WebElement = driver.findElement(By.id("login")) //find submit button through id
//  login.click() //click the button
//  println("Login successful")

  driver.quit()
}
