name := """rabbit-example"""
organization := "com.eltaieb"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.0"

libraryDependencies += guice
libraryDependencies ++= Seq("org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test,
  "com.rabbitmq" % "amqp-client" % "5.7.3",
  "com.typesafe.play" %% "play-json" % "2.7.4",
  "com.typesafe.play" %% "play-slick" % "4.0.2",
  "com.typesafe.play" %% "play-slick-evolutions" % "4.0.2",
  "org.postgresql" % "postgresql" % "42.2.8",
  "com.typesafe.slick" %% "slick" % "3.3.2",
  "com.typesafe.slick" %% "slick-codegen" % "3.3.2"

)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.eltaieb.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.eltaieb.binders._"
