package com.demo.config;

import com.demo.mapper.MapperInterface;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@ComponentScan(basePackages = {"com.demo.beans"})
@Configuration
public class BeanConfigClass {

    @Bean
    public BasicDataSource source() {
        BasicDataSource source = new BasicDataSource();
        source.setDriverClassName("oracle.jdbc.OracleDriver");
        source.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        source.setUsername("scott");
        source.setPassword("1234");

        return source;
    }

    /**
     *   MyBatis API
     *
     * SqlSessionFactoryBuilder
     * - 역할 : SqlSessionFactory 생성
     * SqlSessionFactory
     * - MyBatis의 전역 정보를 가지고 실행을 제어
     * - SqlSession 생성
     * - Application당 하나만 생성하는 것이 권장됨
     * SqlSession
     * - 역할 :  쿼리 실행 처리
     * - 작업 단위 별로 SqlSessionFactory로 부터 생성
     * */

    // SqlSessionFactory : jdbc를 처리하는 객체  ,  Mybatis
    @Bean
    public SqlSessionFactory factory(BasicDataSource source) throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(source);
        SqlSessionFactory factory = factoryBean.getObject();
        return factory;
    }

    // Mapper 인터페이스 구현 객체 (dao)
    @Bean
    public MapperFactoryBean<MapperInterface> test_mapper(SqlSessionFactory factory) throws Exception{
        MapperFactoryBean<MapperInterface> factoryBean = new MapperFactoryBean<MapperInterface>(MapperInterface.class);
        factoryBean.setSqlSessionFactory(factory);
        return factoryBean;
    }

}
