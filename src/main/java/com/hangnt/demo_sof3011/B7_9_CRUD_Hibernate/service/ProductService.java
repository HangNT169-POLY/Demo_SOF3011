/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hangnt.demo_sof3011.B7_9_CRUD_Hibernate.service;

import com.hangnt.demo_sof3011.B7_9_CRUD_Hibernate.model.response.ProductReponse;

import java.util.List;

/**
 * @author hangnt
 */
public interface ProductService {

    List<ProductReponse> getAll();

}
