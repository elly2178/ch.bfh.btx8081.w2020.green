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
	private static final long serialVersionUID = -1763030112751433022L;
	private List<IDiaryViewListener> listeners = new ArrayList<IDiaryViewListener>();
	
	private TextField userInput = new TextField();
	private TextArea textArea; 
	
	public DiaryViewImpl() {
		Diary diaryModel = new Diary();
		new DiaryPresenter(diaryModel, this);
		
		Text titleText = new Text("Diary");
		TextArea textArea = new TextArea();
	textArea.getStyle().set("minHeight", "350px");
	textArea.getStyle().set("minWidth", "450px");
	textArea.setPlaceholder("Please write down the events that you experienced today"); 
		
	add(titleText, textArea);
		 
		add(createButton("Save"));
		
		userInput.setReadOnly(true);
		add(userInput);
	}
	
	private Button createButton(String label) {			
		return new Button(label, event -> {			
			for (IDiaryViewListener listener : listeners) {
				listener.buttonClick(textArea.getValue());					
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
