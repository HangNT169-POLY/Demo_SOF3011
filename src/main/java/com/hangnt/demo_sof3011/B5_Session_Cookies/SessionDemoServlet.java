package com.hangnt.demo_sof3011.B5_Session_Cookies;
/**
 * @author hangnt169
 */

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SessionDemoServlet", value = {"/session", "/login/check1"})
public class SessionDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/buoi5/buoi5.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equalsIgnoreCase("HangNT169") && password.equals("123456")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            request.getRequestDispatcher("/view/buoi5/ketqua.jsp").forward(request, response);
        } else {
            request.setAttribute("messs", "Thong tin hoac mat khau sai");
            request.getRequestDispatcher("/view/buoi5/buoi5.jsp").forward(request, response);
        }
    }
}
