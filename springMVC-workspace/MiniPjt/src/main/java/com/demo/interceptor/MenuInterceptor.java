package com.demo.interceptor;

import com.demo.beans.BoardInfoBean;
import com.demo.service.MenuService;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MenuInterceptor implements HandlerInterceptor {
    private final MenuService menuService;

    //생성자 주입
    public MenuInterceptor(MenuService menuService) {
        this.menuService = menuService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        List<BoardInfoBean> topMenuList = menuService.getMenuList();

        request.setAttribute("topMenuList", topMenuList);

        return true;
    }



}
