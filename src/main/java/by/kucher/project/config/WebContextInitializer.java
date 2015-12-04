package by.kucher.project.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.vaadin.spring.server.SpringVaadinServlet;

public class WebContextInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) {
		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(ApplicationConfig.class);

		// Manage the lifecycle of the root application context
		container.addListener(new ContextLoaderListener(rootContext));
		registerServlet(container);
	}

	private void registerServlet(ServletContext servletContext) {
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("vaadin", SpringVaadinServlet.class);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/*");
	}
}
