package com.demo.mapper;

import com.demo.beans.DataBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MapperInterface {

	@Insert("INSERT INTO spring_mvc_table VALUES(#{data1}, #{data2}, #{data3})")
	void insert_data(DataBean dataBean);
	
	@Select("SELECT * FROM spring_mvc_table")
	List<DataBean> select_data();
	
	
	
}
