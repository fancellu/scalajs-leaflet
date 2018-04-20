name := "scalajs-leaflet"

description := "Scala.js+Leaflet examples"

version := "0.2"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.1",
  "org.querki" %%% "querki-jsext" % "0.8",
  "com.lihaoyi" %%% "sourcecode" % "0.1.4"
)

publishArtifact in packageDoc:= false

publishArtifact in packageSrc:= false
