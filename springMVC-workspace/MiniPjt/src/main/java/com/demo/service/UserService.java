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

    /// 현재 로그인 상태 저장 빈(세션스코프빈)
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


    public void getModifyUserInfo(UserBean modifyUserBean) {
        UserBean temp = userMapper.getModifyUserInfo(loginUserBean.getUser_idx());

        // 수정할 대상을 modifyUserBean save한다.
        modifyUserBean.setUser_id(temp.getUser_id());
        modifyUserBean.setUser_name(temp.getUser_name());
        modifyUserBean.setUser_idx(temp.getUser_idx());
    }

    public void modifyUserInfo(UserBean modifyUserBean) {

        modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
        userMapper.modifyUserInfo(modifyUserBean);
    }

}
