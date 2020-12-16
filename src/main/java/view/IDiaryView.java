package view;

import java.util.ArrayList;

import com.vaadin.flow.component.textfield.TextArea;

public interface IDiaryView {

	public void setUserInput(String display);
	
	interface IDiaryViewListener{
		void buttonClick(ArrayList<TextArea> diariestext) ;
	}
	
	public void addDiaryListener(IDiaryViewListener listener);
	public void showNotification(String notification);
}
