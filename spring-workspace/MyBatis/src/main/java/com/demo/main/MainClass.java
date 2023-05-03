package com.demo.main;

import com.demo.beans.JdbcBean;
import com.demo.config.BeanConfigClass;

import com.demo.mapper.MapperInterface;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        // IOC Container .
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);

        MapperInterface mapper = ctx.getBean(MapperInterface.class);

        // 입력
        JdbcBean bean = new JdbcBean();
        bean.setStr_data("식");
        bean.setInt_data(4);
        mapper.insert_data(bean);

        //업데이트
        JdbcBean updateBean = new JdbcBean();
        bean.setStr_data("식");
        bean.setInt_data(5);
        mapper.update_data(bean);

        // 삭제
        mapper.delete_data(5);

        // 출력
        List<JdbcBean> list = mapper.select_data();
        for (JdbcBean jdbcBean : list) {
            System.out.println(jdbcBean.getInt_data());
            System.out.println( jdbcBean.getStr_data());
        }



        ctx.close();
    }
}
