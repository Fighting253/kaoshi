package com.lj.service;

import com.github.pagehelper.PageInfo;
import com.lj.pojo.Menu;

import java.util.List;

/**
 * 功能描述：
 * 作者：lj
 * 时间：2024/7/4
 */
public interface MenuService {

    PageInfo getMuneListPage(String page, int i);
    List<Menu> getMenuList();

    boolean deleteMenuById(int id);

    Menu getMenuById(String did);

    boolean updateMenu(Menu menu);

    boolean checkCode(String code);

    PageInfo getMenuListPage(String page, int i);
}
