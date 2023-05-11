package com.demo.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Component("loginUserBean")
@SessionScope
// 세션스코프(브라우저가 켜진동안 유지), 세션에 객체 loginUserBean등록...
public class LoginUserBean {

    private int user_idx; // 고유키 id
    private String user_name;

    @Size(min=4, max=20, message = "id는 4~20, 영어숫자")
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String user_id;  // user Id

    @Size(min=4, max=20, message = "pw은  4~20, 영어숫자")
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String user_pw;

    private boolean userLogin; //로그인 상태

    public LoginUserBean() {
        this.userLogin = false; //처음 상태는 로그인 false
    }


    public int getUser_idx() {
        return user_idx;
    }

    public void setUser_idx(int user_idx) {
        this.user_idx = user_idx;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    public boolean isUserLogin() {
        return userLogin;
    }

    public void setUserLogin(boolean userLogin) {
        this.userLogin = userLogin;
    }
}
