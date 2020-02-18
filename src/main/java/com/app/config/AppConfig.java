package com.app.config;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@ComponentScan("com.app")
@PropertySource("classpath:app.properties")
@EnableWebMvc
@EnableTransactionManagement
public class AppConfig  implements WebMvcConfigurer{

	@Autowired
	private Environment env;

	//1. DataSource
	@Bean
	public BasicDataSource dsObj() {
		BasicDataSource b=new BasicDataSource();
		b.setDriverClassName(env.getProperty("db.driver"));
		b.setUrl(env.getProperty("db.url"));
		b.setUsername(env.getProperty("db.un"));
		b.setPassword(env.getProperty("db.pwd"));			
		return b;
	}

	//2. SessinFacotry
	@Bean
	public LocalSessionFactoryBean sf() {
		LocalSessionFactoryBean l=new LocalSessionFactoryBean();
		l.setDataSource(dsObj());
		l.setHibernateProperties(propObj());
		//l.setAnnotatedClasses(Uom.class,ShipmentType.class,Document.class);
		l.setPackagesToScan("com.app.model");
		return l;
	}

	//SAC
	@Bean
	public Properties propObj() {
		Properties p=new Properties();
		p.put("hibernate.dialect", env.getProperty("orm.dialect"));
		p.put("hibernate.show_sql", env.getProperty("orm.showsql"));
		p.put("hibernate.format_sql", env.getProperty("orm.fmtsql"));
		p.put("hibernate.hbm2ddl.auto", env.getProperty("orm.ddlauto"));
		return p;
	}

	//3. HibernateTemplate
	@Bean
	public HibernateTemplate ht() {
		HibernateTemplate h=new HibernateTemplate();
		h.setSessionFactory(sf().getObject());
		return h;
	}

	//4. HibernateTnxManager
	@Bean
	public HibernateTransactionManager htx() {
		HibernateTransactionManager htm=new HibernateTransactionManager();
		htm.setSessionFactory(sf().getObject());
		return htm;
	}

	//5. ViewResolver
	@Bean
	public InternalResourceViewResolver ivr() {
		InternalResourceViewResolver v=new InternalResourceViewResolver();
		v.setPrefix(env.getProperty("mvc.prefix"));
		v.setSuffix(env.getProperty("mvc.suffix"));
		return v;
	}

	/* 6. Email API */
	@Bean
	public JavaMailSenderImpl mailSender() {
		JavaMailSenderImpl m=new JavaMailSenderImpl();
		m.setHost(env.getProperty("email.host"));
		m.setPort(env.getProperty("email.port",Integer.class));
		m.setPassword(env.getProperty("email.pwd"));
		m.setUsername(env.getProperty("email.un"));
		m.setJavaMailProperties(emailprops());
		return m;
	}

	/* 7.email Props */
	@Bean
	public Properties emailprops(){
		Properties p= new Properties();
		p.put("mail.smtp.starttls.enable", env.getProperty("email.secure"));
		p.put("mail.smtp.auth", env.getProperty("email.auth"));
		return p;
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
}
