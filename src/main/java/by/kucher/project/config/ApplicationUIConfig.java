package by.kucher.project.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.vaadin.spring.annotation.EnableVaadin;

@Configuration
@ComponentScan(basePackages = "by.kucher.project.view")
@PropertySource("classpath:db.properties")
@EnableVaadin
public class ApplicationUIConfig {

}
