package com.ywd.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * MyBatis基础配置
 * @author ywd
 *
 */
@Configuration
@EnableTransactionManagement
@Import(MyBatisMapperScannerConfig.class)
public class MyBatisConfig implements TransactionManagementConfigurer{
	
	@Autowired
    private DataSource dataSource;
	
	 @Bean
	  public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
		  SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		  sqlSessionFactory.setDataSource(dataSource);
		  PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		  sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:com/ywd/mappers/*.xml"));
		  sqlSessionFactory.setTypeAliasesPackage("com.ywd.entity");
		  return sqlSessionFactory;
	  }
	 
	@Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
	
}
