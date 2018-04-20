package com.felstar.scalajs.leaflet

import org.querki.jsext._
import org.scalajs.dom.raw.HTMLElement

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.Dynamic.literal
import scala.scalajs.js.annotation.JSGlobal

trait SCOptionSetter[T <: js.Object, B <: SCOptionBuilder[T, _]]
    extends JSOptionSetter[T, B] {
  protected def jsOpt(opt: Any)(implicit name: sourcecode.Name): B
}

abstract class SCOptionBuilder[T <: js.Object, B <: SCOptionBuilder[T, _]](
    copy: OptMap => B)
    extends JSOptionBuilder[T, B](copy) {
  protected def jsOpt(opt: Any)(implicit name: sourcecode.Name): B = {
    copy(dict + (name.value -> opt))
  }
}

@js.native
@JSGlobal
object L extends js.Object {
  def map(id: String, options: LMapOptions = ???): LMap = js.native
  def latLng(lat: Double, lng: Double): LatLng = js.native
  def latLngBounds(corner1: LatLng, corner2: LatLng): LatLngBounds = js.native
  def tileLayer(url: String, options: TileLayerOptions = ???): TileLayer =
    js.native
  def imageOverlay(imageUrl: String,
                   bounds: LatLngBounds,
                   options: ImageOverlayOptions = ???): ImageOverlay = js.native
  def marker(latLng: LatLng, markerOptions: MarkerOptions = ???): Marker =
    js.native
  def circle(latLng: LatLng, options: CircleOptions = ???): Circle = js.native
  def circleMarker(latLng: LatLng,
                   options: CircleMarkerOptions = ???): CircleMarker = js.native
  def polygon(latLngs: LatLngArray, options: PolylineOptions = ???): Polygon =
    js.native
  def polyline(latLngs: LatLngArray, options: PolylineOptions = ???): Polyline =
    js.native
  def rectangle(latLngs: LatLngBounds,
                options: PolylineOptions = ???): Rectangle = js.native
  def popup(options: PopupOptions = ???): Popup = js.native
  def point(x: Double, y: Double): Point = js.native
  def bounds(p1: Point, p2: Point): Bounds = js.native
  def tooltip(options: TooltipOptions = ???, source: Layer = ???): Point =
    js.native
  def layerGroup(layers: js.Array[Layer] = ???): LayerGroup = js.native
  def featureGroup(layers: js.Array[Layer] = ???): FeatureGroup = js.native
  def geoJSON(geojson: js.Object = ???,
              options: GeoJSONOptions = ???): GeoJSON = js.native
  def icon(options: IconOptions = ???): Icon = js.native
  @js.native
  object control extends js.Object {
    def layers(baseLayers: js.Object = ???,
               overLays: js.Object = ???,
               options: ControlLayerOptions = ???): ControlLayer = js.native
    def scale(options: ControlScaleOptions = ???): ControlScale = js.native
  }
}

@js.native
trait ControlLayer extends Control {
  def addBaseLayer(layer: Layer, name: String): this.type = js.native
  def addOverlay(layer: Layer, name: String): this.type = js.native
  def removeLayer(layer: Layer): this.type = js.native
  def expand(): this.type = js.native
  def collapse(): this.type = js.native
}

@js.native
trait ControlLayerOptions extends js.Object
object ControlLayerOptions extends ControlLayerOptionBuilder(noOpts)
class ControlLayerOptionBuilder(val dict: OptMap)
    extends SCOptionBuilder[ControlLayerOptions, ControlLayerOptionBuilder](
      new ControlLayerOptionBuilder(_))
    with ControlLayerSetters[ControlLayerOptions, ControlLayerOptionBuilder]

trait ControlLayerSetters[T <: js.Object, B <: SCOptionBuilder[T, _]]
    extends SCOptionSetter[T, B] {
  def collapsed(v: Boolean) = jsOpt(v)
  def autoZIndex(v: Boolean) = jsOpt(v)
  def hideSingleBase(v: Boolean) = jsOpt(v)
  def sortLayers(v: Boolean) = jsOpt(v)
  def sortFunction(v: js.Function) = jsOpt(v)
  def position(v: String) = jsOpt(v)
}

@js.native
trait Control extends js.Object {
  def getPosition(): String = js.native
  def setPosition(position: String): this.type = js.native
  def getContainer(): HTMLElement = js.native
  def addTo(map: LMap): this.type = js.native
  def remove(map: LMap): this.type = js.native
}

@js.native
trait ControlScale extends Control {}

@js.native
trait ControlScaleOptions extends js.Object
object ControlScaleOptions extends ControlScaleOptionBuilder(noOpts)
class ControlScaleOptionBuilder(val dict: OptMap)
    extends SCOptionBuilder[ControlScaleOptions, ControlScaleOptionBuilder](
      new ControlScaleOptionBuilder(_))
    with ControlScaleSetters[ControlScaleOptions, ControlScaleOptionBuilder]

