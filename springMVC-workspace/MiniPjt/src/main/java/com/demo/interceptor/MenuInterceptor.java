package com.demo.interceptor;

import com.demo.beans.BoardInfoBean;
import com.demo.beans.LoginUserBean;
import com.demo.service.MenuService;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MenuInterceptor implements HandlerInterceptor {
    private final MenuService menuService;
    private LoginUserBean loginUserBean;
    //생성자 주입
    public MenuInterceptor(MenuService menuService, LoginUserBean loginUserBean) {
        this.menuService = menuService;
        this.loginUserBean = loginUserBean;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        List<BoardInfoBean> topMenuList = menuService.getMenuList();

        request.setAttribute("topMenuList", topMenuList);
        request.setAttribute("loginUserBean", loginUserBean);
        return true;
    }



}
