package org.vaadin.osgi.mapfactory;

import java.util.HashMap;
import java.util.Map;

import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.OLView;
import org.vaadin.addon.vol3.OLViewOptions;
import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.addon.vol3.client.source.OLMapQuestLayerName;
import org.vaadin.addon.vol3.layer.OLLayer;
import org.vaadin.addon.vol3.layer.OLTileLayer;
import org.vaadin.addon.vol3.source.OLMapQuestSource;
import org.vaadin.addon.vol3.source.OLSource;
import org.vaadin.addon.vol3.source.OLTileWMSSource;
import org.vaadin.addon.vol3.source.OLTileWMSSourceOptions;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class BasicMap extends VerticalLayout {

    protected OLMap map;

    public BasicMap() {
        this.setSizeFull();
        map=createMap();
        this.addComponent(map);
        this.setExpandRatio(this.iterator().next(),1.0f);
    }
    
    public void resetCenter(){
        map.getView().setCenter(0,0);
    }
    
    public void resetZoom(){
    	map.getView().setZoom(1);
    }

    protected OLMap createMap(){
        OLMap map=new OLMap();
        OLLayer layer=createLayer(createSource());
        map.addLayer(layer);
        map.setView(createView());
        map.setSizeFull();
        return map;
    }

    protected OLLayer createLayer(OLSource source){
        return new OLTileLayer(source);
    }

    protected OLSource createSource() {
        OLTileWMSSourceOptions options =new OLTileWMSSourceOptions();
        // WebMapService of World http://www.osm-wms.de/
        options.setUrl("http://129.206.228.72/cached/osm");
        Map<String,String> params=new HashMap<String,String>();
        params.put("LAYERS","osm_auto:all");
        params.put("FORMAT","image/png");
        options.setParams(params);
        options.setGutter(2.0);
        return new OLTileWMSSource(options);
    }

    protected OLView createView() {
        OLViewOptions opts=new OLViewOptions();
        // this is the projection this map server expects
        // same as EPSG: 3857 but the map server does not recognize that...
        opts.setProjection("EPSG:900913");
        OLView view=new OLView(opts);
        view.setZoom(1);
        view.setCenter(0,0);
        return view;
    }
}