trait ControlScaleSetters[T <: js.Object, B <: SCOptionBuilder[T, _]]
    extends SCOptionSetter[T, B] {
  def maxWidth(v: Int) = jsOpt(v)
  def metric(v: Boolean) = jsOpt(v)
  def imperial(v: Boolean) = jsOpt(v)
  def updateWhenIdle(v: Boolean) = jsOpt(v)
  def position(v: String) = jsOpt(v)
}
@js.native
trait Evented extends js.Object {
  def on(event: String, fn: js.Function, context: js.Any = ???): this.type =
    js.native
  def on(eventMap: js.Dynamic): this.type = js.native
  def off(event: String,
          fn: js.Function = ???,
          context: js.Any = ???): this.type = js.native
  def off(eventMap: js.Dynamic): this.type = js.native
  def off(): this.type = js.native
  def fire(event: String,
           data: js.Any = ???,
           propagate: Boolean = ???): this.type = js.native
  def listens(event: String): Boolean = js.native
  def once(event: String, fn: js.Function, context: js.Any = ???): this.type =
    js.native
  def once(eventMap: js.Dynamic): this.type = js.native
  def addEventParent(parent: Evented): this.type = js.native
  def removeEventParent(parent: Evented): this.type = js.native
}

@js.native
trait LMap extends js.Object with Evented {
  def addLayer(layer: Layer): this.type = js.native
  def removeLayer(layer: Layer): this.type = js.native
  def hasLayer(layer: Layer): Boolean = js.native
  def eachLayer(fn: js.Function, context: js.Any = literal()): Boolean =
    js.native

  def setView(center: LatLng,
              zoom: Int,
              options: ZoomPanOptions = ???): this.type = js.native
  //def setView(center:LatLng, zoom:Int):this.type = js.native
  //def setZoom(zoom:Int):this.type = js.native
  def setZoom(zoom: Int, options: ZoomPanOptions = ???): this.type = js.native
  def zoomIn(delta: Int, options: ZoomOptions = ???): this.type = js.native
  //def zoomIn(options: ZoomOptions= ???):this.type = js.native
  def zoomOut(delta: Int, options: ZoomOptions = ???): this.type = js.native
  //def zoomOut(options: ZoomOptions= ???):this.type = js.native
  def setZoomAround(latLng: LatLng,
                    zoom: Int,
                    options: ZoomOptions = ???): this.type = js.native
  //def setZoomAround(offset:Point, zoom:Int, options: ZoomOptions= ???):this.type = js.native
  def fitBounds(bounds: LatLngBounds,
                options: FitBoundsOptions = ???): this.type = js.native
  def fitWorld(options: FitBoundsOptions = ???): this.type = js.native
  def panTo(latLng: LatLng, options: PanOptions = ???): this.type = js.native
  def panBy(offset: Point): this.type = js.native
  def flyTo(latLng: LatLng,
            zoom: Int,
            options: ZoomPanOptions = ???): this.type = js.native
  def flyToBounds(bounds: LatLngBounds,
                  options: FitBoundsOptions = ???): this.type = js.native
  def setMaxBounds(bounds: LatLngBounds): this.type = js.native
  def setMinZoom(zoom: Int): this.type = js.native
  def setMaxZoom(zoom: Int): this.type = js.native
  def panInsideBounds(bounds: LatLngBounds,
                      options: PanOptions = ???): this.type = js.native
  def invalidateSize(options: ZoomPanOptions): this.type = js.native
  def invalidateSize(animate: Boolean): this.type = js.native
  def stop(): this.type = js.native
  def locate(options: LocateOptions = ???): this.type = js.native
  def stopLocate(): this.type = js.native

  def getCenter(): LatLng = js.native
  def getZoom(): Int = js.native
  def getBounds(): LatLngBounds = js.native
  def getMinZoom(): Int = js.native
  def getMaxZoom(): Int = js.native
  def getBoundsZoom(bounds: LatLngBounds, inside: Boolean = ???): Int =
    js.native
  def getSize(): Point = js.native
  def getPixelBounds(): Bounds = js.native
  def getPixelOrigin(): Point = js.native
  def getPixelWorldBounds(zoom: Int = ???): Bounds = js.native

  def getZoomScale(toZoom: Int, fromZoom: Int): Int = js.native
  def getScaleZoom(scale: Int, fromZoom: Int): Int = js.native
  def project(latLng: LatLng, zoom: Int): Point = js.native
  def unproject(point: Point, zoom: Int): LatLng = js.native
  def layerPointToLatLng(point: Point): LatLng = js.native
  def latLngToLayerPoint(latLng: LatLng): Point = js.native
  def wrapLatLng(latLng: LatLng): LatLng = js.native
  def distance(latLng1: LatLng, latLng2: LatLng): Double = js.native
  def containerPointToLayerPoint(point: Point): Point = js.native
  def latLngToContainerPoint(latLng: LatLng): Point = js.native
  def mouseEventToContainerPoint(mouseEvent: LeafletMouseEvent): Point =
    js.native
  def mouseEventToLayerPoint(mouseEvent: LeafletMouseEvent): Point = js.native
  def mouseEventToLatLng(mouseEvent: LeafletMouseEvent): LatLng = js.native
}

