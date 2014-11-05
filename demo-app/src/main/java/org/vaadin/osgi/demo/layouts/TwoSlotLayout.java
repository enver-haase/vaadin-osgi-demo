package org.vaadin.osgi.demo.layouts;

import com.vaadin.ui.HorizontalSplitPanel;

public class TwoSlotLayout extends AbstractSlotLayout{
	private HorizontalSplitPanel root;
	
	public TwoSlotLayout(){
		super();
		root=createHorizontalSplitPanel();
		setCompositionRoot(root);
	}

}
