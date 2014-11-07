package org.vaadin.osgi.tablefactory;


import java.util.Arrays;
import java.util.List;

import org.vaadin.osgi.bridge.uifragments.FragmentFactory;
import org.vaadin.osgi.bridge.uifragments.UIFragment;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class TableFactoryImpl implements FragmentFactory {

	@Override
	public UIFragment getFragment() {
		return new TableFragment();
	}

	@Override
	public String getName() {
		return "Table component";
	}
}
