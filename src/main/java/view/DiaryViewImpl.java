package view;
 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

import model.common.Diary;
import presenter.DiaryPresenter; 
import view.common.MainLayout;

/**
 * Diaries view for patients to add new diary entries.
 */ 
@Route(value = "diaries", layout = MainLayout.class)
public class DiaryViewImpl extends VerticalLayout implements IDiaryView {
	private static final long serialVersionUID = -1763030112751433022L;
	
	/**
	 *  @listeners: Arraylist with all listeners for the Diary 
	 *  @userInput: created to display what the user tipped in
	 *  @textAreaText: place where the User can write the Diary in
	 */
	
	private List<IDiaryViewListener> listeners = new ArrayList<IDiaryViewListener>();	
	private TextField userInput = new TextField();
	private TextArea textArea;
	private String textAreaText;
	
	public DiaryViewImpl() {
		// created an instance for the diary Model
		Diary diaryModel = new Diary();
		new DiaryPresenter(diaryModel, this);
		/**
		 * Vaadin Components
		 */
		Text titleText = new Text("Diary");
		TextArea textArea = new TextArea();
		textArea.getStyle().set("minHeight", "350px");
		textArea.getStyle().set("minWidth", "450px");
		textArea.setPlaceholder("Please write down the events that you experienced today");
		add(titleText, textArea);
		/** 
		 * added setValueChangeMode to send EACH character of the Diary to the server
		 * the addValueChangeListener will save the last version of the diary 
		 * so it can be seen in the userInput field
		 */
		textArea.setValueChangeMode(ValueChangeMode.EAGER);
		textArea.addValueChangeListener(event ->
		textAreaText = event.getValue());
		// call add method on the createButton method and give the label Save to it
		add(createButton("Save"));
		userInput.setReadOnly(true);
		add(userInput);
		
	}
	/**
	 * Method for auto-generating a button
	 * @param label: takes in a label that can be different according to cases 
	 * @return: a new Button with the given label and returns the result of the fired event
	 */
	private Button createButton(String label) {			
		return new Button(label, event -> {			
			for (IDiaryViewListener listener : listeners) {
				//listener.buttonClick(textArea.getValue());
			    //this.showNotification(textArea.getValue());
				listener.buttonClick(textAreaText);
			}
		});
	}	

	 
	@Override
	public void addDiaryListener(IDiaryViewListener listener) {
		listeners.add(listener);
	}

	/**
	 * getValue from Vaadin wasn't working right --> created purgeTextArea to return the "value" (aka Diary) that the user wrote
	 * 
	 */
	@Override
	public void purgeTextArea(TextArea someTextArea) {
		textArea.setValue(textAreaText);
	}
	
	// sets the display area to the diary that was written by the user
	@Override
	public void setUserInput(String display) {
		userInput.setValue(display);
		
	}
    // shows the a notification that the diary was saved
	@Override
	public void showNotification(String notification) {
		Notification.show(notification);
		
	}

	@Override
	public TextArea getTextArea() {
		// will be used to return the existing diaries to the user like a list
		return null;
	}
}
