name := "adventOfCode"

version := "0.1"

scalaVersion := "2.12.9"

resolvers += "confluent" at "https://packages.confluent.io/maven"

val sparkVersion = "3.0.1"
val scalaTestVersion = "3.1.1"

lazy val testingDeps = Seq(
  "org.scalamock" %% "scalamock" % "4.4.0" % Test,
  "org.scalactic" %% "scalactic" % scalaTestVersion,
  "org.scalatest" %% "scalatest" % scalaTestVersion % Test
)

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  // logging
  "org.apache.logging.log4j" % "log4j-api" % "2.4.1",
  "org.apache.logging.log4j" % "log4j-core" % "2.4.1"
)
