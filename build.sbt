lazy val example = project.enablePlugins(ScalaJSPlugin).dependsOn(core)

lazy val core = project.enablePlugins(ScalaJSPlugin)

lazy val scalajs_leaflet = (project in file(".")).enablePlugins(ScalaJSPlugin).dependsOn(core, example).aggregate(core, example)

scalaVersion in ThisBuild := "2.11.8"