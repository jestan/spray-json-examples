name := "spray-json-examples"

version := "1.0"

scalaVersion := "2.9.0-1"

resolvers ++= Seq(
  ScalaToolsSnapshots,
  "Akka Repository" at "http://akka.io/repository",
  "Typesafe Releases"  at "http://repo.typesafe.com/typesafe/releases",
  "Typesafe Snapshots"  at "http://repo.typesafe.com/typesafe/snapshots"
)

libraryDependencies ++= Seq(
  "cc.spray.json" %% "spray-json" % "1.0" % "compile" withSources()
)
