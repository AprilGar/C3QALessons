package Automation.Wk5.Thurs

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}

import java.time.Duration

object JavaScriptExecutor extends App {

  // Create ChromeDriver instance
  val driver: WebDriver = new ChromeDriver()

  //Implicitly waiting
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) //it won't wait the whole time if it finds it sooner

  // Navigate to the website
  driver.get("https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php")

  //  driver.manage().window().maximize()

  val emailAddress: WebElement = driver.findElement(By.id("email")) //find the element by id (find through inspecting webpage
  emailAddress.sendKeys("test@gmail.com") //this is allowing us to enter an input (text) to a field (the email box in this case)
  println("Email address entered")
  val password: WebElement = driver.findElement(By.id("password"))
  password.sendKeys("TestPassword")
  println("Password entered")

  //Not working currently - don't know enough yet. (Might need to wait.)
  val login: WebElement = driver.findElement(By.id("login")) //find submit button through id
//  login.click() //click the button - not needed when using javaScript

  val js = driver.asInstanceOf[JavascriptExecutor]
  js.executeScript("arguments[0].scrollIntoView(true);", login)
  js.executeScript("arguments[0].click();", login) //button must be clicked in javaScript
  println("Login successful")

  //should now go to a heading that says "Thank you" on the next page.
  val header = driver.findElement(By.tagName("h2")).getText
  println("Header: " + header)
  //Assertions are used to make sure script is behaving as expected
  assert(header == "Thank You!") //should pass
//  assert(header == "I'm wrong") //should fail

  // Close browser
  driver.quit()
}
