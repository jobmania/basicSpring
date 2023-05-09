package com.demo.mapper;

import com.demo.beans.DataBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MapperInterface {


    @Insert("insert into spring_mvc_table values(#{data1}, #{data2}, #{data3})")
    void insert_data(DataBean dataBean);

    @Select("select data1, data2, data3 from spring_mvc_table")
    List<DataBean> select_data();

}
