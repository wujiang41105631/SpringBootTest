package com.xcn.springboottest.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author: xupeng.guo
 * @date: 2019/6/14
 * @description
 */
@Configuration
@MapperScans({@MapperScan(basePackages = "com.xcn.springboottest.bsi.dao", sqlSessionFactoryRef = "sqlSessionFactory")})
public class DuridConfig {

    public DuridConfig() {
        System.out.println("init  DruildConfig");
    }


    /**
     * ######################### Druid连接池的配置信息  #################
     * spring.druid.initialSize: 5                                 #初始化连接大小
     * spring.druid.minIdle: 5                                     #最小连接池数量
     * spring.druid.maxActive: 20                                  #最大连接池数量
     * spring.druid.maxWait: 60000                                 #获取连接时最大等待时间，单位毫秒
     * spring.druid.timeBetweenEvictionRunsMillis: 60000           #配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
     * spring.druid.minEvictableIdleTimeMillis: 300000             #配置一个连接在池中最小生存的时间，单位是毫秒
     * spring.druid.validationQuery: SELECT 1 FROM DUAL            #测试连接
     * spring.druid.testWhileIdle: true                            #申请连接的时候检测，建议配置为true，不影响性能，并且保证安全性
     * spring.druid.testOnBorrow: false                            #获取连接时执行检测，建议关闭，影响性能
     * spring.druid.testOnReturn: false                            #归还连接时执行检测，建议关闭，影响性能
     * spring.druid.poolPreparedStatements: false                  #是否开启PSCache，PSCache对支持游标的数据库性能提升巨大，oracle建议开启，mysql下建议关闭
     * spring.druid.maxPoolPreparedStatementPerConnectionSize: 20  #开启poolPreparedStatements后生效
     * spring.druid.filters: stat,wall,log4j                       #配置扩展插件，常用的插件有=>stat:监控统计  log4j:日志  wall:防御sql注入
     * spring.druid.connectionProperties: 'druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000'  #通过connectProperties属性来打开mergeSql功能;慢SQL记录
     **/

    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;
    @Value("${mybatis.config-location}")
    private String configLocation;


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary // spring 在犹豫的时候优先选择哪一个具体的实现
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(configLocation));
        factoryBean.setDataSource(dataSource());
        return factoryBean.getObject();
    }
}
