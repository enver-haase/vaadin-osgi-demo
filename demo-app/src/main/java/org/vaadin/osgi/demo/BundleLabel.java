package org.vaadin.osgi.demo;

import org.osgi.framework.ServiceReference;
import org.vaadin.osgi.bridge.uifragments.FragmentFactory;

import com.vaadin.ui.Label;

public class BundleLabel extends Label{

	private ServiceReference<FragmentFactory> reference;
	
	public BundleLabel(String name, ServiceReference<FragmentFactory> reference){
		super(name);
		this.reference=reference;
	}
	
	public ServiceReference<FragmentFactory> getReference(){
		return reference;
	}
}
