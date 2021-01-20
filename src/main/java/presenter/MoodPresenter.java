package presenter;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

import model.MoodModel; 
import view.IMoodTestView;

public class MoodPresenter implements IMoodTestView.IMoodTestViewListener{

	private MoodModel model;
	private IMoodTestView view;
	private int score;
	
	public MoodPresenter(MoodModel model, IMoodTestView view) {
		this.model=model;
		this.view = view;
		view.addMoodListener(this);
		view.setDisplay("0");		
	}


	public void buttonClick(List<RadioButtonGroup<Integer>> buttongroups) {
		model.setMoodScore(0);
		boolean choice_unset = false;
		for (RadioButtonGroup<Integer> buttonGroup : buttongroups) {
			if (buttonGroup.isEmpty()) {
				choice_unset = true;
			} else {		
				score = model.addition(buttonGroup.getValue());
			}
			
		}
		if (score >= 0 && score <=  17) {
				view.showNotification("Your in a good mood today!");
			}else if (score >= 18 && score <=  35){
				view.showNotification("You should take it easy today. Try to relax.");
			}else {
				view.showNotification("Please take care of yourself. There are so many good things coming your way.");
			}
			
		if (choice_unset == true) {
			view.showNotification("Please make sure to make a choice in every Question.");
		} else {
			view.setDisplay(model.getMoodScoreAsString());		
		}
	}
	

}
