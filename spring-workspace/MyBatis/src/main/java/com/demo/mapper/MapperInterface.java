package com.demo.mapper;

import com.demo.beans.JdbcBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MapperInterface {

    // 실제 구현은 마이바티스가 자동으로 해준다!! DAO객체를 생성하고 ~~..
    @Select("SELECT * FROM jdbc_table")
    List<JdbcBean> select_data();

    // #{변수} ,
    @Insert("INSERT INTO JDBC_TABLE VALUES(#{int_data},#{str_data})")
    void insert_data(JdbcBean bean);

    @Update("update jdbc_table set str_data = #{str_data} where int_data = #{int_data}")
    void update_data(JdbcBean bean);

    @Delete("delete from jdbc_table where int_data = #{abc}")
    void delete_data(int int_data);


}
