ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "practice",
    idePackagePrefix := Some("cn.egg")
  )

libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.32.0"
