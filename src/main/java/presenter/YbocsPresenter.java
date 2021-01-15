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
				model.addition(buttonGroup.getValue());		
			}
		}
		// this will fire if one question is not answered 
		if (choice_unset == true) {
			view.showNotification("Please make sure to make a choice in every Question.");
		} else {
			view.setDisplay(model.getYbocsScoreAsString());		
		}
	}
}