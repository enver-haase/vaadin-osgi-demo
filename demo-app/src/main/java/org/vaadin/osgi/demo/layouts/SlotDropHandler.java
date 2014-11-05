package org.vaadin.osgi.demo.layouts;

import com.vaadin.ui.Component;

public interface SlotDropHandler {
	
	/** Returns the component that should be actually added to the layout. Note that if you return the dropped component itself,
	 * you need to take care that it is removed from the source first
	 * 
	 * @param dropped the dropped component
	 * @return replacement component that should be added to the slot layotu
	 */
	public Component getReplacement(Component dropped);
	
	/** Call back interface that is called when a component is removed from a slot layout
	 * 
	 * @param component
	 */
	public void componentRemoved(Component component);
	
}
