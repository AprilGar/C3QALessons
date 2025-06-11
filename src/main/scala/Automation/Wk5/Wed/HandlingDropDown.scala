package Automation.Wk5.Wed

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.Select

object HandlingDropDown extends App {

  val driver = new ChromeDriver

  driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select")

  //located inside a frame
  driver.switchTo().frame("iframeResult")

  //locate the drop down using the name
  val dropDown = driver.findElement(By.name("cars"))
  println("Dropdown found: " + dropDown)

  val select = new Select(dropDown) //need to import Select

  select.selectByVisibleText("Opel")
  println("Selected by visible text: " + select.getFirstSelectedOption.getText)

  select.selectByValue("volvo")
  println("Select by value: " + select.getFirstSelectedOption.getText)

  select.selectByIndex(3)
  println("Select by value: " + select.getFirstSelectedOption.getText)

  driver.quit()

}
