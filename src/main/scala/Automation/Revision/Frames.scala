package Automation.Revision

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

object Frames extends App {

  val driver: WebDriver = new ChromeDriver()
  driver.get("https://the-internet.herokuapp.com/nested_frames")

  driver.switchTo().frame("frame-top") //get this from inspect tool
  println("You are in top frame")

  driver.switchTo().frame(1) //index position
  println("You are in the middle frame inside the top frame") //have to move into top frame first to access this

  driver.switchTo().defaultContent() //back to top level

//  driver.switchTo().frame("frame-bottom")

  val frameBottom = driver.findElement(By.name("frame-bottom")) //can assign it to a val to call it rather than above line
  driver.switchTo().frame(frameBottom)
  println("You are in bottom frame")

  driver.quit()
}