@js.native
trait LocateOptions extends js.Object
object LocateOptions extends LocateOptionBuilder(noOpts)
//class LocateOptionBuilder(val dict:OptMap) extends SCOptionBuilder[LocateOptions, LocateOptionBuilder](new LocateOptionBuilder(_)) {
class LocateOptionBuilder(val dict: OptMap)
    extends SCOptionBuilder[LocateOptions, LocateOptionBuilder](
      new LocateOptionBuilder(_)) {
  def watch(v: Boolean) = jsOpt(v)
  def setView(v: Boolean) = jsOpt(v)
  def maxZoom(v: Int) = jsOpt(v)
  def timeout(v: Int) = jsOpt(v)
  def maximumAge(v: Int) = jsOpt(v)
  def enableHighAccuracy(v: Boolean) = jsOpt(v)
}

@js.native
trait LatLngBounds extends js.Object {
  def extend(latLng: LatLng): this.type = js.native
  def extend(otherBounds: LatLngBounds): this.type = js.native
  def pad(bufferRatio: Double): this.type = js.native
  def getCenter(): LatLng = js.native
  def getSouthWest(): LatLng = js.native
  def getNorthEast(): LatLng = js.native
  def getNorthWest(): LatLng = js.native
  def getSouthEast(): LatLng = js.native
  def getWest(): Double = js.native
  def getSouth(): Double = js.native
  def getEast(): Double = js.native
  def getNorth(): Double = js.native
  def contains(latLngBounds: LatLngBounds): Boolean = js.native
  def contains(latLng: LatLng): Boolean = js.native
  def intersects(otherBounds: LatLngBounds): Boolean = js.native
  def overlaps(otherBounds: Bounds): Boolean = js.native
  def toBBoxString(): String = js.native
  def equals(otherBounds: LatLngBounds): Boolean = js.native
  def isValid(): Boolean = js.native
}

@js.native
trait ZoomPanOptions extends js.Object
object ZoomPanOptions extends ZoomPanOptionBuilder(noOpts)
class ZoomPanOptionBuilder(val dict: OptMap)
    extends SCOptionBuilder[ZoomPanOptions, ZoomPanOptionBuilder](
      new ZoomPanOptionBuilder(_))
    with ZoomPanSetters[ZoomPanOptions, ZoomPanOptionBuilder]

trait ZoomPanSetters[T <: js.Object, B <: SCOptionBuilder[T, _]]
    extends SCOptionSetter[T, B] {
  def animate(v: Boolean) = jsOpt(v)
  def duration(v: Double) = jsOpt(v)
  def easeLinearity(v: Double) = jsOpt(v)
  def noMoveStart(v: Boolean) = jsOpt(v)
}

@js.native
trait FitBoundsOptions extends js.Object
object FitBoundsOptions extends FitBoundsOptionBuilder(noOpts)
class FitBoundsOptionBuilder(val dict: OptMap)
    extends SCOptionBuilder[FitBoundsOptions, FitBoundsOptionBuilder](
      new FitBoundsOptionBuilder(_))
    with FitBoundsSetters[FitBoundsOptions, FitBoundsOptionBuilder]
    with ZoomPanSetters[FitBoundsOptions, FitBoundsOptionBuilder]

trait FitBoundsSetters[T <: js.Object, B <: SCOptionBuilder[T, _]]
    extends SCOptionSetter[T, B] {
  def paddingTopLeft(v: Point) = jsOpt(v)
  def paddingBottomRight(v: Point) = jsOpt(v)
  def padding(v: Point) = jsOpt(v)
  def maxZoom(v: Int) = jsOpt(v)
}

@js.native
trait ZoomOptions extends js.Object
object ZoomOptions extends ZoomOptionBuilder(noOpts)
class ZoomOptionBuilder(val dict: OptMap)
    extends SCOptionBuilder[ZoomOptions, ZoomOptionBuilder](
      new ZoomOptionBuilder(_))
    with ZoomSetters[ZoomOptions, ZoomOptionBuilder]

trait ZoomSetters[T <: js.Object, B <: SCOptionBuilder[T, _]]
    extends SCOptionSetter[T, B] {
  def animate(v: Boolean) = jsOpt(v)
}

@js.native
trait PanOptions extends js.Object
object PanOptions extends PanOptionBuilder(noOpts)
class PanOptionBuilder(val dict: OptMap)
    extends SCOptionBuilder[PanOptions, PanOptionBuilder](
      new PanOptionBuilder(_))
    with PanSetters[PanOptions, PanOptionBuilder]

