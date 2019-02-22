package com.tech.config;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.service.relational.DataSourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectionPool extends AbstractCloudConfig {

	//private static final Logger logger = Logger.get(MethodHandles.lookup().lookupClass());

	@Bean
	public DataSource dataSource() {
		//logger.info("Using relational cloud data source config");
		List<String> pooledDataSourceNames = Arrays.asList("HikariCp");

		return connectionFactory().dataSource(new DataSourceConfig(pooledDataSourceNames));
	}

}
