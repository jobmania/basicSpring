package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.demo.beans.DataBean;

public interface MapperInterface {

	@Insert("INSERT INTO spring_mvc_table VALUES(#{data1}, #{data2}, #{data3})")
	void insert_data(DataBean dataBean);
	
	@Select("SELECT * FROM spring_mvc_table")
	List<DataBean> select_data();
	
	
	
}
