/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hangnt.demo_sof3011.B7_9_CRUD_Hibernate.service.impl;

import com.hangnt.demo_sof3011.B7_9_CRUD_Hibernate.entity.Product;
import com.hangnt.demo_sof3011.B7_9_CRUD_Hibernate.model.response.ProductReponse;
import com.hangnt.demo_sof3011.B7_9_CRUD_Hibernate.repository.ProductRepository;
import com.hangnt.demo_sof3011.B7_9_CRUD_Hibernate.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hangnt
 */
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository = new ProductRepository();

    @Override
    public List<ProductReponse> getAll() {
        List<Product> products = productRepository.getAll();
        return products.stream().map(ProductReponse::new).collect(Collectors.toList());
    }

}
