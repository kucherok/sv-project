package by.kucher.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import by.kucher.project.service.MyService;
import by.kucher.project.service.MyServiceImpl;

@Configuration
@ComponentScan({ "by.kucher.project.config" })
// @Import({ DataSourceConfig.class, JpaConfig.class, RepositoryConfig.class,
// ApplicationUIConfig.class })
public class ApplicationConfig {

	@Bean
	public MyService myService() {
		return new MyServiceImpl();
	}

}
