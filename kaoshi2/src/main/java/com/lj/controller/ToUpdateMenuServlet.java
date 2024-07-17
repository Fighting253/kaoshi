package com.lj.controller;

import com.lj.pojo.Menu;
import com.lj.service.MenuService;
import com.lj.service.impl.MenuServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能描述：
 * 作者：lj
 * 时间：2024/7/4
 */
@WebServlet("/toUpdate")
public class ToUpdateMenuServlet extends HttpServlet {
    private MenuService menuService = new MenuServiceimpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String did=req.getParameter("did");//修改传的参数
        //调用业务层方法，根据主键id查询对象
        Menu menu = menuService.getMenuById(did);
        //把对象放在request作用域中
        req.setAttribute("menu", menu);
        //使用转发的方式跳转页面
        req.getRequestDispatcher("/updateMenu.jsp").forward(req, resp);

    }
}
