# scalajs-leaflet

## Scala.js bindings for Leaflet.js and example applications 

To use as a library, just pull in from

[https://jitpack.io/#fancellu/scalajs-leaflet](https://jitpack.io/#fancellu/scalajs-leaflet)

[![Build Status](https://travis-ci.org/fancellu/scalajs-leaflet.svg?branch=master)](https://travis-ci.org/fancellu/scalajs-leaflet)

Example apps showing the use of [Scala.js](http://www.scala-js.org/) with [leaflet](http://leafletjs.com/) 
The bindings for leaflet are under core `com.felstar.scalajs.leaflet`

## Get started

To get started, run `sbt ~example/fastOptJS` in this root. 

Obviously you need to have [SBT](http://www.scala-sbt.org/) installed. 

This should
download dependencies and prepare the relevant javascript files. It then kicks off a web server to serve the html and JS files. The example files are under example.

If you open
[localhost:12345/example/target/scala-2.11/classes/quickstart-dev.html](http://localhost:12345/example/target/scala-2.11/classes/quickstart-dev.html) in your browser, it will show you a sample app.
Do open the Console to see debug messages. There are is another code example at
localhost:12345/example/target/scala-2.11/classes/leaflet2-dev.html](http://localhost:12345/example/target/scala-2.11/classes/leaflet2-dev.html)


## Live Demo

[Basic leaflet demo](http://dinofancellu.com/demo/scalajsLeaflet/quickstart-dev.html)

[Extended](http://dinofancellu.com/demo/scalajsLeaflet/leaflet2-dev.html)

## Development

If you change your source HTML (inside `/example/src/main/resources`) or Scala (inside `example/src/main/scala/example`), sbt will recompile as needed. 
You then just have to refresh the page to see the new version. Hopefully having an example application will make it clearer on how to use leaflet from Scala, i.e. monkey see, monkey do.

## The optimized version

Run `sbt fullOptJS` for an optimized version
of the final application, useful for final publication. You may well need to copy over `XXX-dev.html` to get your latest changes. Be sure to refer to the correct JS as well, as it will have a different name than the fast compiled version. e.g.

	<script type="text/javascript" src="../example-opt.js"></script>

## Eclipse integration

If you want to edit in Eclipse (can't compile yet, but still very useful having full IDE with code completion), just run `sbt eclipse` the open the generated .project file inside eclipse. Keep sbt running in order to do the JS Compile. [https://github.com/typesafehub/sbteclipse/wiki](https://github.com/typesafehub/sbteclipse/wiki)

## Status

This is just a quick proof of concept and some bindings for those wanting to use leaflet from Scala.js. Feel free to get in contact with any issues etc.


