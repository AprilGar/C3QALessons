ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.16"

lazy val root = (project in file("."))
  .settings(
    name := "TestingLessons",
  )
libraryDependencies ++= Seq(
  "org.seleniumhq.selenium" % "selenium-java" % "4.31.0"
)

