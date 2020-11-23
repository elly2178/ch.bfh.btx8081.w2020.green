package core;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class TestClass extends VerticalLayout {

    public TestClass() {
        Button button = new Button("Click me",
                event -> Notification.show("Clicked!"));
        add(button);
    }

}
