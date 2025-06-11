package Automation.Wk5.Wed

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

object HandlingAlerts extends App {

  //These alerts are not part of the HTML DOM. They are made using JavaScript.
  //Due to this, they must be handled differently to regular web elements.

  val driver = new ChromeDriver

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
