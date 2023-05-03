package com.demo.main;

import com.demo.beans.JdbcBean;
import com.demo.config.BeanConfigClass;
import com.demo.db.JdbcDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        // IOC Container .
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);

        JdbcDAO dao = ctx.getBean(JdbcDAO.class);

        // 테이블 입력
        JdbcBean bean = new JdbcBean();
        bean.setInt_data(1);
        bean.setStr_data("엄준식");

        dao.insert_data(bean);

        List<JdbcBean> jdbcBeans = dao.select_data();
        for (JdbcBean jdbcBean : jdbcBeans) {
            System.out.println(jdbcBean.getInt_data());
            System.out.println(jdbcBean.getStr_data());
        }

        // update
        JdbcBean bean4 = new JdbcBean();
        bean4.setInt_data(1);
        bean4.setStr_data("문자열3");
        dao.update_data(bean4);
//
        dao.delete_data(1);



        ctx.close();
    }
}
