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
import com.vaadin.flow.router.Route;

import model.common.Diary;
import presenter.DiaryPresenter; 
import view.common.MainLayout;

/**
 * Diaries view for patients to add new diary entries.
 */ 
@Route(value = "diaries", layout = MainLayout.class)
public class DiaryViewImpl extends VerticalLayout implements IDiaryView {
	private ArrayList<IDiaryViewListener> listeners = new ArrayList<IDiaryViewListener>();
	private ArrayList<TextArea> diariestext = new ArrayList<TextArea>();
	
	private TextField userInput = new TextField();
	
	public DiaryViewImpl() {
		Diary diaryModel = new Diary();
		new DiaryPresenter(diaryModel, this);
		
		Text titleText = new Text("Diary");
		 
		add(titleText);
		add(addCreateDiaryTextArea());
		add(createButton("Save"));
		
		userInput.setReadOnly(true);
		add(userInput);
	}
	
	private TextArea addCreateDiaryTextArea() {
	TextArea textArea = new TextArea();
	textArea.getStyle().set("minHeight", "350px");
	textArea.getStyle().set("minWidth", "450px");
	textArea.setPlaceholder("Please write down the events that you experienced today");
	diariestext.add(textArea);
	return textArea;
	
	/** saveButton.addClickListener(e -> {
		Text newEntry = new Text("");
		newEntry.setText(textArea.getValue());
		String textPattern = String.format("Tagebucheintrag vom %s: ", LocalDate.now().toString());
		Div diaryEntryDiv = new Div(new Text(textPattern), newEntry);
		add(diaryEntryDiv);
	}); */
}

	private Button createButton(String label) {		 
		return new Button(label, event -> {
			for (IDiaryViewListener listener : listeners) {
				listener.buttonClick(diariestext);					
			}
		});
	}	

	 
	@Override
	public void addDiaryListener(IDiaryViewListener listener) {
		listeners.add(listener);
		
	}

	@Override
	public void setUserInput(String display) {
		userInput.setValue(display);
		
	}

	@Override
	public void showNotification(String notification) {
		Notification.show(notification);
		
	}
}
