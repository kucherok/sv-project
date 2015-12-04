package by.kucher.project.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
// @ComponentScan("by.kucher.project.config")
@EnableTransactionManagement
@EnableJpaRepositories("by.kucher.project.repositories")
public class PersistanceConfig {

	private static final String[] ENTITY_PACKAGES = { "by.kucher.project.model" };

	private static final String PROPERTY_NAME_DB_DRIVER_CLASS = "db.driver";
	private static final String PROPERTY_NAME_DB_URL = "db.url";
	private static final String PROPERTY_NAME_DB_USER = "db.username";
	private static final String PROPERTY_NAME_DB_PASSWORD = "db.password";

	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
	private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";

	@Bean
	public DataSource dataSource(Environment env) {

		HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DB_DRIVER_CLASS));
		dataSourceConfig.setJdbcUrl(env.getRequiredProperty(PROPERTY_NAME_DB_URL));
		dataSourceConfig.setUsername(env.getRequiredProperty(PROPERTY_NAME_DB_USER));
		dataSourceConfig.setPassword(env.getRequiredProperty(PROPERTY_NAME_DB_PASSWORD));
		return new HikariDataSource(dataSourceConfig);

	}

	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(DataSource dataSource,
			Environment env) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGES);

		Properties jpaProperties = new Properties();
		jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
		jpaProperties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO,
				env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));
		jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
		jpaProperties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL,
				env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));

		entityManagerFactoryBean.setJpaProperties(jpaProperties);

		return entityManagerFactoryBean;

	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(entityManagerFactory);
		return jpaTransactionManager;
	}

}
