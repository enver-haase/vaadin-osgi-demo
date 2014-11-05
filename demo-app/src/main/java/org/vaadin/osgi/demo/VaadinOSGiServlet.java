package org.vaadin.osgi.demo;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

@WebServlet(value = "/*", asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = VaadinOSGiUI.class, widgetset = "org.vaadin.osgi.demo.demowidgetset")
public class VaadinOSGiServlet extends VaadinServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7204996277655209911L;
}