package org.vaadin.osgi.leafletfactory;

import java.util.Arrays;
import java.util.List;

import org.vaadin.osgi.bridge.uifragments.UIFragment;

import com.vaadin.ui.Component;

public class LeafletMapFragment implements UIFragment{

	private LeafletMap map;
	
	@Override
	public Component getComponent() {
		if(map==null){
			map=new LeafletMap();
		}
		return map;
	}

	@Override
	public List<String> getActions() {
		return Arrays.asList(new String[]{
			"reset center", "reset zoom"	
		});
	}

	@Override
	public void actionPerformed(String action) {
		if(action.equals("reset center")){
			map.resetCenter();
		} else if (action.equals("reset zoom")){
			map.resetZoom();
		}
	}}
