package com.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class TestBean3 {

    @Autowired
    @Qualifier("data2") // 빈이름
    private DataBean2 data2;

    // 변수의 이름(data3)과 동일한 이름의 Bean객체가 주입
    @Resource // autowired + qulifier
    private DataBean2 data3;

    public DataBean2 getData2() {
        return data2;
    }

    public void setData2(DataBean2 data2) {
        this.data2 = data2;
    }

    public DataBean2 getData3() {
        return data3;
    }

    public void setData3(DataBean2 data3) {
        this.data3 = data3;
    }
}
