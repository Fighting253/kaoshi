package com.lj.controller;



import com.lj.service.MenuService;
import com.lj.service.impl.MenuServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 验证学生姓名是否可用
 */
@WebServlet("/checkCode")//接口
public class CheckCodeServlet extends HttpServlet {
    private MenuService menuService = new MenuServiceimpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        //调用业务层根据编号查询。
        boolean flag=menuService.checkCode(code);
        //响应对象,设置响应对象的类型
        resp.setContentType("text/html;charset=UTF-8");
        //获取输出对象
        PrintWriter writer = resp.getWriter();
        writer.print(flag);
        //自己关闭流对象
        writer.flush();
        writer.close();
    }
}

