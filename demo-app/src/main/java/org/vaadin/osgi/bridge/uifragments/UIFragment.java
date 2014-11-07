package org.vaadin.osgi.bridge.uifragments;

import java.util.List;

import com.vaadin.ui.Component;

public interface UIFragment{

	/** Gets the ui representation of the component
	 * 
	 * @return
	 */
	public Component getComponent();
	
	/** Gets the component actions
	 * 
	 * @return
	 */
	public List<String> getActions();
	
	/** Callback on action performed
	 * 
	 * @param action
	 */
	public void actionPerformed(String action);
}
