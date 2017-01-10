package example

import com.felstar.scalajs.leaflet._

import scala.scalajs.js
import scala.scalajs.js.Dynamic.literal
import scala.scalajs.js.JSON
import scala.scalajs.js.annotation.JSExport

@JSExport
object Leaflet2 extends {

  @JSExport
  def main(el: String, southwarkpark: js.Object): LMap = {

    println(JSON.stringify(southwarkpark))

    val mapOptions=LMapOptions.zoom(13).center((51.505, -0.09))

    val lmap = L.map(el, mapOptions)

    val mapPopup = L.popup()

    val mapPoked=(e: LeafletMouseEvent)=> {
      mapPopup.setLatLng(e.latlng).setContent(s"You clicked me at ${e.latlng}").openOn(lmap)
    }

    lmap.on(LMapEvent.click.toString, mapPoked)

    val tileLayer = L.tileLayer("https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpandmbXliNDBjZWd2M2x6bDk3c2ZtOTkifQ._QA7i5Mpkd_m30IGElHziw",
      TileLayerOptions.id("mapbox.streets").maxZoom(19).attribution("""Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors,
                                                 |<a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>,
                                                 |Imagery © <a href="http://mapbox.com">Mapbox</a>""".stripMargin))
    tileLayer.addTo(lmap)

    val marker=L.marker((51.5, -0.09), MarkerOptions.title("I am draggable").draggable(true).opacity(0.8))
      .bindPopup("I am a popup").addTo(lmap)

    val markerMoved=(e: LeafletMarkerMoveEvent)=> {
      println("OLD="+e.oldLatLng)
      println("NEW="+e.latlng)
    }

    marker.on(LMapEvent.move.toString, markerMoved)
    marker.bindTooltip("this is the tooltip", TooltipOptions.permanent(true))

    println(JSON.stringify(marker.toGeoJSON()))

    L.circle((51.508, -0.11), CircleOptions.color("red").fillColor("#f03").fillOpacity(0.5).radius(500))
      .bindPopup("I am a circle").addTo(lmap)

    L.circle((51.516, -0.11), CircleOptions.color("green").fillColor("#f03").fillOpacity(0.5).radius(200)).addTo(lmap)

    val points=List((51.509, -0.08),(51.503, -0.06),(51.51, -0.047))
    L.polygon(points).bindPopup("I am a polygon").addTo(lmap)

    L.polyline(points.map(t=>(t._1+0.01,t._2+0.01)), PolylineOptions.dashArray("5, 5")).addTo(lmap)

    for (p<-points){
      L.circle(p, CircleOptions.color("red").fillColor("#f03").fillOpacity(0.5).radius(50)).addTo(lmap)
    }
    L.popup(PopupOptions.closeButton(false)).setLatLng((51.5, -0.04)).setContent("I am a <b>standalone</b> popup!").openOn(lmap)
    val popupClosed=(e: LeafletPopupEvent)=> {
      println("popup closed: "+e.popup.getContent())
    }

    lmap.on(LMapEvent.popupclose.toString, popupClosed)

    val url1="http://www.lib.utexas.edu/maps/historical/newark_nj_1922.jpg"
    val url2="http://i.giphy.com/axzJEX0J3zXJS.gif"

    var url=url1

    val latLngBnds=L.latLngBounds((51.4863, -0.10935), (51.47133, -0.0618))
    val imageOverlay=L.imageOverlay(url, latLngBnds, ImageOverlayOptions.interactive(true))

    val imageSwapper=(e: LeafletMouseEvent)=> {
      url=if (url==url1) url2 else url1
      imageOverlay.setUrl(url)
    }

    imageOverlay.on(LMapEvent.click.toString, imageSwapper)
    val rect=L.rectangle(latLngBnds.pad(.01), PolylineOptions.interactive(false).fill(false))

    val layerGroup=L.layerGroup(js.Array(imageOverlay, rect))
    layerGroup.addLayer(L.circleMarker((51.4863, -0.10935), CircleMarkerOptions.fill(true).fillOpacity(1)))

    val leafOptions=IconOptions.shadowUrl("img/leaf-shadow.png").iconSize((38,95)).shadowSize((50,64))
      .iconAnchor((22,64)).shadowAnchor((4,62)).popupAnchor((-3,-76))

    val greenIcon=L.icon(leafOptions.iconUrl("img/leaf-green.png"))
    val redIcon=L.icon(leafOptions.iconUrl("img/leaf-red.png"))

    L.marker((51.52, -0.08), MarkerOptions.icon(greenIcon)).bindPopup("I am a green leaf.").addTo(lmap)
    L.marker((51.52, -0.089), MarkerOptions.icon(redIcon)).bindPopup("I am a red leaf.").addTo(lmap)

    val geojson=L.geoJSON(southwarkpark)

    val basemaps = literal("base"->tileLayer)
    val overlays = literal("images"->layerGroup, "geojson"->geojson)

    geojson.addTo(lmap)

    L.control.layers(basemaps, overLays = overlays, ControlLayerOptions.collapsed(false).hideSingleBase(true)).addTo(lmap)

    layerGroup.addTo(lmap)

    L.control.scale().addTo(lmap)

    lmap
  }

}