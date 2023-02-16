/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hangnt.demo_sof3011.B7_9_CRUD_Hibernate.repository;

import com.hangnt.demo_sof3011.B7_9_CRUD_Hibernate.entity.Product;
import com.hangnt.demo_sof3011.B7_9_CRUD_Hibernate.util.HibernatUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hangnt
 */
public class ProductRepository {
    
    private static final Logger logger = Logger.getLogger(CategoryRepository.class);
    
    private Session session = HibernatUtil.getFACTORY().openSession();
    
    private String fromTable = "FROM Product "; // HQL

    public List<Product> getAll() {
        Query query = session.createQuery(fromTable, Product.class);
        List<Product> products = query.getResultList();
        if (products.isEmpty()) {
            logger.debug("List product empty ");
        }
        return products == null ? new ArrayList<>() : products;
    }

    public static void main(String[] args) {
        new ProductRepository().getAll().forEach(s -> System.out.println(s.toString()));
    }
}
