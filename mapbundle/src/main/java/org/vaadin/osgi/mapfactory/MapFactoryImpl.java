package org.vaadin.osgi.mapfactory;


import org.vaadin.osgi.bridge.uifragments.FragmentFactory;
import org.vaadin.osgi.bridge.uifragments.UIFragment;

public class MapFactoryImpl implements FragmentFactory {

	@Override
	public UIFragment getFragment() {
        return new MapFragment();
	}

	@Override
	public String getName() {
		return "Map component";
	}
}
