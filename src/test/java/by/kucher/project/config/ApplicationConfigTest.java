package by.kucher.project.config;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import by.kucher.project.service.MyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class,
		PersistanceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class ApplicationConfigTest implements ApplicationContextAware {

	@Autowired
	MyService myService;

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Test
	public void firstTest() {

		assertTrue(myService.getMessage().equals("Message Return service layer"));
	}

	@Test
	public void asd() throws SQLException {

		DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
		assertTrue(dataSource.getConnection().isClosed());

		// assertTrue(applicationContext.getApplicationName().equals("project"));
	}

}
