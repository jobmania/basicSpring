package com.demo.service;

import com.demo.beans.BoardInfoBean;
import com.demo.beans.ContentBean;
import com.demo.mapper.BoardMapper;
import com.demo.mapper.MenuMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {


    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private MenuMapper menuMapper;

    public List<ContentBean> getMainList(int board_info_idx){
        RowBounds rowBounds = new RowBounds(0, 5);
        return boardMapper.getContentList(board_info_idx, rowBounds);
    }

    public List<BoardInfoBean> getMenuList(){
        List<BoardInfoBean> menuList = menuMapper.getMenuList();
        return menuList;
    }


}
