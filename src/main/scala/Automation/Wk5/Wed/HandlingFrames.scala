package Automation.Wk5.Wed

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

object HandlingFrames extends App {

  val driver = new ChromeDriver

  driver.get("https://the-internet.herokuapp.com/nested_frames")

  //Switch to different frames.
  //NOTE: if nested, work your way in.
  driver.switchTo().frame("frame-top")
  driver.switchTo().frame("frame-middle")

  //Get elements from inside frame
  val middleText = driver.findElement(By.id("content")).getText
  println("Middle text: " + middleText)

  //We are still in middle frame, if we want to do anything else, we need to come back.
  driver.switchTo().defaultContent() //take us back to default page (main page)

  driver.switchTo().frame(1) //Index position 1, which will be the second frame (remember index starts from 0)

  val bottomText = driver.findElement(By.tagName("body")).getText
  println("Bottom text: " + bottomText)

  driver.switchTo().defaultContent() //switch back to main page (out of the frame)

  val frameTop = driver.findElement(By.name("frame-top"))
  driver.switchTo().frame(frameTop)
  println("Switched to top frame")
  driver.switchTo().frame("frame-left") //switch to left frame but only when inside the top frame as it is nested
  val leftText = driver.findElement(By.tagName("body")).getText
  println("Left text: " + leftText)

  driver.quit()

}
