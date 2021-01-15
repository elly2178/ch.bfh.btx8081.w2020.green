package view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

/**
 * View interface for the ybocs test
 */
public interface IYbocsTestView {
	
	public void setDisplay(String displayString);
	
	interface IYbocsTestViewListener{
		 
		void buttonClick(List<RadioButtonGroup<Integer>> buttongroups);
	}
	public void addYbocsListener(IYbocsTestViewListener listener);
	
	public void showNotification(String notification);
}
