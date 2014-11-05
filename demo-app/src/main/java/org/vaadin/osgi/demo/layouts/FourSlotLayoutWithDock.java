package org.vaadin.osgi.demo.layouts;

import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.shared.ui.dd.VerticalDropLocation;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalSplitPanel;

import fi.jasoft.dragdroplayouts.DDVerticalLayout;
import fi.jasoft.dragdroplayouts.DDVerticalLayout.VerticalLayoutTargetDetails;
import fi.jasoft.dragdroplayouts.drophandlers.DefaultVerticalLayoutDropHandler;
import fi.jasoft.dragdroplayouts.events.LayoutBoundTransferable;

public class FourSlotLayoutWithDock extends AbstractSlotLayout{
	
	private HorizontalLayout root;
	private VerticalSplitPanel verticalPanel;
	private HorizontalSplitPanel topPanel;
	private HorizontalSplitPanel bottomPanel;
	
	public FourSlotLayoutWithDock(){
		super();
		root=new HorizontalLayout();
		root.setSizeFull();
		verticalPanel=new VerticalSplitPanel();
		verticalPanel.setSizeFull();
		topPanel=createHorizontalSplitPanel();
		bottomPanel=createHorizontalSplitPanel();
		verticalPanel.setFirstComponent(topPanel);
		verticalPanel.setSecondComponent(bottomPanel);
		root.addComponent(verticalPanel);
		root.setExpandRatio(verticalPanel, 1.0f);
		// create dock
		DDVerticalLayout dock=new DDVerticalLayout();
		dock.addStyleName("dock");
		dock.setCaption("DOCK");
		dock.setWidth("300px");
		dock.setHeight("100%");
		dock.setDropHandler(new CustomVerticalLayoutDropHandler());
		root.addComponent(dock);
		setCompositionRoot(root);
	}
	
	public class CustomVerticalLayoutDropHandler extends DefaultVerticalLayoutDropHandler{

		@Override
		protected void handleDropFromLayout(DragAndDropEvent event) {
		    LayoutBoundTransferable transferable = (LayoutBoundTransferable) event.getTransferable();
		    VerticalLayoutTargetDetails details = (VerticalLayoutTargetDetails) event.getTargetDetails();
		    AbstractOrderedLayout layout = (AbstractOrderedLayout) details.getTarget();
		    Component source = event.getTransferable().getSourceComponent();
		    int idx = (details).getOverIndex();
		    Component comp = transferable.getComponent();

		    // Check that we are not dragging an outer layout into an inner
		    // layout
		    Component parent = layout.getParent();
		    while (parent != null) {
		      if (parent == comp) {
		        return;
		      }
		      parent = parent.getParent();
		    }
// we don't want to remove the component
//		    if (source instanceof ComponentContainer) {
//		      ComponentContainer sourceLayout = (ComponentContainer) source;
//		      sourceLayout.removeComponent(comp);
//		    }
		    
		    Component replacement=dropHandler.getReplacement(comp);

		    // Increase index if component is dropped after or above a
		    // previous
		    // component
		    VerticalDropLocation loc = (details).getDropLocation();
		    if (loc == VerticalDropLocation.MIDDLE || loc == VerticalDropLocation.BOTTOM) {
		      idx++;
		    }

		    // Add component
		    if (idx >= 0) {
		      layout.addComponent(replacement, idx);
		    } else {
		      layout.addComponent(replacement);
		    }
		}

		
	}


}
