package com.demo.service;

import com.demo.beans.UserBean;
import com.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;

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


}
