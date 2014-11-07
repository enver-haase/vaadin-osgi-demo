package org.vaadin.osgi.mapfactory;

import java.util.Arrays;
import java.util.List;

import org.vaadin.osgi.bridge.uifragments.UIFragment;

import com.vaadin.ui.Component;

public class MapFragment implements UIFragment{

	private BasicMap map;
	
	@Override
	public Component getComponent() {
		if(map==null){
			map=new BasicMap();
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
	}

}
