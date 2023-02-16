/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hangnt.demo_sof3011.B7_9_CRUD_Hibernate.service.impl;

import com.hangnt.demo_sof3011.B7_9_CRUD_Hibernate.entity.Category;
import com.hangnt.demo_sof3011.B7_9_CRUD_Hibernate.repository.CategoryRepository;
import com.hangnt.demo_sof3011.B7_9_CRUD_Hibernate.service.CategoryService;

import java.util.List;

/**
 * @author hangnt
 */
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository = new CategoryRepository();

    @Override
    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

}
