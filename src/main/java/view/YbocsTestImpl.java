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
		Text descriptionText = new Text("Please answer the following questions.");
		add(titleText, descriptionText);
		
		RadioButtonGroup<Integer> radioButtonGroup1 = new RadioButtonGroup<>();
		radioButtonGroup1.setLabel("How much time do you spend on obsessive thoughts?");
		Text legend1 = new Text("0 = None, 1 = 0-1 hrs/day, 2 = 1-3 hrs/day, 3 = 3-8 hrs/day, 4 = More than 8 hrs/day");
		radioButtonGroup1.setItems(0, 1, 2, 3, 4);
		add(radioButtonGroup1, legend1);

		RadioButtonGroup<Integer> radioButtonGroup2 = new RadioButtonGroup<>();
		radioButtonGroup2.setLabel("How much do your obsessive thoughts interfere with your personal, social, or work life?");
		Text legend2 = new Text("0 = None, 1 = Mild, 2 = Definite but manageable, 3 = Substantial interference, 4 = Severe");
		radioButtonGroup2.setItems(0, 1, 2, 3, 4);
		add(radioButtonGroup2, legend2);
		
		RadioButtonGroup<Integer> radioButtonGroup3 = new RadioButtonGroup<>();
		radioButtonGroup3.setLabel("How much do your obsessive thoughts distress you?");
		Text legend3 = new Text("0 = None, 1 = Little, 2 = Moderate but manageable, 3 = Severe, 4 = Nearly constant, Disabling");
		radioButtonGroup3.setItems(0, 1, 2, 3, 4);
		add(radioButtonGroup3);
		
		RadioButtonGroup<Integer> radioButtonGroup4 = new RadioButtonGroup<>();
		radioButtonGroup4.setLabel("How hard do you try to resist your obsessions?");
		radioButtonGroup4.setItems(0, 1, 2, 3, 4);
		Text legend4 = new Text("0 = Always, 1 = Try much of the time, 2 = Try some of the time, 3 = Rarely try. Often yield, 4 = Never try. Completely yield"); 
		add(radioButtonGroup4, legend4);
		
		RadioButtonGroup<Integer> radioButtonGroup5 = new RadioButtonGroup<>();
		radioButtonGroup5.setLabel("How much control do you have over your obsessive thoughts?");
		radioButtonGroup5.setItems(0, 1, 2, 3, 4);
		Text legend5 = new Text("0 = Complete control, 1 = Much control, 2 = Some control, 3 = Little control, 4 = No control"); 
		add(radioButtonGroup5, legend5);
		
		RadioButtonGroup<Integer> radioButtonGroup6 = new RadioButtonGroup<>();
		radioButtonGroup6.setLabel("How much time do you spend performing compulsive behaviors?");
		Text legend6 = new Text("0 = None, 1 = 0-1 hrs/day, 2 = 1-3 hrs/day, 3 = 3-8 hrs/day, 4 = More than 8 hrs/day");
		radioButtonGroup6.setItems(0, 1, 2, 3, 4);
		add(radioButtonGroup6, legend6);
		
		RadioButtonGroup<Integer> radioButtonGroup7 = new RadioButtonGroup<>();
		radioButtonGroup7.setLabel("How much do your compulsive behaviors interfere with your personal, social, or work  life?");
		Text legend7 = new Text("0 = None, 1 = Mild, 2 = Definite but manageable, 3 = Substantial interference, 4 = Severe");
		radioButtonGroup7.setItems(0, 1, 2, 3, 4);
		add(radioButtonGroup7, legend7);
		 
		RadioButtonGroup<Integer> radioButtonGroup8 = new RadioButtonGroup<>();
		radioButtonGroup8.setLabel("How anxious would you feel if you were prevented from performing your compulsive behaviors?");
		Text legend8 = new Text("0 = None, 1 = Little, 2 = Moderate but manageable, 3 = Severe, 4 = Nearly constant, Disabling");
		radioButtonGroup8.setItems(0, 1, 2, 3, 4);
		add(radioButtonGroup8, legend8);
		
		RadioButtonGroup<Integer> radioButtonGroup9 = new RadioButtonGroup<>();
		radioButtonGroup9.setLabel("How hard do you try to resist your compulsive behaviors?");
		radioButtonGroup9.setItems(0, 1, 2, 3, 4);
		Text legend9 = new Text("0 = Always, 1 = Try much of the time, 2 = Try some of the time, 3 = Rarely try. Often yield, 4 = Never try. Completely yield"); 
		add(radioButtonGroup9, legend9);
		 
		RadioButtonGroup<Integer> radioButtonGroup10 = new RadioButtonGroup<>();
		radioButtonGroup10.setLabel("How much control do you have over your compulsive behaviors?");
		radioButtonGroup10.setItems(0, 1, 2, 3, 4);
		Text legend10 = new Text("0 = Complete control, 1 = Much control, 2 = Some control, 3 = Little control, 4 = No control"); 
		add(radioButtonGroup10, legend10);
		 
		Button button = new Button("Calculate Test");
		button.addClickListener(e -> { 
			 int add = radioButtonGroup1.getValue()+ radioButtonGroup2.getValue() + radioButtonGroup3.getValue() + radioButtonGroup4.getValue() + radioButtonGroup5.getValue()
					  + radioButtonGroup6.getValue() + radioButtonGroup7.getValue() +radioButtonGroup8.getValue() + radioButtonGroup9.getValue() 
					  + radioButtonGroup10.getValue();
			Notification.show("pressed " + add);
		});
		add(button);		
		 
	}

}
 
