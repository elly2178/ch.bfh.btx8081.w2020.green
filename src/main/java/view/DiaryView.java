package view;

import java.time.LocalDate;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

/**
 * Diary view for patients to add new diary entries.
 */
@Route("diary")
public class DiaryView extends VerticalLayout {

	public DiaryView() {
		TextArea textArea = new TextArea("Tagebuch");
		textArea.setPlaceholder("Bitte schildere deinen heutigen Tagesablauf");

		Text selected = new Text("");

		Button saveButton = new Button("Speichern");

		add(textArea, saveButton);

		saveButton.addClickListener(e -> {
			selected.setText(textArea.getValue());
			String textPattern = String.format("Tagebucheintrag vom %s: ", LocalDate.now().toString());
			Div diaryEntry = new Div(new Text(textPattern), selected);
			add(diaryEntry);
		});
	}

}
