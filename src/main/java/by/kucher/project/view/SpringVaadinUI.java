package by.kucher.project.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.UI;

@Theme("valo")
@SpringUI
public class SpringVaadinUI extends UI {

	private static final long serialVersionUID = -2251984167401248947L;

	@Autowired
	private SpringViewProvider viewProvider;

	@Override
	protected void init(VaadinRequest request) {

		Navigator navigator = new Navigator(this, this);
		navigator.addProvider(viewProvider);
		navigator.navigateTo(DefaultView.NAME);

	}

}
