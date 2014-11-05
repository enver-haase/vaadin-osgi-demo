package org.vaadin.osgi.demo.layouts;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalSplitPanel;

public class FourSlotLayout extends AbstractSlotLayout {
	
	private static final long serialVersionUID = 1L;
	private VerticalSplitPanel root;
	private HorizontalSplitPanel topPanel;
	private HorizontalSplitPanel bottomPanel;
	
	public FourSlotLayout(){
		super();
		root=new VerticalSplitPanel();
		topPanel=createHorizontalSplitPanel();
		bottomPanel=createHorizontalSplitPanel();
		root.setFirstComponent(topPanel);
		root.setSecondComponent(bottomPanel);
		setCompositionRoot(root);
	}

}
