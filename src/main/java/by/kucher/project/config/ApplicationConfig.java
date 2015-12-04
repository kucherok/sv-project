package by.kucher.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import by.kucher.project.service.MyService;
import by.kucher.project.service.MyServiceImpl;

@Configuration
@ComponentScan(basePackages = "by.kucher.project.config")
@Import({ ApplicationUIConfig.class })
public class ApplicationConfig {

	@Bean
	public MyService myService() {
		return new MyServiceImpl();
	}

}
