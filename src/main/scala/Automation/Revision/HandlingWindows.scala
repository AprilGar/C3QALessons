package Automation.Revision

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

import scala.jdk.CollectionConverters.CollectionHasAsScala

object HandlingWindows extends App {

  val driver: WebDriver = new ChromeDriver()
  driver.get("https://the-internet.herokuapp.com/windows")

  //A unique 'handle' will be opened every time the window/tab is opened.
  //The first window is the 'parent' window.
  //The windows that open from the 'parent' are the 'children' windows.
  //Quite often need to use conditional statements for finding handles.

  val parentWindowHandle = driver.getWindowHandle //gets the window handle of the parent window
  println("Title of page: " + driver.getTitle + " - Handle: " + parentWindowHandle)

  //Now click on the link --> use inspect tool here
  driver.findElement(By.linkText("Click Here")).click()

  val allWindowHandles: List[String] = driver.getWindowHandles.asScala.toList //collect all handles, convert the Scala and then transfer into a List.

  val iterator = allWindowHandles.iterator //iterate through the list of windows (using the handles)

  while (iterator.hasNext) { //while the iterator has a 'next' place to go
    val handle = iterator.next() //check 1 by 1
    if (handle != parentWindowHandle) { //switch to window if it isn't the parent window, will skip the first one (as it is the parent) and go back to 'while' again. Moves to second window and trys again.
      driver.switchTo().window(handle)
      println("Title of page: " + driver.getTitle)
      driver.close()
    }
  }
  driver.switchTo().window(parentWindowHandle) //switch back to parent window using the handle
  println("Title of page: " + driver.getTitle) //Prove switch back to parent

  driver.quit()
}
