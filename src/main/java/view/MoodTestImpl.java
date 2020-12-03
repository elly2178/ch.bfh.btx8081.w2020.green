package view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.router.Route;

@Route("patient/moodtest")
public class MoodTestImpl extends VerticalLayout implements IYbocsTestView{
	
	public MoodTestImpl(){
		
		Text titleText = new Text("Mood Test ");
		Text legendText = new Text("Where 0 = very false, 1 = false, 2 = neutral, 3 = true, 4 = very true");
		add(titleText, legendText);
			
		RadioButtonGroup<Integer>moodButtonGroup1 = new RadioButtonGroup<>();
		moodButtonGroup1.setLabel("I feel miserable or unhappy.");
		moodButtonGroup1.setItems(0, 1, 2, 3, 4);
		
		RadioButtonGroup<Integer>moodButtonGroup2 = new RadioButtonGroup<>();
		moodButtonGroup2.setLabel("I don't enjoy anything at all.");
		moodButtonGroup2.setItems(0, 1, 2, 3, 4);
		
		RadioButtonGroup<Integer>moodButtonGroup3 = new RadioButtonGroup<>();
		moodButtonGroup3.setLabel(" I felt so tired I just sat around and did nothing.");
		moodButtonGroup3.setItems(0, 1, 2, 3, 4); 
		
		RadioButtonGroup<Integer>moodButtonGroup4 = new RadioButtonGroup<>();
		moodButtonGroup4.setLabel("I was very restless.");
		moodButtonGroup4.setItems(0, 1, 2, 3, 4);
		
		RadioButtonGroup<Integer>moodButtonGroup5 = new RadioButtonGroup<>();
		moodButtonGroup5.setLabel("I felt I was no good any more.");
		moodButtonGroup5.setItems(0, 1, 2, 3, 4);
		
		RadioButtonGroup<Integer>moodButtonGroup6 = new RadioButtonGroup<>();
		moodButtonGroup6.setLabel("I cried a lot.");
		moodButtonGroup6.setItems(0, 1, 2, 3, 4);
		
		RadioButtonGroup<Integer>moodButtonGroup7 = new RadioButtonGroup<>();
		moodButtonGroup7.setLabel("I found it hard to think properly or concentrate .");
		moodButtonGroup7.setItems(0, 1, 2, 3, 4);
		
		RadioButtonGroup<Integer>moodButtonGroup8 = new RadioButtonGroup<>();
		moodButtonGroup8.setLabel("I hated myself.");
		moodButtonGroup8.setItems(0, 1, 2, 3, 4);
		
		RadioButtonGroup<Integer>moodButtonGroup9 = new RadioButtonGroup<>();
		moodButtonGroup9.setLabel("I was a bad person.");
		moodButtonGroup9.setItems(0, 1, 2, 3, 4);
		
		RadioButtonGroup<Integer>moodButtonGroup10 = new RadioButtonGroup<>();
		moodButtonGroup10.setLabel("I felt lonely.");
		moodButtonGroup10.setItems(0, 1, 2, 3, 4);
		
		RadioButtonGroup<Integer>moodButtonGroup11 = new RadioButtonGroup<>();
		moodButtonGroup11.setLabel("I thought nobody really loved me.");
		moodButtonGroup11.setItems(0, 1, 2, 3, 4);
		
		RadioButtonGroup<Integer>moodButtonGroup12 = new RadioButtonGroup<>();
		moodButtonGroup12.setLabel("I thought I could never be as good as other kids.");
		moodButtonGroup12.setItems(0, 1, 2, 3, 4);
		
		RadioButtonGroup<Integer>moodButtonGroup13 = new RadioButtonGroup<>();
		moodButtonGroup13.setLabel(" I did everything wrong .");
		moodButtonGroup13.setItems(0, 1, 2, 3, 4);
		add(moodButtonGroup1, moodButtonGroup1, moodButtonGroup2, moodButtonGroup3,  
				moodButtonGroup4, moodButtonGroup6, moodButtonGroup6, 
				moodButtonGroup7, moodButtonGroup9, moodButtonGroup9, 
				moodButtonGroup10, moodButtonGroup11, moodButtonGroup12, moodButtonGroup13);
		
	}

}