trait PanSetters[T <: js.Object, B <: SCOptionBuilder[T, _]]
    extends SCOptionSetter[T, B] {
  def animate(v: Boolean) = jsOpt(v)
  def duration(v: Double) = jsOpt(v)
  def easeLinearity(v: Double) = jsOpt(v)
  def noMoveStart(v: Boolean) = jsOpt(v)
}
@js.native
trait LMapOptions extends js.Object
object LMapOptions extends LMapOptionBuilder(noOpts)
class LMapOptionBuilder(val dict: OptMap)
    extends SCOptionBuilder[LMapOptions, LMapOptionBuilder](
      new LMapOptionBuilder(_)) {
  def preferCanvas(v: Boolean) = jsOpt(v)

  def attributionControl(v: Boolean) = jsOpt(v)
  def zoomControl(v: Boolean) = jsOpt(v)

  def closePopupOnClick(v: Boolean) = jsOpt(v)
  def zoomSnap(v: Int) = jsOpt(v)
  def zoomDelta(v: Int) = jsOpt(v)
  def trackResize(v: Boolean) = jsOpt(v)
  def boxZoom(v: Boolean) = jsOpt(v)
  def doubleClickZoom(v: Boolean | String) = jsOpt(v)
  def dragging(v: Boolean) = jsOpt(v)

  def center(v: LatLng) = jsOpt(v)
  def zoom(v: Int) = jsOpt(v)
  def minZoom(v: Int) = jsOpt(v)
  def maxZoom(v: Int) = jsOpt(v)

  def zoomAnimation(v: Boolean) = jsOpt(v)
  def zoomAnimationThreshold(v: Int) = jsOpt(v)
  def fadeAnimation(v: Boolean) = jsOpt(v)
  def markerZoomAnimation(v: Boolean) = jsOpt(v)
  def transform3DLimit(v: Int) = jsOpt(v)

  def inertia(v: Boolean) = jsOpt(v)
  def inertiaDeceleration(v: Int) = jsOpt(v)
  def inertiaMaxSpeed(v: Int) = jsOpt(v)
  def easeLinearity(v: Double) = jsOpt(v)
  def worldCopyJump(v: Boolean) = jsOpt(v)
  def maxBoundsViscosity(v: Double) = jsOpt(v)

  def keyboard(v: Boolean) = jsOpt(v)
  def keyboardPanDelta(v: Int) = jsOpt(v)

  def scrollWheelZoom(v: Boolean | String) = jsOpt(v)
  def wheelDebounceTime(v: Int) = jsOpt(v)
  def wheelPxPerZoomLevel(v: Int) = jsOpt(v)

  def tap(v: Boolean) = jsOpt(v)
  def tapTolerance(v: Int) = jsOpt(v)
  def touchZoom(v: Boolean | String) = jsOpt(v)
  def bounceAtZoomLimits(v: Boolean) = jsOpt(v)
}

@js.native
trait LatLng extends js.Object {
  val lat: Double
  val lng: Double
  val alt: Double
  def distanceTo(otherLatLng: LatLng): Double = js.native
  def wrap(): this.type = js.native
  def toBounds(sizeIntMeters: Int): LatLngBounds = js.native
}

@js.native
trait Layer extends js.Object with Evented {
  def addTo(map: LMap): this.type = js.native
  def onAdd(map: LMap): Unit = js.native
  def onRemove(map: LMap): Unit = js.native

  def bindPopup(html: String, popupOptions: PopupOptions = ???): this.type =
    js.native
  def unbindPopup(): this.type = js.native
  def openPopup(latlng: LatLng, popupOptions: PopupOptions = ???): this.type =
    js.native
  def openPopup(): this.type = js.native
  def openPopup(popup: Popup): this.type = js.native
  def closePopup(): this.type = js.native
  def closePopup(popup: Popup): this.type = js.native
  def togglePopup(): this.type = js.native
  def isPopupOpen(): Boolean = js.native
  def setPopupContent(content: js.Any): this.type = js.native
  def getPopup(): Popup = js.native

  def bindTooltip(html: String,
                  tooltipOptions: TooltipOptions = ???): this.type = js.native
  def unbindTooltip(): this.type = js.native
  def openTooltip(tooltip: Tooltip): this.type = js.native
  def openTooltip(latlng: LatLng, options: TooltipOptions = ???): this.type =
    js.native
  def closeTooltip(tooltip: Tooltip): this.type = js.native
  def closeTooltip(): this.type = js.native
  def toggleTooltip(): this.type = js.native
  def isTooltipOpen(): Boolean = js.native
  def setTooltipContent(content: js.Any): this.type = js.native
  def getTooltip(): Tooltip = js.native
}
@js.native
trait LayerGroup extends Layer {
  def toGeoJSON(): js.Object = js.native
  def addLayer(layer: Layer): this.type = js.native
  def removeLayer(layer: Layer): this.type = js.native
  def removeLayer(id: Int): this.type = js.native
  def hasLayer(layer: Layer): Boolean = js.native
  def clearLayers(): this.type = js.native
  def getLayer(id: Int): Layer = js.native
  def getLayers(): js.Array[Layer] = js.native
  def setZIndex(zIndex: Int): this.type = js.native
  def getLayerId(layer: Layer): Int = js.native
}

