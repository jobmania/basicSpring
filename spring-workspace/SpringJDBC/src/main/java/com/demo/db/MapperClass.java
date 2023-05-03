package com.demo.db;

import com.demo.beans.JdbcBean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapperClass implements RowMapper<JdbcBean> {


    @Override
    public JdbcBean mapRow(ResultSet rs, int rowNum) throws SQLException {
        //DB테이블 데이터 가져올때 객체와 매핑
        JdbcBean bean = new JdbcBean();
        bean.setInt_data(rs.getInt("int_data"));
        bean.setStr_data(rs.getString("str_data"));

        return bean;
    }
}
