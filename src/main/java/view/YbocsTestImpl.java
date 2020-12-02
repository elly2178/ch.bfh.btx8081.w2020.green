package view;

import java.util.List;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

@Route("patient/ybocstest")
public class YbocsTestImpl extends VerticalLayout implements IYbocsTest {
	 
	public YbocsTestImpl() {
		TextArea textArea = new TextArea("Some random text");
		add(textArea);
	}

}