@js.native
trait FeatureGroup extends LayerGroup {
  def setStyle(style: PathOptions): this.type = js.native
  def bringToFront(): this.type = js.native
  def bringToBack(): this.type = js.native
  def getBounds(): LatLngBounds = js.native
}

@js.native
trait GeoJSON extends FeatureGroup {
  def addData(data: js.Any): this.type = js.native
  def resetStyle(): this.type = js.native
}

@js.native
trait GeoJSONOptions extends js.Object
object GeoJSONOptions extends GeoJSONOptionBuilder(noOpts)
class GeoJSONOptionBuilder(val dict: OptMap)
    extends SCOptionBuilder[GeoJSONOptions, GeoJSONOptionBuilder](
      new GeoJSONOptionBuilder(_))
    with GeoJSONSetters[GeoJSONOptions, GeoJSONOptionBuilder]

trait GeoJSONSetters[T <: js.Object, B <: SCOptionBuilder[T, _]]
    extends SCOptionSetter[T, B] {
  def pointToLayer(v: js.Function) = jsOpt(v)
  def style(v: js.Function) = jsOpt(v)
  def onEachFeature(v: js.Function) = jsOpt(v)
  def filter(v: js.Function) = jsOpt(v)
  def coordsToLatLng(v: js.Function) = jsOpt(v)

  def pane(v: String) = jsOpt(v)
  def attribution(v: String) = jsOpt(v)

}

@js.native
trait ImageOverlay extends Layer {
  def setOpacity(opacity: Double): this.type = js.native
  def bringToFront(): this.type = js.native
  def bringToBack(): this.type = js.native
  def setUrl(url: String, noRedraw: Boolean = ???): this.type = js.native
}

@js.native
trait ImageOverlayOptions extends js.Object
object ImageOverlayOptions extends ImageOverlayOptionBuilder(noOpts)
class ImageOverlayOptionBuilder(val dict: OptMap)
    extends SCOptionBuilder[ImageOverlayOptions, ImageOverlayOptionBuilder](
      new ImageOverlayOptionBuilder(_))
    with ImageOverlaySetters[ImageOverlayOptions, ImageOverlayOptionBuilder]

trait ImageOverlaySetters[T <: js.Object, B <: SCOptionBuilder[T, _]]
    extends SCOptionSetter[T, B] {
  def opacity(v: Double) = jsOpt(v)
  def alt(v: String) = jsOpt(v)
  def interactive(v: Boolean) = jsOpt(v)
  def crossOrigin(v: Boolean) = jsOpt(v)

  def pane(v: String) = jsOpt(v)
  def attribution(v: String) = jsOpt(v)
}
@js.native
trait TileLayer extends Layer {
  def setUrl(url: String, noRedraw: Boolean = ???): this.type = js.native
  def bringToFront(): this.type = js.native
  def bringToBack(): this.type = js.native
  def getContainer(): HTMLElement = js.native
  def setOpacity(opacity: Double): this.type = js.native
  def setZIndex(zIndex: Int): this.type = js.native
  def isLoading(): Boolean = js.native
  def redraw(): this.type = js.native
  def getTileSize(): Point = js.native
}

@js.native
trait TileLayerOptions extends js.Object
object TileLayerOptions extends TileLayerOptionBuilder(noOpts)
class TileLayerOptionBuilder(val dict: OptMap)
    extends SCOptionBuilder[TileLayerOptions, TileLayerOptionBuilder](
      new TileLayerOptionBuilder(_))
    with TileLayerSetters[TileLayerOptions, TileLayerOptionBuilder]
    with GridLayerSetters[TileLayerOptions, TileLayerOptionBuilder]

trait TileLayerSetters[T <: js.Object, B <: SCOptionBuilder[T, _]]
    extends SCOptionSetter[T, B] {
  //def icon(v:Boolean)= jsOpt("animate",v)
  def id(v: String) = jsOpt(v)
  def minZoom(v: Int) = jsOpt(v)
  def maxZoom(v: Int) = jsOpt(v)
  def maxNativeZoom(v: Int) = jsOpt(v)
  def minNativeZoom(v: Int) = jsOpt(v)
  def subdomains(v: String) = jsOpt(v)
  def errorTileUrl(v: String) = jsOpt(v)
  def zoomOffset(v: Int) = jsOpt(v)
  def tms(v: Boolean) = jsOpt(v)
  def zoomReverse(v: Boolean) = jsOpt(v)
  def detectRetina(v: Boolean) = jsOpt(v)
  def crossOrigin(v: Boolean) = jsOpt(v)

  def attribution(v: String) = jsOpt(v)
}

