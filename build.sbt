name := """TravelHead"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.4"

crossScalaVersions := Seq("2.11.12", "2.12.4")

libraryDependencies += guice

libraryDependencies ++= Seq(
	"org.webjars" % "bootstrap" % "4.0.0",
	"com.adrianhurt" %% "play-bootstrap" % "1.2-P26-B4",
	"org.webjars" % "jquery" % "3.2.1",
	"org.webjars" % "font-awesome" % "4.7.0",
	"org.xerial" % "sqlite-jdbc" % "3.21.0"
	)

// Test Database

// Testing libraries for dealing with CompletionStage...
libraryDependencies += "org.assertj" % "assertj-core" % "3.6.2" % Test
libraryDependencies += "org.awaitility" % "awaitility" % "2.0.0" % Test

// Make verbose tests
testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))
