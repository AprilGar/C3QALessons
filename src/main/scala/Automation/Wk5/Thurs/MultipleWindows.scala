package Automation.Wk5.Thurs

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import scala.jdk.CollectionConverters.CollectionHasAsScala

object MultipleWindows extends App {

  val driver = new ChromeDriver()
  driver.get("https://the-internet.herokuapp.com/windows")
  driver.manage().window().maximize()

  val parentWindow = driver.getWindowHandle //get the handle for the parent window
  println("Handle for the parent window" + parentWindow)

  driver.findElement(By.linkText("Click Here")).click()

  val allWindows: List[String] = driver.getWindowHandles.asScala.toList
  val it = allWindows.iterator

  //How we move between windows
  while (it.hasNext) {
    val handle = it.next()

    if (handle != parentWindow) {
      driver.switchTo().window(handle)
      println("The current window: " + handle)
      // Perform action in new window
      println(s"New Window Title: ${driver.getTitle}")
    }
  }

  // Switch back to parent window
  driver.switchTo().window(parentWindow)
  println("Switched back to Parent Window")

  // Quit entire browser session
  driver.quit()

}