trait GridLayerSetters[T <: js.Object, B <: SCOptionBuilder[T, _]]
    extends SCOptionSetter[T, B] {
  //def icon(v:Boolean)= jsOpt("animate",v)
  def tileSize(v: Int | Point) = jsOpt(v)
  def opacity(v: Double) = jsOpt(v)
  def updateWhenIdle(v: Boolean) = jsOpt(v)
  def updateWhenZooming(v: Boolean) = jsOpt(v)
  def updateInterval(v: Int) = jsOpt(v)
  def zIndex(v: Int) = jsOpt(v)
  def bounds(v: LatLngBounds) = jsOpt(v)
  def noWrap(v: Boolean) = jsOpt(v)
  def pane(v: String) = jsOpt(v)
  def className(v: String) = jsOpt(v)
  def keepBuffer(v: Int) = jsOpt(v)

}

@js.native
trait Marker extends Layer {
  def toGeoJSON(): js.Object = js.native
  def getLatLng(): LatLng = js.native
  def setLatLng(latLng: LatLng): this.type = js.native
  def setZIndexOffset(offset: Int): this.type = js.native
  def setIcon(icon: Icon): this.type = js.native
  def setOpacity(opacity: Double): this.type = js.native
  val dragging: Handler = js.native
}

@js.native
trait MarkerOptions extends js.Object
object MarkerOptions extends MarkerOptionBuilder(noOpts)
class MarkerOptionBuilder(val dict: OptMap)
    extends SCOptionBuilder[MarkerOptions, MarkerOptionBuilder](
      new MarkerOptionBuilder(_))
    with MarkerSetters[MarkerOptions, MarkerOptionBuilder]

trait MarkerSetters[T <: js.Object, B <: SCOptionBuilder[T, _]]
    extends SCOptionSetter[T, B] {
  def icon(v: Icon) = jsOpt(v)
  def draggable(v: Boolean) = jsOpt(v)
  def keyboard(v: Boolean) = jsOpt(v)
  def title(v: String) = jsOpt(v)
  def alt(v: String) = jsOpt(v)
  def zIndexOffset(v: Int) = jsOpt(v)
  def opacity(v: Double) = jsOpt(v)
  def riseOnHover(v: Boolean) = jsOpt(v)
  def riseOffset(v: Int) = jsOpt(v)
  def pane(v: String) = jsOpt(v)

  def interactive(v: Boolean) = jsOpt(v)

  def attribution(v: String) = jsOpt(v)
}

@js.native
trait Icon extends Layer {
  def createIcon(oldIcon: HTMLElement = ???): HTMLElement = js.native
  def createShadow(oldIcon: HTMLElement = ???): HTMLElement = js.native
}

@js.native
trait IconOptions extends js.Object
object IconOptions extends IconOptionBuilder(noOpts)
class IconOptionBuilder(val dict: OptMap)
    extends SCOptionBuilder[IconOptions, IconOptionBuilder](
      new IconOptionBuilder(_))
    with IconSetters[IconOptions, IconOptionBuilder]

trait IconSetters[T <: js.Object, B <: SCOptionBuilder[T, _]]
    extends SCOptionSetter[T, B] {
  def iconUrl(v: String) = jsOpt(v)
  def iconRetinaUrl(v: String) = jsOpt(v)
  def iconSize(v: Point) = jsOpt(v)
  def iconAnchor(v: Point) = jsOpt(v)
  def popupAnchor(v: Point) = jsOpt(v)
  def shadowUrl(v: String) = jsOpt(v)
  def shadowRetinaUrl(v: String) = jsOpt(v)
  def shadowSize(v: Point) = jsOpt(v)
  def shadowAnchor(v: Point) = jsOpt(v)
  def className(v: String) = jsOpt(v)

  def pane(v: String) = jsOpt(v)
  def attribution(v: String) = jsOpt(v)

}
@js.native
trait Path extends Layer {
  def redraw(): this.type = js.native
  def setStyle(style: js.Dynamic): this.type = js.native
  def bringToFront(): this.type = js.native
  def bringToBack(): this.type = js.native
}

@js.native
trait PathOptions extends js.Object
object PathOptions extends PathOptionBuilder(noOpts)
class PathOptionBuilder(val dict: OptMap)
    extends SCOptionBuilder[PathOptions, PathOptionBuilder](
      new PathOptionBuilder(_))
    with PathSetters[PathOptions, PathOptionBuilder]

