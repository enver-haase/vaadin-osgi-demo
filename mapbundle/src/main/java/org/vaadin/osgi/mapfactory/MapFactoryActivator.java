package org.vaadin.osgi.mapfactory;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.vaadin.osgi.bridge.uifragments.FragmentFactory;

public class MapFactoryActivator implements BundleActivator {

	private ServiceRegistration<FragmentFactory> serviceRegistration;
	private MapFactoryImpl service;

	@Override
	public void start(BundleContext context) throws Exception {
		service = new MapFactoryImpl();
		serviceRegistration = context.registerService(FragmentFactory.class, service, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
	}

}
