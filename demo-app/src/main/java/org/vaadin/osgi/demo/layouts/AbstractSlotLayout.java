package org.vaadin.osgi.demo.layouts;

import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropTarget;
import com.vaadin.event.dd.TargetDetails;
import com.vaadin.shared.ui.dd.HorizontalDropLocation;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;

import fi.jasoft.dragdroplayouts.DDAbsoluteLayout;
import fi.jasoft.dragdroplayouts.DDHorizontalSplitPanel;
import fi.jasoft.dragdroplayouts.DDHorizontalSplitPanel.HorizontalSplitPanelTargetDetails;
import fi.jasoft.dragdroplayouts.drophandlers.DefaultHorizontalSplitPanelDropHandler;
import fi.jasoft.dragdroplayouts.events.LayoutBoundTransferable;

public abstract class AbstractSlotLayout extends CustomComponent {

	protected SlotDropHandler dropHandler;
	
	public AbstractSlotLayout(){
		this.setSizeFull();
	}
	
	protected DDHorizontalSplitPanel createHorizontalSplitPanel(){
		DDHorizontalSplitPanel panel=new DDHorizontalSplitPanel();
		panel.setFirstComponent(new Label("<Drag bundle here>"));
		panel.setSecondComponent(new Label("<Drag bundle here>"));
		panel.setSizeFull();
		panel.setDropHandler(new CustomSplitPanelDropHandler());
		return panel;
	}
	
	public void setSlotDropHandler(SlotDropHandler handler){
		this.dropHandler=handler;
	}
	
	public class CustomSplitPanelDropHandler extends DefaultHorizontalSplitPanelDropHandler{

		private static final long serialVersionUID = 1L;
		
		@Override
		protected void handleDropFromLayout(DragAndDropEvent event) {
			// ignore if no drop handler registered
			if(dropHandler==null){
				return;
			}
		    LayoutBoundTransferable transferable = (LayoutBoundTransferable) event.getTransferable();
		    HorizontalSplitPanelTargetDetails details =
		        (HorizontalSplitPanelTargetDetails) event.getTargetDetails();
		    Component component = transferable.getComponent();
		    DDHorizontalSplitPanel panel = (DDHorizontalSplitPanel) details.getTarget();

		    // We don't want to remove the component from source - instead we ask the component provider
		    // for a component matching the dragged component
//		    source.removeComponent(component);
		    Component replacement=dropHandler.getReplacement(component);
		    if (details.getDropLocation() == HorizontalDropLocation.LEFT) {
		    	// Dropped in the left area
		    	if(panel.getFirstComponent()!=null){
		    		// notify drop handler that we have removed a component
		    		dropHandler.componentRemoved(panel.getFirstComponent());
		    	}
		    	panel.setFirstComponent(replacement);
		    } else if (details.getDropLocation() == HorizontalDropLocation.RIGHT) {
		      // Dropped in the right area
		    	if(panel.getSecondComponent()!=null){
		    		// notify drop handler that we have removed a component
		    		dropHandler.componentRemoved(panel.getSecondComponent());
		    	}
		        panel.setSecondComponent(replacement);
		    }
		}
	}
}
