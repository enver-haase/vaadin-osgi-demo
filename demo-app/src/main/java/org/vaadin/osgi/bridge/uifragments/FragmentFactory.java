package org.vaadin.osgi.bridge.uifragments;

import com.vaadin.ui.Component;

public interface FragmentFactory {
	public Component getFragment();
	
	public String getName();
	
	
}
