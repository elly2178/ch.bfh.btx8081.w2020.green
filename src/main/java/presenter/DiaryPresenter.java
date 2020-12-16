package presenter;

import java.time.LocalDate;
import java.util.ArrayList;

import com.vaadin.flow.component.textfield.TextArea;

import model.common.Diary;
import view.IDiaryView;

public class DiaryPresenter implements IDiaryView.IDiaryViewListener {
	private Diary model;
	private IDiaryView view;

	public DiaryPresenter(Diary model, IDiaryView view) {
		this.model = model;
		this.view = view;
		view.setUserInput("");
		view.addDiaryListener(this);
	}

	@Override
	public void buttonClick(ArrayList<TextArea> diariestext) {
		 
		//model.setDailyEntry(diariestext);
		// String textPattern = String.format("Diary input from %s",
		// LocalDate.now().toString());
		// view.showNotification(textPattern);

		view.setUserInput(model.getDailyEntry());

	}
}
