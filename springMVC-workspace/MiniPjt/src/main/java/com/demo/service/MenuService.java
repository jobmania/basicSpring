package com.demo.service;

import com.demo.beans.BoardInfoBean;
import com.demo.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {


    private final MenuMapper menuMapper;
    @Autowired
    public MenuService(MenuMapper menuMapper){
        this.menuMapper = menuMapper;
    }

    public List<BoardInfoBean> getMenuList(){
        List<BoardInfoBean> menuList = menuMapper.getMenuList();
        return menuList;
    }


}
