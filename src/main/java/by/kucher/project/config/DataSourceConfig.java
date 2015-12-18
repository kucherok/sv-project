package by.kucher.project.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import by.kucher.project.config.common.DatabaseNameProperty;

@Configuration
@PropertySource("classpath:/database/db.properties")
public class DataSourceConfig {

	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSource() {

		HikariConfig dataSource = new HikariConfig();
		dataSource.setDriverClassName(environment.getRequiredProperty(DatabaseNameProperty.JDBC_DRIVER_CLASS));
		dataSource.setJdbcUrl(environment.getRequiredProperty(DatabaseNameProperty.JDBC_URL));
		dataSource.setUsername(environment.getRequiredProperty(DatabaseNameProperty.JDBC_USERNAME));
		dataSource.setPassword(environment.getRequiredProperty(DatabaseNameProperty.JDBC_PASSWORD));
		return new HikariDataSource(dataSource);

	}

}
