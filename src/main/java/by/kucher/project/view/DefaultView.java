package by.kucher.project.view;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import by.kucher.project.service.MyService;

@SpringView(name = DefaultView.NAME)
public class DefaultView extends VerticalLayout implements View {

	private static final long serialVersionUID = 4376971064524980559L;

	public final static String NAME = "defaultView";

	@Autowired
	MyService myService;

	@PostConstruct
	protected void init() {
		addComponent(new Label(myService.getMessage()));
	}

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
	}

}
