package Automation.Wk6

import org.openqa.selenium.By
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}

object HeadlessMode extends App {

  val options = new ChromeOptions
  options.addArguments("headless") //Headless mode
  val driver = new ChromeDriver(options) //MUST PASS OPTIONS IN!

  driver.get("https://the-internet.herokuapp.com/javascript_alerts")

  //1. Simple alerts - only 1 ok button
  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click()
  val simpleAlert = driver.switchTo().alert()
  println("Alert 1 -\nAlert triggered: " + simpleAlert.getText)
  simpleAlert.accept()
  println("Test passed for simple alert!")

  //2. Confirmation alert - choose between options (e.g. ok and cancel)
  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button\n")).click()
  val confirmationAlert = driver.switchTo().alert().getText
    driver.switchTo().alert().accept()
  println("Alert 2 -\nAlert accepted!")
  //  driver.switchTo().alert().dismiss()
  //  println("Alert 2 -\nAlert dismissed!") //If this one is commented in, comment accept out.

  //3. Prompt Alert
  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click()
  val promptAlert = driver.switchTo().alert()
  println(promptAlert.getText)
  promptAlert.sendKeys("Welcome")
  promptAlert.accept()
  println("Alert 3 -\nAlert accepted!")

  driver.quit()

}
