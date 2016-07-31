package com.ywd.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DataConfig {

  @Bean
  public DataSource dataSource() {
	DruidDataSource ds = new DruidDataSource();
	ds.addConnectionProperty("url", "jdbc:mysql://localhost:3306/db_rbps?useUnicode=true&amp;characterEncoding=UTF-8");
	ds.addConnectionProperty("username", "root");
	ds.addConnectionProperty("password", "admin");
    return ds;
  }

}
