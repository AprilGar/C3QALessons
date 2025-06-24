package Automation.Revision

import org.openqa.selenium.{By, JavascriptExecutor, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import java.time.Duration

object DynamicDropDowns extends App {

  val driver: WebDriver = new ChromeDriver()
  val explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10))
  driver.manage().window().maximize()
  driver.get("https://demoqa.com/automation-practice-form")

  val stateField = driver.findElement(By.id("state"))

  val js = driver.asInstanceOf[JavascriptExecutor]
  js.executeScript("arguments[0].scrollIntoView(true);", stateField)

  stateField.click() //at this point we have clicked on the field, we have not selected a value

  //find the locator for the selection you want using inspect tool. Add in a wait so that it is only clicked when visible.
  val stateOption = explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'NCR')]")))
  stateOption.click()

  //Now the city drop down will be visible. Click on it.
  val cityField = driver.findElement(By.id("city"))
  cityField.click()

  //Select the city from the drop down.
  val cityOption = explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Delhi')]")))
  cityOption.click()

  //Assertions
  val chosenState = driver.findElement(By.xpath("//div[@id='state']//div[contains(@class,'-singleValue')]")).getText
  val chosenCity = driver.findElement(By.xpath("//div[@id='city']//div[contains(@class,'-singleValue')]")).getText
  assert(chosenState == "NCR")
  println(s"State was $chosenState")
  assert(chosenCity == "Delhi")
  println(s"City  was $chosenCity")

  driver.quit()
}
