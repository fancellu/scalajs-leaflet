lazy val core = project.enablePlugins(ScalaJSPlugin).settings(scalacOptions += "-feature")
lazy val example = project.enablePlugins(ScalaJSPlugin, WorkbenchPlugin).dependsOn(core)
lazy val scalajs_leaflet = (project in file(".")).aggregate(core, example)

crossScalaVersions := Seq("2.11.11", "2.12.5")
