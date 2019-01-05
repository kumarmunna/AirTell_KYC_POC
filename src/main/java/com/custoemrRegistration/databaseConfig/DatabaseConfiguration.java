package com.custoemrRegistration.databaseConfig;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfiguration {

	/*@Autowired
	private org.springframework.core.env.Environment env;*/
	
	@Value("${spring_datasource_driverclassname:org.hsqldb.jdbcDriver}")
	public static String DRIVER = "org.hsqldb.jdbcDriver";
	@Value("${spring_datasource_url:jdbc:hsqldb:file:C:/HSQLDB/DB}")
    public static String JDBC_URL = "jdbc:hsqldb:file:C:/HSQLDB/DB";
	@Value("${spring_datasource_username:SA}")
    public static String USERNAME = "SA";
	@Value("${spring_datasource_password:}")
    public static String PASSWORD = "";
   
	@Resource
	private Environment env;
	
	@Bean
    @Primary
    @RefreshScope
    public DataSource dataSource() {
    	//System.out.println(" Database url: "+ databaseURL);

		System.out.println(" Driver: "+ env.getProperty("spring_datasource_driverclassname"));
		System.out.println(" URL: "+ env.getProperty("spring_datasource_url"));
		System.out.println(" Username: "+ env.getProperty("spring_datasource_username"));
		System.out.println(" Password: "+ env.getProperty("spring_datasource_password"));
		
		/*HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setDriverClassName(env.getRequiredProperty("spring_datasource_driverclassname"));
        dataSourceConfig.setJdbcUrl(env.getRequiredProperty("spring_datasource_url"));
        dataSourceConfig.setUsername(env.getRequiredProperty("spring_datasource_username"));
        dataSourceConfig.setPassword(env.getRequiredProperty("spring_datasource_password"));
        return new HikariDataSource(dataSourceConfig);*/
		if(env.getProperty("spring_datasource_username") != null) {
			USERNAME = env.getProperty("spring_datasource_username").trim().toString();
		}
		if(env.getProperty("spring_datasource_password") != null) {
			PASSWORD = env.getProperty("spring_datasource_password").trim().toString();
		}
		if(env.getProperty("spring_datasource_url") != null) {
			JDBC_URL = env.getProperty("spring_datasource_url").trim().toString();
		}
		if(env.getProperty("spring_datasource_driverclassname") != null) {
			DRIVER = env.getProperty("spring_datasource_driverclassname").trim().toString();
		}
		
		System.out.println(" DriverAfter: "+ DRIVER);
		System.out.println(" URL: "+ JDBC_URL);
		System.out.println(" Username: "+ USERNAME);
		System.out.println(" Password: "+ PASSWORD);
		
		return DataSourceBuilder
		        .create()
		        .username(USERNAME)
		        .password(PASSWORD)
		        .url(JDBC_URL)
		        .driverClassName(DRIVER)
		        .build();
    }
}
