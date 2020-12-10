package view;

import java.time.LocalDate;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;

/**
 * Diaries view for patients to add new diary entries.
 */
@Route(value = "diaries", layout = HomeView.class)
public class DiariesView extends VerticalLayout {

	public DiariesView() {
		addCreateDiaryTextArea();
	}

	private void addCreateDiaryTextArea() {
		TextArea textArea = new TextArea("Tagebuch");
		textArea.getStyle().set("minHeight", "150px");
		textArea.setPlaceholder("Bitte schildere deinen heutigen Tagesablauf");

		Button saveButton = new Button("Speichern");

		add(textArea, saveButton);

		saveButton.addClickListener(e -> {
			Text newEntry = new Text("");
			newEntry.setText(textArea.getValue());
			String textPattern = String.format("Tagebucheintrag vom %s: ", LocalDate.now().toString());
			Div diaryEntryDiv = new Div(new Text(textPattern), newEntry);
			add(diaryEntryDiv);
		});
	}
}
