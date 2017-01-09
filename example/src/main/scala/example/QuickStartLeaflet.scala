package example

import com.felstar.scalajs.leaflet._

import scala.scalajs.js.annotation.JSExport

@JSExport
object QuickStartLeaflet extends {

  @JSExport
  def main(el: String): LMap = {

    val lmap = L.map(el).setView((51.505, -0.09), 13)

    val tileLayer = L.tileLayer("https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpandmbXliNDBjZWd2M2x6bDk3c2ZtOTkifQ._QA7i5Mpkd_m30IGElHziw",
      TileLayerOptions.id("mapbox.streets").maxZoom(19).attribution("""Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors,
                                                                      |<a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>,
                                                                      |Imagery © <a href="http://mapbox.com">Mapbox</a>""".stripMargin))
    tileLayer.addTo(lmap)

    L.marker((51.5, -0.09), MarkerOptions.title("I am a marker")).bindPopup("I am a popup").addTo(lmap)

    val circle=L.circle((51.508, -0.11), CircleOptions.color("red").fillColor("#f03").fillOpacity(0.5).radius(500))
      .bindPopup("I am a circle").addTo(lmap)

    val circle2=L.circle((51.516, -0.11), CircleOptions.color("green").fillColor("#f03").fillOpacity(0.5).radius(200)).addTo(lmap)

     val points=List((51.509, -0.08),(51.503, -0.06),(51.51, -0.047))
     L.polygon(points).bindPopup("I am a polygon").addTo(lmap)

    val popup = L.popup().setLatLng((51.5, -0.09)).setContent("I am a <b>standalone</b> popup.").openOn(lmap)

    lmap
  }
}