package presenter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.data.renderer.LocalDateRenderer;
import com.vaadin.flow.internal.AnnotationReader;

import model.common.Diary;
import persistence.DiaryRepository;
import view.IDiaryView;

public class DiaryPresenter implements IDiaryView.IDiaryViewListener {
	private Diary model;
	private IDiaryView view;
	private DiaryRepository persistanceDiary;

	public DiaryPresenter(Diary model, IDiaryView view) {
		this.model = model;
		this.view = view;
		view.setUserInput("");
		view.addDiaryListener(this);
	}

	public void buttonClick(String diariestext) {
		model.setDailyEntry(diariestext);
		view.showNotification("New entry added.");
	 
		view.setUserInput(model.getDailyEntry());
		String idString = null;
		LocalDate creationDate = null;
		 
		Diary diary = new Diary(LocalDate.now().toString(), creationDate, idString , diariestext);
		persistanceDiary.addDiary(diary);
		 
	}
}
