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
@WebServlet("/updateMenu")
public class UpdateMenuServlet extends HttpServlet {
    private MenuService menuService = new MenuServiceimpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code=req.getParameter("code");
        String dname=req.getParameter("dname");
        String  price =req.getParameter("price");
        String classification=req.getParameter("classification");
        Menu menu = new Menu();
        menu.setCode(code);
        menu.setDname(dname);
        menu.setPrice(price);
        menu.setClassification(classification);
        boolean flag=menuService.updateMenu(menu);
        if(flag){
            resp.sendRedirect(req.getContextPath()+"/getMenuList");
        }

    }
}
