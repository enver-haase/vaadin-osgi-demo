package org.vaadin.osgi.tablefactory;


import org.vaadin.osgi.bridge.uifragments.FragmentFactory;
import org.vaadin.osgi.bridge.uifragments.UIFragment;

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
