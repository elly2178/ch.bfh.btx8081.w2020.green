package presenter;

import java.time.LocalDate;
import java.util.ArrayList;

import model.DiaryModel;
import view.IDiaryView;

public class DiaryPresenter implements IDiaryView.IDiaryViewListener{
	private DiaryModel model;
	private IDiaryView view;	

	public DiaryPresenter(DiaryModel model, IDiaryView view) {
		this.model = model;
		this.view = view;
		view.setUserInput("");
		view.addDiaryListener(this);
	}
 
	@Override
	public void buttonClick(String diariestext) {
		
		//model.setDailyEntry(diariestext);	
		model.setDailyEntry(diariestext);
		//String textPattern = String.format("Diary input from %s", LocalDate.now().toString());
	   // view.showNotification(textPattern); 
	    
		view.setUserInput(model.getDailyEntry());
	}
}
/**private void addCreateDiaryTextArea() {
		TextArea textArea = new TextArea("Tagebuch");
		
		saveButton.addClickListener(e -> {
			Text newEntry = new Text("");
			newEntry.setText(textArea.getValue());
			String textPattern = String.format("Tagebucheintrag vom %s: ", LocalDate.now().toString());
			Div diaryEntryDiv = new Div(new Text(textPattern), newEntry);
			add(diaryEntryDiv);
		});
	}
*/