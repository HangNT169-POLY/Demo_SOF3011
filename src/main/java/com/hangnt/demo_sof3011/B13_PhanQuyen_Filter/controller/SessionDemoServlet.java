package com.hangnt.demo_sof3011.B13_PhanQuyen_Filter.controller;
/**
 * @author hangnt169
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "SessionDemoServlet", value = {"/session13", "/login/check13"})
public class SessionDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/buoi13/buoi5.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equalsIgnoreCase("HangNT169") && password.equals("123456")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            request.getRequestDispatcher("/view/buoi13/ketqua.jsp").forward(request, response);
        } else {
            request.setAttribute("messs", "Thong tin hoac mat khau sai");
            request.getRequestDispatcher("/view/buoi13/buoi5.jsp").forward(request, response);
        }
    }
}
