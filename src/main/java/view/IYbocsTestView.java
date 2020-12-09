package view;

import java.util.ArrayList;

import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

import view.common.NavigationView;

/**
 * view
 * @author ADEK
 *
 */
public interface IYbocsTestView {
	
	public void setDisplay(String displayString);
	
	interface IYbocsTestViewListener{
		void buttonClick(String operation);
		void buttonClick(ArrayList<RadioButtonGroup<Integer>> buttongroups);
	}
	public void addYbocsListener(IYbocsTestViewListener listener);
	
	public void showNotification(String notification);
}
