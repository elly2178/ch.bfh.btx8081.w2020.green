package presenter;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

/**
 * presenter
 */
import model.YbocsModel;
import view.IYbocsTestView;
import view.YbocsTestImpl;
 
public class YbocsPresenter implements IYbocsTestView.IYbocsTestViewListener {
	private YbocsModel model;
	private IYbocsTestView view;
	private int score;
 
	public YbocsPresenter(YbocsModel model, IYbocsTestView view) {
		this.model = model;
		this.view = view;
		view.setDisplay("0");
		view.addYbocsListener(this);
	}
 
	
	public void buttonClick(List<RadioButtonGroup<Integer>> buttongroups) {
		model.setYbocsScore(0);
		boolean choice_unset = false;
		for (RadioButtonGroup<Integer> buttonGroup : buttongroups) {
			//checks if all the choices are selected 
			if (buttonGroup.isEmpty()) {
				choice_unset = true;
			} else {
				// add the values of the selected questions
				score = model.addition(buttonGroup.getValue());		
			}
		}
		
		if (score >= 0 && score <=  15) {
			view.showNotification("You seem to have Mild OCD.");
		}else if (score >= 16 && score <=  23){
			view.showNotification("You seem to have Moderate OCD.");
		} else if (score >= 24 && score <=  31) {
			view.showNotification("You seem to have Severe OCD.");
		}else {
			view.showNotification("You seem to have Extreme OCD.");
		}
		// this will fire if one question is not answered 
		if (choice_unset == true) {
			view.showNotification("Please make sure to make a choice in every Question.");
		} else {
			view.setDisplay(model.getYbocsScoreAsString());		
		}
	}
}