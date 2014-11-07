package org.vaadin.osgi.leafletfactory;

import java.util.ArrayList;
import java.util.Arrays;

import org.vaadin.addon.leaflet.AbstractLeafletLayer;
import org.vaadin.addon.leaflet.LCircle;
import org.vaadin.addon.leaflet.LCircleMarker;
import org.vaadin.addon.leaflet.LMap;
import org.vaadin.addon.leaflet.LMarker;
import org.vaadin.addon.leaflet.LOpenStreetMapLayer;
import org.vaadin.addon.leaflet.LPolygon;
import org.vaadin.addon.leaflet.LPolyline;
import org.vaadin.addon.leaflet.LTileLayer;
import org.vaadin.addon.leaflet.LeafletClickEvent;
import org.vaadin.addon.leaflet.LeafletClickListener;
import org.vaadin.addon.leaflet.LeafletMoveEndEvent;
import org.vaadin.addon.leaflet.LeafletMoveEndListener;
import org.vaadin.addon.leaflet.shared.Bounds;
import org.vaadin.addon.leaflet.shared.Control;
import org.vaadin.addon.leaflet.shared.Point;

import com.vaadin.server.ClassResource;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.VerticalLayout;

public class LeafletMap extends VerticalLayout{
	
	public LeafletMap(){
        Component map = getMap();
        map.setSizeFull();
        addComponent(map);
        setExpandRatio(map, 1);
	}
	

	private LMap leafletMap;
	private CheckBox addMarkers;
	private CheckBox delete;
	private LMarker leafletMarker;

	public Component getMap() {
		leafletMap = new LMap();
		leafletMap.setCenter(60.4525, 22.301);
		leafletMap.setZoomLevel(15);

		leafletMap.setControls(new ArrayList<Control>(Arrays.asList(Control
				.values())));

		LPolyline leafletPolyline = new LPolyline(new Point(60.45, 22.295),
				new Point(60.4555, 22.301), new Point(60.45, 22.307));
		leafletPolyline.setColor("#FF00FF");
		leafletPolyline.setFill(true);
		leafletPolyline.setFillColor("#00FF00");
		leafletPolyline.setClickable(false);
		leafletPolyline.setWeight(8);
		leafletPolyline.setOpacity(0.5);
		leafletPolyline.setDashArray("15, 10, 5, 10, 15");
		leafletMap.addComponent(leafletPolyline);

		LPolygon leafletPolygon = new LPolygon(new Point(60.455, 22.300),
				new Point(60.456, 22.302), new Point(60.50, 22.308));
		leafletPolygon.setColor("#FF00FF");
		leafletPolygon.setFill(true);
		leafletPolygon.setFillColor("#00FF00");
		leafletMap.addComponent(leafletPolygon);

		LCircle leafletCircle = new LCircle(60.4525, 22.301, 300);
		leafletCircle.setColor("#00FFFF");
		// leafletCircle.addClickListener(listener);
		leafletMap.addComponent(leafletCircle);

		LCircleMarker leafletCircleMarker = new LCircleMarker(60.4525, 22.301, 5);
		leafletCircleMarker.setColor("#FFFF00");
		leafletMap.addComponent(leafletCircleMarker);

		leafletMarker = new LMarker(60.4525, 22.301);
		leafletMarker.setTitle("this is marker two!");
//		leafletMarker
//				.setDivIcon("this is a <h1>fabulous</h1> <span style=\"color:red\">icon</span>");
		leafletMarker.setPopup("Hello <b>world</b>");
		leafletMap.addComponent(leafletMarker);

		leafletMarker = new LMarker(60.4525, 22.301);
		leafletMarker.setIcon(new ClassResource("testicon.png"));
		leafletMarker.setIconSize(new Point(57, 52));
		leafletMarker.setIconAnchor(new Point(57, 26));
		leafletMarker.setTitle("this is marker one!");
		leafletMarker.setPopup("Hello <b>Vaadin World</b>!");
		
		leafletMap.addComponent(leafletMarker);
		leafletMap.setAttributionPrefix("Powered by Leaflet with v-leaflet");

		leafletMap.addBaseLayer(new LOpenStreetMapLayer(), "CloudMade");

		// This will make everything sharper on "retina devices", but also text
		// quite small
		// baselayer.setDetectRetina(true);

		LTileLayer pk = new LTileLayer();
		pk.setUrl("http://{s}.kartat.kapsi.fi/peruskartta/{z}/{x}/{y}.png");
		pk.setAttributionString("Maanmittauslaitos, hosted by kartat.kapsi.fi");
		pk.setMaxZoom(18);
		pk.setSubDomains("tile2");
		pk.setDetectRetina(true);

		leafletMap.addBaseLayer(pk, "Peruskartta");


		leafletMap.addMoveEndListener(new LeafletMoveEndListener() {
			@Override
			public void onMoveEnd(LeafletMoveEndEvent event) {
				Bounds b = event.getBounds();
				Notification.show(
						String.format("New viewport (%.4f,%.4f ; %.4f,%.4f)",
								b.getSouthWestLat(), b.getSouthWestLon(),
								b.getNorthEastLat(), b.getNorthEastLon()),
						Type.TRAY_NOTIFICATION);
			}
		});

		return leafletMap;
	}

	public void resetZoom() {
		leafletMap.setZoomLevel(15);
	}

	public void resetCenter() {
		leafletMap.setCenter(60.4525, 22.301);
	}
}
