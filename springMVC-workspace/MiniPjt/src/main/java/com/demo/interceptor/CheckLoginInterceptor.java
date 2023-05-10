package com.demo.interceptor;

import com.demo.beans.LoginUserBean;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckLoginInterceptor implements HandlerInterceptor {

    private LoginUserBean loginUserBean;

    public CheckLoginInterceptor(LoginUserBean loginUserBean) {
        this.loginUserBean = loginUserBean;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!loginUserBean.isUserLogin()){
            String contexPath = request.getContextPath();
            response.sendRedirect(contexPath + "/user/not_login");
            return false;
        }
        return true; //요청한 페이지 이동
    }
}
