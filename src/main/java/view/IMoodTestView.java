package view;

import java.util.ArrayList;

import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

public interface IMoodTestView {
	public void setDisplay(String display);
	
	interface IMoodTestViewListener{
		 
		void buttonClick(ArrayList<RadioButtonGroup<Integer>> buttongroups);
	}
	
	public void addMoodListener(IMoodTestViewListener listener);
	public void showNotification(String notification);
}
