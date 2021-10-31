package com.honsoft.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories(basePackages = {"com.honsoft.repository"},entityManagerFactoryRef = "h2EntityManagerFactory",transactionManagerRef = "h2JpaTransactionManager")
public class H2DataSourceConfig {
	@Bean
	@ConfigurationProperties(prefix = "h2.datasource")
	public DataSourceProperties h2DataSourceProperties() {
		DataSourceProperties properties = new DataSourceProperties();
		return properties;
	}
	
	@Bean
	public DataSource h2DataSource() {
		return h2DataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}
	
	@Bean(name = "h2JpaTransactionManager")
	public PlatformTransactionManager h2JpaTransactionManager() {
		return new JpaTransactionManager(h2EntityManagerFactoryBean().getObject());
	}
	
	@Bean(name = "h2EntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean h2EntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(h2DataSource());
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factory.setJpaDialect(new HibernateJpaDialect());
		factory.setPersistenceUnitName("h2Unit");
		factory.setPackagesToScan(new String[] {"com.honsoft.entity"});
		
		return factory;
	}
}
