package org.vaadin.osgi.tablefactory;

import java.util.List;

import org.vaadin.osgi.bridge.uifragments.UIFragment;

import com.vaadin.data.Item;
import com.vaadin.ui.Component;
import com.vaadin.ui.Table;

public class TableFragment implements UIFragment {

	@SuppressWarnings("unchecked")
	@Override
	public Component getComponent() {
		Table table=new Table();
		table.addContainerProperty("city", String.class, "");
		table.addContainerProperty("population", String.class, "");
		table.addContainerProperty("men", String.class, "");
		table.addContainerProperty("women", String.class, "");
		
		table.setColumnHeader("city", "Town");
		table.setColumnHeader("popuplation", "Population");
		table.setColumnHeader("men", "Men");
		table.setColumnHeader("womer", "Women");
		
		Item item=table.addItem("1");
		
		item.getItemProperty("city").setValue("Turku");
		item.getItemProperty("population").setValue("183811");
		item.getItemProperty("men").setValue("87303");
		item.getItemProperty("women").setValue("96508");

		item=table.addItem("2");
		item.getItemProperty("city").setValue("Kaarina");
		item.getItemProperty("population").setValue("32022");
		item.getItemProperty("men").setValue("15694");
		item.getItemProperty("women").setValue("16328");
		
		item=table.addItem("3");
		item.getItemProperty("city").setValue("Naantali");
		item.getItemProperty("population").setValue("18870");
		item.getItemProperty("men").setValue("9151");
		item.getItemProperty("women").setValue("9719");
		
		item=table.addItem("4");
		item.getItemProperty("city").setValue("Lieto");
		item.getItemProperty("population").setValue("17191");
		item.getItemProperty("men").setValue("8567");
		item.getItemProperty("women").setValue("8624");
		
		item=table.addItem("5");
		item.getItemProperty("city").setValue("Masku");
		item.getItemProperty("population").setValue("9714");
		item.getItemProperty("men").setValue("4897");
		item.getItemProperty("women").setValue("4817");
		
		item=table.addItem("6");
		item.getItemProperty("city").setValue("Rusko");
		item.getItemProperty("population").setValue("6009");
		item.getItemProperty("men").setValue("2976");
		item.getItemProperty("women").setValue("3033");
		
		return table;
	}

	@Override
	public List<String> getActions() {
		return null;
	}

	@Override
	public void actionPerformed(String action) {
		// NO-OP
	}

}
