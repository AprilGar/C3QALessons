package Automation.Wk6

import org.openqa.selenium.{By, OutputType, TakesScreenshot, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.io.FileHandler

import java.io.File
import java.text.SimpleDateFormat
import java.util.Date

object ScreenCapture extends App {

  val driver: WebDriver = new ChromeDriver()
  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  //Capture basic screenshot
  //If file name is the same, it will overwrite to the new one.
  val srcFull: File = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
  FileHandler.copy(srcFull, new File("/Users/april.garlington/Library/CloudStorage/OneDrive-MercatorIT/Academy/Lesson planning/AcademyScreenshots/TestResult.png"))

  //Capture with timestamp
  val timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
  val srcTimestamp: File = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
  FileHandler.copy(srcTimestamp, new File(s"/Users/april.garlington/Library/CloudStorage/OneDrive-MercatorIT/Academy/Lesson planning/AcademyScreenshots/TestResult_$timeStamp.png"))


  //Capture a specific element
  val element = driver.findElement(By.name("my-disabled")) // Locate the element by its name (update if needed)
  val srcElement: File = element.getScreenshotAs(OutputType.FILE) // Capture only that element// Save the screenshot of the element
  FileHandler.copy(srcElement, new File("/Users/april.garlington/Library/CloudStorage/OneDrive-MercatorIT/Academy/Lesson planning/AcademyScreenshots/TestResult_Specific.png"))

  driver.quit()

}