trait PathSetters[T <: js.Object, B <: SCOptionBuilder[T, _]]
    extends SCOptionSetter[T, B] {
  //def icon(v:Boolean)= jsOpt("animate",v)
  def stroke(v: Boolean) = jsOpt(v)
  def color(v: String) = jsOpt(v)
  def weight(v: Int) = jsOpt(v)
  def opacity(v: Double) = jsOpt(v)
  def lineCap(v: String) = jsOpt(v)
  def lineJoin(v: String) = jsOpt(v)
  def dashArray(v: String) = jsOpt(v)
  def dashOffset(v: String) = jsOpt(v)
  def fill(v: Boolean) = jsOpt(v)
  def fillColor(v: String) = jsOpt(v)
  def fillOpacity(v: Double) = jsOpt(v)
  def fillRule(v: String) = jsOpt(v)
  //def renderer(v:Boolean)= jsOpt(v)
  def className(v: String) = jsOpt(v)

  def interactive(v: Boolean) = jsOpt(v)

  def pane(v: String) = jsOpt(v)
  def attribution(v: String) = jsOpt(v)
}

@js.native
trait Polygon extends Polyline {}

@js.native
trait Polyline extends Path {
  def toGeoJSON(): js.Object = js.native
  def getLatLngs(): LatLngArray = js.native
  def setLatLngs(latLng: LatLngArray): this.type = js.native
  def isEmpty(): Boolean = js.native
  def getCenter(): LatLng = js.native
  def getBounds(): LatLngBounds = js.native
  def addLatLng(latLng: LatLng): this.type = js.native
}

@js.native
trait PolylineOptions extends js.Object
object PolylineOptions extends PolylineOptionBuilder(noOpts)
class PolylineOptionBuilder(val dict: OptMap)
    extends SCOptionBuilder[PolylineOptions, PolylineOptionBuilder](
      new PolylineOptionBuilder(_))
    with PathSetters[PolylineOptions, PolylineOptionBuilder]
    with PolylineSetters[PolylineOptions, PolylineOptionBuilder]

trait PolylineSetters[T <: js.Object, B <: SCOptionBuilder[T, _]]
    extends SCOptionSetter[T, B] {
  def smoothFactor(v: Double) = jsOpt(v)
  def noClip(v: Boolean) = jsOpt(v)
}

@js.native
trait Rectangle extends Polygon {
  def setBounds(latLng: LatLngBounds): this.type = js.native
}

@js.native
trait CircleMarker extends Path {
  def toGeoJSON(): js.Object = js.native
  def setLatLng(latLng: LatLng): this.type = js.native
  def getLatLng(): LatLng = js.native
  def setRadius(radius: Int): this.type = js.native
  def getRadius(): Int = js.native
}

@js.native
trait CircleMarkerOptions extends js.Object
object CircleMarkerOptions extends CircleMarkerOptionBuilder(noOpts)
class CircleMarkerOptionBuilder(val dict: OptMap)
    extends SCOptionBuilder[CircleMarkerOptions, CircleMarkerOptionBuilder](
      new CircleMarkerOptionBuilder(_))
    with PathSetters[CircleMarkerOptions, CircleMarkerOptionBuilder]
    with CircleMarkerSetters[CircleMarkerOptions, CircleMarkerOptionBuilder]

trait CircleMarkerSetters[T <: js.Object, B <: SCOptionBuilder[T, _]]
    extends SCOptionSetter[T, B] {
  //def icon(v:Boolean)= jsOpt("animate",v)
  def radius(v: Int) = jsOpt(v)
}

@js.native
trait Circle extends CircleMarker {
  def getBounds(): LatLngBounds = js.native
}

@js.native
trait CircleOptions extends js.Object
object CircleOptions extends CircleOptionBuilder(noOpts)
class CircleOptionBuilder(val dict: OptMap)
    extends SCOptionBuilder[CircleOptions, CircleOptionBuilder](
      new CircleOptionBuilder(_))
    with PathSetters[CircleOptions, CircleOptionBuilder]
    with CircleSetters[CircleOptions, CircleOptionBuilder]

trait CircleSetters[T <: js.Object, B <: SCOptionBuilder[T, _]]
    extends SCOptionSetter[T, B] {
  //def icon(v:Boolean)= jsOpt("animate",v)
  def radius(v: Int) = jsOpt(v)
}
@js.native
trait Point extends js.Object {
  val x: Int
  val y: Int
  def `clone()` : this.type = js.native
  def add(point: Point): this.type = js.native
  def subtract(point: Point): this.type = js.native
  def divideBy(num: Double): this.type = js.native
  def multiplyBy(num: Double): this.type = js.native
  def scaleBy(point: Point): this.type = js.native
  def unscaleBy(point: Point): this.type = js.native
  def round(): this.type = js.native
  def floor(): this.type = js.native
  def ceil(): this.type = js.native
  def distanceTo(point: Point): Double = js.native
  def equals(point: Point): Boolean = js.native
  def contains(point: Point): Boolean = js.native
}

@js.native
trait Bounds extends js.Object {
  val min: Point
  val max: Point
  def extend(point: Point): this.type = js.native
  def getCenter(round: Boolean = ???): Point = js.native
  def getBottomLeft(round: Boolean = ???): Point = js.native
  def getTopRight(round: Boolean = ???): Point = js.native
  def getSize(round: Boolean = ???): Point = js.native
  def contains(bounds: this.type): Boolean = js.native
  def contains(point: Point): Boolean = js.native
  def intersects(bounds: this.type): Boolean = js.native
  def overlaps(bounds: this.type): Boolean = js.native
}

