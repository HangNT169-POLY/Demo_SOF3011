package com.hangnt.demo_sof3011.B13_PhanQuyen_Filter.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author hangnt169
 */
@WebFilter({"/sinh-vien/*", "/thuc-vat/*"})
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    //    https://hivetech.vn/https-hivetech-vn-java-servlet-filter/
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // neu chua dang nhap thi quay lai dang nhap
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        if (session.getAttribute("username") == null) {
            ((HttpServletResponse) response)
                    .sendRedirect("/session13");
        } else {
//            String role = (String) session.getAttribute("role");
//            if (role.equalsIgnoreCase("Admin")) {
//                // nhay toi trang sv
//                chain.doFilter(request, response);
//                ((HttpServletResponse) response)
//                        .sendRedirect("/sinh-vien/hien-thi");
//            } else if (role.equalsIgnoreCase("Client")) {
//                // nhay toi trang tv
//                ((HttpServletResponse) response)
//                        .sendRedirect("/thuc-vat/hien-thi");
//                chain.doFilter(request, response);
//
//            } else {
//                session.setAttribute("mess", "Sai quyen");
//                ((HttpServletResponse) response)
//                        .sendRedirect("/session13");
//            }
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
