package view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
/**
 * View interface for the diary
 */
public interface IMoodTestView {
	public void setDisplay(String display);
	
	interface IMoodTestViewListener{
		 
		void buttonClick(List<RadioButtonGroup<Integer>> buttongroups);
	}
	
	public void addMoodListener(IMoodTestViewListener listener);
	public void showNotification(String notification);
}