@js.native
trait Popup extends Layer {
  def openOn(map: LMap): this.type = js.native
  def setLatLng(latlng: LatLng): this.type = js.native
  def getLatLng(): LatLng = js.native
  def setContent(content: String): this.type = js.native
  def getContent(): String = js.native
  def update(): Unit = js.native
  def isOpen(): Boolean = js.native
  def bringToFront(): this.type = js.native
  def bringToBack(): this.type = js.native
}

@js.native
trait PopupOptions extends js.Object
object PopupOptions extends PopupOptionBuilder(noOpts)
class PopupOptionBuilder(val dict: OptMap)
    extends SCOptionBuilder[PopupOptions, PopupOptionBuilder](
      new PopupOptionBuilder(_))
    with PopupSetters[PopupOptions, PopupOptionBuilder]
    with DivOverlaySetters[PopupOptions, PopupOptionBuilder]

trait PopupSetters[T <: js.Object, B <: SCOptionBuilder[T, _]]
    extends SCOptionSetter[T, B] {
  def maxWidth(v: Int) = jsOpt(v)
  def minWidth(v: Int) = jsOpt(v)
  def maxHeight(v: Int) = jsOpt(v)
  def autoPan(v: Boolean) = jsOpt(v)
  def autoPanPaddingTopLeft(v: Point) = jsOpt(v)
  def autoPanPaddingBottomRight(v: Point) = jsOpt(v)
  def autoPanPadding(v: Point) = jsOpt(v)
  def keepInView(v: Boolean) = jsOpt(v)
  def closeButton(v: Boolean) = jsOpt(v)
  def autoClose(v: Boolean) = jsOpt(v)
}

trait DivOverlaySetters[T <: js.Object, B <: SCOptionBuilder[T, _]]
    extends SCOptionSetter[T, B] {
  def offset(v: Point) = jsOpt(v)
  def className(v: String) = jsOpt(v)
  def pane(v: String) = jsOpt(v)
  def attribution(v: String) = jsOpt(v)
}

@js.native
trait Tooltip extends Layer {}

@js.native
trait TooltipOptions extends js.Object
object TooltipOptions extends TooltipOptionBuilder(noOpts)
class TooltipOptionBuilder(val dict: OptMap)
    extends SCOptionBuilder[TooltipOptions, TooltipOptionBuilder](
      new TooltipOptionBuilder(_))
    with TooltipSetters[TooltipOptions, TooltipOptionBuilder]
    with DivOverlaySetters[TooltipOptions, TooltipOptionBuilder]

trait TooltipSetters[T <: js.Object, B <: SCOptionBuilder[T, _]]
    extends SCOptionSetter[T, B] {
  def direction(v: String) = jsOpt(v)
  def permanent(v: Boolean) = jsOpt(v)
  def sticky(v: Boolean) = jsOpt(v)
  def interactive(v: Boolean) = jsOpt(v)
  def opacity(v: Double) = jsOpt(v)
}

import org.scalajs.dom.raw.{HTMLElement, MouseEvent}

object LMapEvent extends Enumeration {
  type LMapEvents = Value
  val zoomlevelschange, resize, unload, viewreset, load, zoomstart, zoom, move,
  zoomend, popupopen, popupclose, autopanstart, tooltipopen, tooltipclose,
  locationerror, locationfound, click, dblclick, mousedown, mouseup, mouseover,
  mouseout, mousemove, contextmenu, keypress, preclick, dragstart, movestart,
  drag, dragend, moveend, loading, tileunload, tileloadstart, tilerror,
  tileload, add, remove, zoomanim = Value
}

@js.native
trait LeafletEvent extends js.Object {
  val `type`: String
  val target: js.Object
}

@js.native
trait LeafletMouseEvent extends LeafletEvent {
  val latlng: LatLng
  val layerPoint: Point
  val containerPoint: Point
  val originalEvent: MouseEvent
}

@js.native
trait LeafletMarkerMoveEvent extends LeafletEvent {
  val oldLatLng: LatLng
  val latlng: LatLng
}

@js.native
trait LeafletPopupEvent extends LeafletEvent {
  val popup: Popup
}

@js.native
trait LeafletTooltipEvent extends LeafletEvent {
  val tooltip: Tooltip
}

@js.native
trait LeafletTileEvent extends LeafletEvent {
  val tile: HTMLElement
  val coords: Point
}

@js.native
trait LeafletTileErrorEvent extends LeafletTileEvent {
  val error: js.Any
}

@js.native
trait Handler extends js.Object {
  def enable(): this.type = js.native
  def disable(): this.type = js.native
  def enabled: Boolean = js.native
}
