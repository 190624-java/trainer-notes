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

import com.revature.beans.Player;
import com.revature.repository.PlayerDAO;
import com.revature.repository.PlayerDAOImpl;
import com.revature.service.PlayerService;

@Configuration
@EnableTransactionManagement //allows us to use @Transactional
@ComponentScan({"com.revature", "com.revature.beans", "com.revature.repository", "com.revature.service"}) //may have to change this 
public class ORMConfig {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(ORMConfig.class);
		PlayerDAOImpl dao = (PlayerDAOImpl) context.getBean(PlayerDAOImpl.class);
		Player test = new Player(3, "Hawkmoon", 70);
		PlayerService ps = (PlayerService) context.getBean(PlayerService.class);
		ps.save(test);
		System.out.println(dao.findAll());
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
