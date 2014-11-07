package org.vaadin.osgi.demo;

import java.util.List;

import org.vaadin.osgi.bridge.uifragments.UIFragment;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/** This is a wrapper component for the component returned by the fragment factory.
 * Adds separate header with caption and action buttons for the fragment
 * 
 * @author mjhosio
 *
 */
public class FragmentWrapper extends CustomComponent{
	
	private UIFragment fragment;
	private HorizontalLayout header;
	private HorizontalLayout actions;
	private Label caption;
	private VerticalLayout rootLayout=new VerticalLayout();
	
	public FragmentWrapper(UIFragment fragment){
		this.fragment=fragment;
		rootLayout.setSizeFull();
		header=new HorizontalLayout();
		header.addStyleName("fragment-wrapper-header");
		header.setWidth("100%");
		caption=new Label();
		caption.setSizeUndefined();
		header.addComponent(caption);
		actions=new HorizontalLayout();
		actions.setSpacing(true);
		setActions(fragment.getActions());
		header.addComponent(actions);
		header.setComponentAlignment(actions, Alignment.TOP_RIGHT);
		rootLayout.addComponent(header);
		Component component=fragment.getComponent();
		component.setSizeFull();
		rootLayout.addComponent(component);
		rootLayout.setExpandRatio(component, 1.0f);
		this.setCompositionRoot(rootLayout);
	}
	
	public void setCaption(String caption){
		this.caption.setValue(caption);
	}
	
	private void setActions(List<String> actions){
		if(actions!=null){
			for(String action: actions){
				Button actionButton=new Button(action);
				actionButton.addStyleName(ValoTheme.BUTTON_TINY);
				actionButton.addClickListener(new Button.ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						fragment.actionPerformed(action);
					}
				});
				this.actions.addComponent(actionButton);
			}
		}
	}
}
