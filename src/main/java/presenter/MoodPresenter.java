package presenter;

import java.util.ArrayList;

import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

import model.MoodModel;
import view.IMoodTestView;

public class MoodPresenter implements IMoodTestView.IMoodTestViewListener{

	private MoodModel model;
	private IMoodTestView view;
	//private int currentScore = 0;
	
	public MoodPresenter(MoodModel model, IMoodTestView view) {
		this.model=model;
		this.view = view;
		view.addMoodListener(this);
		view.setDisplay("0");
		
	}


	public void buttonClick(ArrayList<RadioButtonGroup<Integer>> buttongroups) {
		model.setMoodScore(0);
		boolean choice_unset = false;
		for (RadioButtonGroup<Integer> buttonGroup : buttongroups) {
			if (buttonGroup.isEmpty()) {
				choice_unset = true;
			} else {		
				model.addition(buttonGroup.getValue());
			}
		}
		if (choice_unset == true) {
			view.showNotification("Please make sure to make a choice in every Question.");
		} else {
			view.setDisplay(model.getMoodScoreAsString());		
		}
	}
	

}
