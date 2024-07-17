package com.lj.controller;

import com.github.pagehelper.PageInfo;
import com.lj.pojo.Menu;
import com.lj.service.MenuService;
import com.lj.service.impl.MenuServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 功能描述：
 * 作者：lj
 * 时间：2024/7/4
 */
@WebServlet("/getMenuList")
public class GetMenuListServlet extends HttpServlet {
    private MenuService menuService = new MenuServiceimpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
// List<Menu> menuList=menuService.getMenuList();
//        req.setAttribute("menuList",menuList);
//
//        //使用转发的方式
//        req.getRequestDispatcher("/menuList.jsp").forward(req,resp);

        String page = req.getParameter("page");//用户请求的当前页
        //业务层返回PageInfo的对象，包含页面分页信息，集合列表
        PageInfo pageInfo=menuService.getMenuListPage(page,0);//查询pid=0的一级科室
        //跳转到jsp页面显示,把需要转发的数据放在Request作用域中
        req.setAttribute("pageInfo",pageInfo);
        //使用转发的方式
        req.getRequestDispatcher("/menuList.jsp").forward(req,resp);
    }
}
