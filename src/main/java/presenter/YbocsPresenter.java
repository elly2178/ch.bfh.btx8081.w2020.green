package presenter;

import java.awt.print.Printable;
import java.util.ArrayList;

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
	private int currentScore = 0;
	
	public YbocsPresenter(YbocsModel model, IYbocsTestView view) {
		this.model = model;
		this.view = view;
		view.setDisplay("0");
		view.addYbocsListener(this);
	}
 
	public void buttonClick(String operation) {
		
		if (currentScore >=8 && currentScore <=15) {
			System.out.println("Mild ocd");
		} else if (currentScore >=16 && currentScore <=23) {
			System.out.println("Moderate ocd");
		} else if (currentScore >= 24 && currentScore <=31) {
			System.out.println("Severe ocd");
		} else {
			System.out.println("Extreme ocd");
		}
		   
	 view.setDisplay(model.getYbocsScoreAsString());
	}
	
	public void buttonClick(ArrayList<RadioButtonGroup<Integer>> buttongroups) {
		//YbocsTestImpl ybocsTest = new YbocsTestImpl();
		//ArrayList<RadioButtonGroup<Integer>>ybocsButtonGroups = ybocsTest.getPressedRadioButton();
		System.out.println("BUTTON WAS PRESSED MEOW");
		for (RadioButtonGroup<Integer> buttonGroup : buttongroups) {
			model.setYbocsScore(0);
			if (! buttonGroup.getValue().equals(null)) {
				view.showNotification("Please make sure to make a choice in every Question.");
			} else {
				model.addition(buttonGroup.getValue());
			}
		}
		view.setDisplay(model.getYbocsScoreAsString());		
	}
}