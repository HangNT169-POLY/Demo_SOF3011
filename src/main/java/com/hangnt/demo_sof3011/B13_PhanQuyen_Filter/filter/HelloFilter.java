package com.hangnt.demo_sof3011.B13_PhanQuyen_Filter.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter({"/hello-servlet"})
public class HelloFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("HelloFilter@init");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("HelloFilter@doFilter: before");
        // Code before Servlet

        chain.doFilter(request, response);

        // Code after Servlet
        System.out.println("HelloFilter@doFilter: after");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("HelloFilter@destroy");
    }
}
