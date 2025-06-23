package Automation.Revision

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.Select

object DropDowns extends App {

  val driver: WebDriver = new ChromeDriver()
  driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select")

  driver.switchTo().frame("iframeResult")

  val dropDown = driver.findElement(By.name("cars")) //storing as an object in a val so can be reused without typing method again.

  val selectDropDown = new Select(dropDown) //storing to be reused
  selectDropDown.selectByVisibleText("Opel") //what can be seen displayed on the website

  selectDropDown.selectByIndex(0) 

  selectDropDown.selectByValue("opel") //from inspect tool

  driver.quit()
}
