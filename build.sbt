ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "practice",
    idePackagePrefix := Some("cn.egg")
  )

libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.32.0"
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.8.4"
// https://mvnrepository.com/artifact/net.liftweb/lift-json

libraryDependencies += "net.liftweb" %% "lift-json" % "3.5.0"

// https://mvnrepository.com/artifact/com.google.code.gson/gson
libraryDependencies += "com.google.code.gson" % "gson" % "2.10.1"
// https://mvnrepository.com/artifact/org.scalatra/scalatra
//libraryDependencies += "org.scalatra" %% "scalatra" % "3.0.0-M4"
libraryDependencies += "org.scalatra" %% "scalatra" % "2.8.3"

