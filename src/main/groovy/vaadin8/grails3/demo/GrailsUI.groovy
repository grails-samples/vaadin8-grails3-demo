package vaadin8.grails3.demo

import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.Alignment
import com.vaadin.ui.Button
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.Notification
import com.vaadin.ui.UI

/**
 * Created by mac on Tuesday, 2017-07-18 at 16:20
 */
@SpringUI(path = "/vaadinUI")
class GrailsUI extends UI{
    @Override
    protected void init(VaadinRequest request) {
        HorizontalLayout rootLayout = new HorizontalLayout()
        rootLayout.setSizeFull()
        content = rootLayout

        Button button = new Button()

        button.caption = "Click here!"
        button.addClickListener {
            Notification.show("Hello from Vaadin!")
        }

        rootLayout.addComponent(button)
        rootLayout.setComponentAlignment(button, Alignment
                .MIDDLE_CENTER)

    }
}
