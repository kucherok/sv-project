package by.kucher.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("by.kucher.project.repositories")
public class RepositoryConfig {

}
