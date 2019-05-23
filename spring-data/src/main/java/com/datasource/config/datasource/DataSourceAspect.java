package com.datasource.config.datasource;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * AOP切换数据源
 * @author chenx
 *
 */
@Aspect
//@Order(-1)//在@Transactional事务标注的方法内切换数据源需要设置
@Component
public class DataSourceAspect {
	
	private static final Logger logger = LogManager.getLogger(DataSourceAspect.class);
 
 
	@Before("@annotation(targetDataSource)")
	public void setDataSourceKey(JoinPoint point,TargetDataSource targetDataSource) throws Throwable{
		//根据连接点所属的类实例,动态切换数据源
		logger.info("切换数据源为:{}",targetDataSource.value());
		DynamicDataSource.setDataSourceType(targetDataSource.value());
	}
	@After("@annotation(targetDataSource)")
    public void clearDataSourceType(JoinPoint point,TargetDataSource targetDataSource) {  
		logger.info("移除数据源为:{}",DynamicDataSource.getDataSourceType());
		DynamicDataSource.clearDataSourceType();
    } 
	
}
