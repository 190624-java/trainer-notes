package com.revature;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.beans.User;
import com.revature.repository.UserDAO;

@Configuration
@ComponentScan("com.revature")
@EnableTransactionManagement
public class ApplicationDriver {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationDriver.class);
		UserDAO uDao = (UserDAO) context.getBean(UserDAO.class);
		User u = new User(0, "Jessica Colson", "jessica.colson@revature.com");
		uDao.save(u);

	}

	private static final String url = "jdbc:oracle:thin:@jcol-sql-demo-db.chueiwozbnfz.us-east-1.rds.amazonaws.com:1521:ORCL";
	private static final String username = "jcol190624";
	private static final String password = "MyDBPass123$";
	
	@Bean
	public DriverManagerDataSource datasource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource(url, username, password);
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		return datasource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(DriverManagerDataSource datasource) {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(datasource);
		//tell our session factory where our beans are
		sf.setPackagesToScan("com.revature.beans"); //scans for @Entity
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		hibernateProperties.put("hibernate.show_sql", true);
		//... whatever other properties you want
		sf.setHibernateProperties(hibernateProperties);
		return sf;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txMgr = new HibernateTransactionManager();
		txMgr.setSessionFactory(sessionFactory);
		return txMgr;
	}
	
}
