package view;

import java.util.ArrayList;

import com.vaadin.flow.component.textfield.TextArea;
/**
 * Interface for the diary
 */
public interface IDiaryView {

	public void setUserInput(String display);
	
	// declaration for the listener 
	interface IDiaryViewListener{
		void buttonClick(String diariestext);
	}
	// methods declarations
	public void addDiaryListener(IDiaryViewListener listener);
	public void showNotification(String notification);
	public void purgeTextArea(TextArea someTextArea);
	public TextArea getTextArea();
}
