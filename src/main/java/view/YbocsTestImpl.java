package view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("patient/ybocstest")
public class YbocsTestImpl extends VerticalLayout implements IYbocsTestView {
	
	public YbocsTestImpl() {
		Text titleText = new Text("Yale Brown OCD Scale");
		add(titleText);
		
		RadioButtonGroup<Integer> radioButtonGroup1 = new RadioButtonGroup<>();
		radioButtonGroup1.setLabel("How much time do you spend on obsessive thoughts?");
		radioButtonGroup1.setItems(0, 1,2, 3,4 , 5);
		add(radioButtonGroup1);

		RadioButtonGroup<Integer> radioButtonGroup2 = new RadioButtonGroup<>();
		radioButtonGroup2.setLabel("How much do your obsessive thoughts interfere with your personal, social, or work life?");
		radioButtonGroup2.setItems(0, 1,2, 3,4 , 5);
		add(radioButtonGroup2);
		
		RadioButtonGroup<String> radioButtonGroup3 = new RadioButtonGroup<>();
		radioButtonGroup3.setLabel("How much do your obsessive thoughts distress you?");
		radioButtonGroup3.setItems("0", "1","2", "3", "4" , "5");
		add(radioButtonGroup3);
		
		RadioButtonGroup<String> radioButtonGroup4 = new RadioButtonGroup<>();
		radioButtonGroup4.setLabel("How hard do you try to resist your obsessions?");
		radioButtonGroup4.setItems("0", "1","2", "3", "4" , "5");
		add(radioButtonGroup4);
		
		RadioButtonGroup<String> radioButtonGroup5 = new RadioButtonGroup<>();
		radioButtonGroup5.setLabel("How much control do you have over your obsessive thoughts?");
		radioButtonGroup5.setItems("0", "1","2", "3", "4" , "5");
		add(radioButtonGroup5);
		
		RadioButtonGroup<String> radioButtonGroup6 = new RadioButtonGroup<>();
		radioButtonGroup6.setLabel("How much time do you spend performing compulsive behaviors?");
		radioButtonGroup6.setItems("0", "1","2", "3", "4" , "5");
		add(radioButtonGroup6);
		
		RadioButtonGroup<String> radioButtonGroup7 = new RadioButtonGroup<>();
		radioButtonGroup7.setLabel("How much do your compulsive behaviors interfere with your personal, social, or work  life?");
		radioButtonGroup7.setItems("0", "1","2", "3", "4" , "5");
		add(radioButtonGroup7);
		 
		RadioButtonGroup<String> radioButtonGroup8 = new RadioButtonGroup<>();
		radioButtonGroup8.setLabel("How anxious would you feel if you were prevented from performing your compulsive behaviors?");
		radioButtonGroup8.setItems("0", "1","2", "3", "4" , "5");
		add(radioButtonGroup8);
		
		RadioButtonGroup<String> radioButtonGroup9 = new RadioButtonGroup<>();
		radioButtonGroup9.setLabel("How hard do you try to resist your compulsive behaviors?");
		radioButtonGroup9.setItems("0", "1","2", "3", "4" , "5");
		 
		add(radioButtonGroup9);
		 
		RadioButtonGroup<String> radioButtonGroup10 = new RadioButtonGroup<>();
		radioButtonGroup10.setLabel("How much control do you have over your compulsive behaviors?");
		radioButtonGroup10.setItems("0", "1","2", "3", "4" , "5");
		  
		add(radioButtonGroup10);
		
		 
		Button button = new Button("Calculate Test");
		 
		button.addClickListener(e -> {
			 
			Notification.show("pressed " +  radioButtonGroup2.getValue() + radioButtonGroup1.getValue() );
		});
		add(button);
		
		Div value = new Div();
		value.setText("Today's score");
		radioButtonGroup1.addValueChangeListener(event -> {
		    if (event.getValue() == null) {
		        value.setText("No option selected");
		    } else {
		        value.setText("Selected: " + event.getValue());
		    }
		});
		
		add(value);
	}

}
 
