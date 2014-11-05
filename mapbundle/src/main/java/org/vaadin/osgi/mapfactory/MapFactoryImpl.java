package org.vaadin.osgi.mapfactory;


import org.vaadin.osgi.bridge.uifragments.FragmentFactory;

import com.vaadin.data.Property;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class MapFactoryImpl implements FragmentFactory {

	@Override
	public Component getFragment() {
		VerticalLayout component=new VerticalLayout();
		component.setSizeFull();
		component.addComponent(new Label("This is a map"));
		
		return new Label("This is a map");
	}

	@Override
	public String getName() {
		return "Map component";
	}

}
