package com.hangnt.demo_sof3011.B2_MethodGetPost_MVC;
/**
 * @author hangnt169
 */

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "XuLyThongTinServlet", value = {"/login/form","/login/check"})
public class XuLyThongTinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("mess","Xin chao SOF3011");
        request.getRequestDispatcher("/view/buoi2/buoi2.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("username",username);
        request.setAttribute("password",password);
        request.getRequestDispatcher("/view/buoi2/ketqua.jsp").forward(request,response);
    }
}
