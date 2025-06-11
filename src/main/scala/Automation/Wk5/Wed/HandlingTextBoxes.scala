package Automation.Wk5.Wed

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

object HandlingTextBoxes extends App {

  val driver = new ChromeDriver

  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  val textInput = driver.findElement(By.id("my-text-id"))
  println("Text sent to text box: " + textInput.sendKeys("Welcome"))
  println("getAttribute: "+ textInput.getAttribute("type")) //from the inspect tool (will give what the labels are actually assigned to)
  println("getAttribute: "+ textInput.getAttribute("value")) // get the value we have sent (L13)
  println("Text cleared: " +  textInput.clear())

  driver.close()

}
