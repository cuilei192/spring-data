package com.datasource.config;


import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.datasource.config.datasource.DynamicDataSource;

@SuppressWarnings("all")
@Configuration
/**
 * druid配置类
 * 
 * @author chenx
 *
 */
public class DruidConfig {
	private static final Logger log = LoggerFactory.getLogger(DruidConfig.class);
	private final String SDS = "spring.datasource.";
	@Autowired
	private Environment env;
	@Value("${spring.datasource.druid.initial-size}")
	private int initialSize;

	@Value("${spring.datasource.druid.min-idle}")
	private int minIdle;

	@Value("${spring.datasource.druid.max-active}")
	private int maxActive;

	@Value("${spring.datasource.druid.max-wait}")
	private int maxWait;

	// @Bean(initMethod = "init", destroyMethod = "close")
	@Bean
	@Primary // 缺省
	/**
	 * 1.加载多数据源 2.初始化数据源 3.加载并设置druid数据源配置
	 * 
	 * @param primaryDbDataSource
	 * @param secondaryDataSource
	 * @return
	 */
	public DynamicDataSource dataSource(@Qualifier("primaryDbDataSource") DataSource primaryDbDataSource,
			@Qualifier("secondaryDataSource") DataSource secondaryDataSource) {
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put("primaryDB", primaryDbDataSource);
		targetDataSources.put("secondaryDB", secondaryDataSource);

		// 加载多数据源
		DynamicDataSource dataSource = new DynamicDataSource();
		dataSource.setTargetDataSources(targetDataSources);
		// 设置默认数据源
		dataSource.setDefaultTargetDataSource(primaryDbDataSource);// 默认的datasource设置为primaryDbDataSource

		DruidDataSource datasource = new DruidDataSource();
		datasource.setInitialSize(initialSize);
		datasource.setMinIdle(minIdle);
		datasource.setMaxActive(maxActive);
		datasource.setMaxWait(maxWait);
		return dataSource;
	}

	/**
	 * primary-dataSource
	 * 
	 * @return
	 * @throws Exception
	 */
	@Bean
	public DataSource primaryDbDataSource() throws Exception {
		Properties props = new Properties();
		props.put("driverClassName", env.getProperty(SDS + "primary.driver-class-name"));
		props.put("url", env.getProperty(SDS + "primary.url"));
		props.put("username", env.getProperty(SDS + "primary.username"));
		props.put("password", env.getProperty(SDS + "primary.password"));
		return DruidDataSourceFactory.createDataSource(props);
	}

	/**
	 * secondary-DataSource
	 * 
	 * @return
	 * @throws Exception
	 */
	@Bean
	public DataSource secondaryDataSource() throws Exception {
		Properties props = new Properties();
		props.put("driverClassName", env.getProperty(SDS + "secondary.driver-class-name"));
		props.put("url", env.getProperty(SDS + "secondary.url"));
		props.put("username", env.getProperty(SDS + "secondary.username"));
		props.put("password", env.getProperty(SDS + "secondary.password"));
		return DruidDataSourceFactory.createDataSource(props);
	}

}
