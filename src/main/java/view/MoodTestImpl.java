package view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import model.MoodModel;
import presenter.MoodPresenter;
import view.common.MainLayout;
/**
 * Mood view implementation. Here are the Vaadin components defined
 */
@Route(value = "moodtest", layout = MainLayout.class)
public class MoodTestImpl extends VerticalLayout implements IMoodTestView{
	/**
	 * @listeners: Arraylist with all listeners for the Moodtests 
	 * @moodButtonGroups: saves the input for a specific radio button
	 * @display: shows the calculated Mood of the User
	 */
	private List<IMoodTestViewListener> listeners = new ArrayList<IMoodTestViewListener>();
	private List<RadioButtonGroup<Integer>> moodButtonGroups =  new ArrayList<RadioButtonGroup<Integer>>();
	
	private TextField displayField = new TextField();
	
	public MoodTestImpl(){	
		MoodModel moodModel = new MoodModel();
		new MoodPresenter(moodModel, this);
		
		Text titleText = new Text("Mood Test ");
		Text legendText = new Text("0 = very false, 1 = false, 2 = neutral, 3 = true, 4 = very true");
		add(titleText);
		 
		// calling add method from Vaadin to call the another Method for creating a Radio Button Group with a specific label
		add(createRadioButtonGroup("I feel miserable or unhappy."));
		add(legendText);
		add(createRadioButtonGroup("I don't enjoy anything at all."));
		add(createRadioButtonGroup("I felt so tired I just sat around and did nothing."));
		add(createRadioButtonGroup("I was very restless."));
		add(createRadioButtonGroup("I felt I was no good any more."));
		add(createRadioButtonGroup("I cried a lot."));
		add(createRadioButtonGroup("I found it hard to think properly or concentrate."));
		add(createRadioButtonGroup("I hated myself."));
		add(createRadioButtonGroup("I was a bad person."));
		add(createRadioButtonGroup("I felt lonely."));
		add(createRadioButtonGroup("I thought nobody really loved me."));
		add(createRadioButtonGroup("I thought I could never be as good as other kids."));
		add(createRadioButtonGroup("I did everything wrong."));
		add(createButton("Calculate Mood"));
		// display Field can't be edited by the user 
		displayField.setReadOnly(true);
		add(displayField);
	}
	/**
	 * Method created so that every time its called it will create a radiobutton group with a specific label
	 * @setItems: creates the scale for the mood scale  
	 * 
	 */
		
	  private RadioButtonGroup<Integer> createRadioButtonGroup(String label){
		RadioButtonGroup<Integer> someRadioButtonGroup = 
								new RadioButtonGroup<Integer>();
		moodButtonGroups.add(someRadioButtonGroup);
		someRadioButtonGroup.setLabel(label);
		someRadioButtonGroup.setItems(0,1,2,3,4);
		return someRadioButtonGroup;
	}
	  /**
	   * Method that creates a button
	   *  
	   */
	private Button createButton(String label) {
		return new Button(label, event -> {
			for (IMoodTestViewListener listener : listeners) {
				listener.buttonClick(moodButtonGroups);	
			}
		});
	}
	 
	public void setDisplay(String display) {
		displayField.setValue(display);
		
	}
	
	public void showNotification(String notification) {
		Notification.show(notification);
		
	}

	@Override
	public void addMoodListener(IMoodTestViewListener listener) {
		listeners.add(listener);
		
	}
}

