package by.kucher.project.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.vaadin.spring.annotation.EnableVaadin;

@Configuration
@ComponentScan(basePackages = "by.kucher.project.view")
@EnableVaadin
public class ApplicationUIConfig {

}
