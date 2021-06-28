package com.springsource.transactionstudy;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


import javax.naming.NamingException;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@PropertySource(value="wzyjdbc.properties")
@EnableTransactionManagement
public class WzyTransactionAopAnnotation {

	@Value("${jdbc.driverClassName}")
	private String driverClassname;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;

	@Bean
	public DataSource dataSource() throws PropertyVetoException, NamingException {
		DruidDataSource data = new DruidDataSource();
		data.setDriverClassName(driverClassname);
		data.setUrl(url);
		data.setUsername(username);
		data.setPassword(password);
		return data;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Transactional
	public void beforeMonitor(){
		doException("beforeMonitorException");
		System.out.println("我是WzyAspec的before方法");

	}

	@Transactional
	public void afterMonitor(){
		System.out.println("我是WzyAspec的after方法");
		//doException("afterMonitorException");
		System.out.println("我是WzyAspec的after异常后的方法");
	}
	@Transactional
	public void aroundMonitor( ) throws Throwable {
		System.out.println("我是WzyAspec的aroundMonitor之前的方法");
		//doException("aroundMonitorException");
		System.out.println("我是WzyAspec的aroundMonitor之后的方法");
	}

	@Transactional
	public void afterReturnMonitor(){
		System.out.println("我是WzyAspec的afterReturnMonitor方法");
	}

	@Transactional
	public void afterThrowMonitor(){
		System.out.println("我是WzyAspec的afterThrowMonitor方法");
	}

	public void doException(String name){
		throw new ArithmeticException(name);
	}
}
