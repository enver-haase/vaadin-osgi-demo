package org.vaadin.osgi.leafletfactory;


import org.vaadin.osgi.bridge.uifragments.FragmentFactory;
import org.vaadin.osgi.bridge.uifragments.UIFragment;


public class MapFactoryImpl implements FragmentFactory {

	@Override
	public UIFragment getFragment() {
		return new LeafletMapFragment();
	}

	@Override
	public String getName() {
		return "Leaflet component";
	}
}
