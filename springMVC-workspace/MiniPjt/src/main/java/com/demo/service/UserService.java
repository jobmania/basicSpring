package com.demo.service;

import com.demo.beans.LoginUserBean;
import com.demo.beans.UserBean;
import com.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;

    @Resource(name = "loginUserBean")
    private LoginUserBean loginUserBean;



    public boolean checkUserIdExist(String user_id) {

        String user_name = userMapper.checkUserIdExist(user_id);

        if(user_name == null) {
            return true;
        } else {
            return false;
        }
    }



    public void addUserInfo(UserBean joinUserBean){
        userMapper.addUserInfo(joinUserBean);
    }

    public void getLoginUserInfo(LoginUserBean loginBean){
        LoginUserBean tempLoginBean =  userMapper.getLoginUserInfo(loginBean);
        if(tempLoginBean != null) {
            loginUserBean.setUser_idx(tempLoginBean.getUser_idx());
            loginUserBean.setUser_name(tempLoginBean.getUser_name());
            loginUserBean.setUserLogin(true); //로그인 상태 true
        }
    }




}
