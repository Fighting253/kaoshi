package com.lj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lj.mapper.MenuMapper;
import com.lj.pojo.Menu;
import com.lj.service.MenuService;
import com.lj.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

/**
 * 功能描述：
 * 作者：lj
 * 时间：2024/7/4
 */
public class MenuServiceimpl implements MenuService {

//    @Override
//    public boolean deleteById(String id) {
//        SqlSession sqlSession = MybatisUtil.getSqlSession();
//        try {
//            MenuMapper muneMapper = sqlSession.getMapper(MenuMapper.class);
//            muneMapper.deleteById(id);
//            sqlSession.commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            sqlSession.rollback();
//        } finally {
//            MybatisUtil.closeSqlSession();
//        }
//        return false;
//    }

    @Override
    public PageInfo getMuneListPage(String page, int i) {
        return null;
    }

    @Override
    public List<Menu> getMenuList() {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
            return menuMapper.getMenuList();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {//不管try中是否有异常，finally一定会执行
            MybatisUtil.closeSqlSession();//关闭SqlSession对象
        }
        return null;
    }

    @Override
    public boolean deleteMenuById(int id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
            int affectRows = menuMapper.deleteMenuById(id);
            sqlSession.commit();
            return affectRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return false;
    }

    @Override
    public Menu getMenuById(String did) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
            Menu menu = menuMapper.getMenuById(did);
            return menu;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public boolean updateMenu(Menu menu) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
            menuMapper.updateMenu(menu);
            sqlSession.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return false;
    }

    @Override
    public boolean checkCode(String code) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
            int count = menuMapper.checkCode(code);//查询这个编号的个数
            return count <= 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return false;
    }

    @Override
    public PageInfo getMenuListPage(String page, int i) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
            //pageNum：用户请求的当前页。pageSize：每页显示的记录数
            if (page != null && !"".equals(page)) {
                PageHelper.startPage(Integer.valueOf(page), 3);//开始分页
            } else {
                PageHelper.startPage(1, 3);//开始分页，没有的话，默认返回第一页
            }
            List<Menu> menuList = menuMapper.getMenuList();
            PageInfo<Menu> pageInfo = new PageInfo<>(menuList);
            System.out.println("pageInfo:" + pageInfo);
            return pageInfo;
        } catch (Exception e) {
            e.printStackTrace();}
        finally{
                MybatisUtil.closeSqlSession();
            }
        return null;
        }
    }
