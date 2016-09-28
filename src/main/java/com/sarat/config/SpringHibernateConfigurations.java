package com.sarat.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.sarat.config" })
@PropertySource(value = { "classpath:application.properties" })
public class SpringHibernateConfigurations {
	
	
	
	@Autowired
    private Environment environment;
	
	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}
	
	
	private Properties getHibernateProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
	    properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
	    properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
	    properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		return properties;
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public LocalSessionFactoryBean getSessionFactory(){
		LocalSessionFactoryBean sessionFactoryBuilder = new LocalSessionFactoryBean();
		sessionFactoryBuilder.setDataSource(getDataSource());
		sessionFactoryBuilder.setPackagesToScan("com.sarat.entity");
		sessionFactoryBuilder.setHibernateProperties(getHibernateProperties());
		//sessionFactoryBuilder.afterPropertiesSet();
		return sessionFactoryBuilder;
	}
	

	@Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;
    }


}
