package com.datasource.config.datasource;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源（需要继承AbstractRoutingDataSource）
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	private static final Logger logger = LogManager.getLogger(AbstractRoutingDataSource.class);

	@Override
	protected Object determineCurrentLookupKey() {
		return getDataSourceType();//获取当前线程的DatabaseType
	}

	public static void setDataSourceType(String dataSourceType) {
		logger.info("设置数据源:"+dataSourceType);
		contextHolder.set(dataSourceType);
	}

	public static String getDataSourceType() {
		return contextHolder.get();
	}

	public static void clearDataSourceType() {
		contextHolder.remove();
	}
	
	

}
