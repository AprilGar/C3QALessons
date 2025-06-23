package Automation.Revision

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

object JsAlerts extends App {

  val driver: WebDriver = new ChromeDriver()
  driver.get("https://the-internet.herokuapp.com/javascript_alerts")

  //Simple alert
driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click() //click on the button to access the alert.

  val switchToAlert = driver.switchTo().alert()

  switchToAlert.accept() //switch to the alert (rather than main page) then accept the alert as it only has 1 button.

  println("Alert accepted.")

  //confirmation alert
  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click() //same place as above so only index position changes

  println("Text: " + switchToAlert.getText) //must get text prior to dismissing alert
  switchToAlert.dismiss()
  println("Alert dismissed.")

  //alert where text can be entered
  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click()
  switchToAlert.sendKeys("I'm being entered into the alert text box.")
  switchToAlert.accept()
  println("Alert has has text entered and been accepted.")

  driver.quit()
}
