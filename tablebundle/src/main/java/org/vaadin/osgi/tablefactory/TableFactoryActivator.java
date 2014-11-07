package org.vaadin.osgi.tablefactory;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.vaadin.osgi.bridge.uifragments.FragmentFactory;

public class TableFactoryActivator implements BundleActivator {

	private ServiceRegistration<FragmentFactory> serviceRegistration;
	private TableFactoryImpl service;

	@Override
	public void start(BundleContext context) throws Exception {
		service = new TableFactoryImpl();
		serviceRegistration = context.registerService(FragmentFactory.class, service, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
	}

}
