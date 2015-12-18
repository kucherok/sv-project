package by.kucher.project.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import by.kucher.project.config.common.DatabaseNameProperty;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:/database/hibernate.properties")
public class JpaConfig {

	private static final String[] ENTITY_PACKAGES = { "by.kucher.project.model" };

	@Autowired
	private Environment environment;

	@Autowired
	private DataSource dataSource;

	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {

		Properties hibernateJpaProperties = new Properties();
		hibernateJpaProperties.put(DatabaseNameProperty.HIBERNATE_DIALECT,
				environment.getRequiredProperty(DatabaseNameProperty.HIBERNATE_DIALECT));
		hibernateJpaProperties.put(DatabaseNameProperty.HIBERNATE_HBM2DDL_AUTO,
				environment.getRequiredProperty(DatabaseNameProperty.HIBERNATE_HBM2DDL_AUTO));
		hibernateJpaProperties.put(DatabaseNameProperty.HIBERNATE_SHOW_SQL,
				environment.getRequiredProperty(DatabaseNameProperty.HIBERNATE_SHOW_SQL));
		hibernateJpaProperties.put(DatabaseNameProperty.HIBERNATE_FORMAT_SQL,
				environment.getRequiredProperty(DatabaseNameProperty.HIBERNATE_FORMAT_SQL));

		HibernateJpaVendorAdapter hibernateJpa = new HibernateJpaVendorAdapter();

		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		emf.setJpaVendorAdapter(hibernateJpa);
		emf.setPackagesToScan(ENTITY_PACKAGES);
		emf.setJpaProperties(hibernateJpaProperties);

		return emf;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(localContainerEntityManagerFactoryBean().getObject());
		return jpaTransactionManager;
	}

}
