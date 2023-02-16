package com.hangnt.demo_sof3011.B7_9_CRUD_Hibernate.controller.product;
/**
 * @author hangnt169
 */

import com.hangnt.demo_sof3011.B7_9_CRUD_Hibernate.model.response.ProductReponse;
import com.hangnt.demo_sof3011.B7_9_CRUD_Hibernate.service.ProductService;
import com.hangnt.demo_sof3011.B7_9_CRUD_Hibernate.service.impl.ProductServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/product/hien-thi")
public class ProductController extends HttpServlet {

    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductReponse> productReponses = productService.getAll();
        request.setAttribute("products", productReponses);
        request.getRequestDispatcher("/view/buoi7/buoi7.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
