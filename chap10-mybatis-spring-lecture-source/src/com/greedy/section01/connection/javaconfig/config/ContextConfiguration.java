package com.greedy.section01.connection.javaconfig.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.greedy.section01.connection.javaconfig")
@PropertySource("connection-info.properties")
public class ContextConfiguration {

	@Value("${oracle.dev.drivder}")
	private String driver;

	@Value("${oracle.dev.url}")
	private String url;

	@Value("${oracle.dev.username}")
	private String username;

	@Value("${oracle.dev.password}")
	private String password;

	/*
	 * BasicDataSource를 사용하려면 commons-dbcp 라이브러리 추가 common
	 */

	@Bean(destroyMethod = "close")
	public BasicDataSource dataSource() {

		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDefaultAutoCommit(false); // 수동 커밋

//	     dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//	     dataSource.setUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:xe");
//	     dataSource.setUsername("GREEDY");
//	     dataSource.setPassword("GREEDY");
//	     dataSource.setDefaultAutoCommit(false);   // 수동 커밋

		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(ApplicationContext context) throws Exception {

		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		
		factoryBean.setDataSource(dataSource());
		
//		mybatis 설정값 추가
		
		return factoryBean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(ApplicationContext context) throws Exception {
		
		// 추가 라이브러리가 존재
		// spring-jdbc 라이브러리 추가
		return new SqlSessionTemplate(sqlSessionFactory(context));
	}
}
