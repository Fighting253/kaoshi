package com.lj.controller;

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
@WebServlet("/deleteMenu")
public class DeleteMenuServlet extends HttpServlet {
    private MenuService menuService = new MenuServiceimpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        if (id != null && !id.isEmpty()) {
            boolean sucess = menuService.deleteMenuById(Integer.parseInt(id));
            if (sucess) {
                System.out.println("删除成功");
                resp.sendRedirect(req.getContextPath() + "/getMenuList");
            } else {
                System.out.println("删除失败");
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Delete failed");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_GATEWAY, "ID is missing");
        }
    }
}
