/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hangnt.demo_sof3011.B7_9_CRUD_Hibernate.repository;

import com.hangnt.demo_sof3011.B7_9_CRUD_Hibernate.entity.Category;
import com.hangnt.demo_sof3011.B7_9_CRUD_Hibernate.util.HibernatUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.util.ObjectUtils;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hangnt
 */
public class CategoryRepository {

    private static final Logger logger = Logger.getLogger(CategoryRepository.class);

    private Session session = HibernatUtil.getFACTORY().openSession();

    private String fromTable = "FROM Category "; // HQL

    public List<Category> getAll() {
        Query query = session.createQuery(fromTable, Category.class);
        List<Category> categorys = query.getResultList();
        if (categorys.isEmpty()) {
            logger.debug("List category empty ");
        }
        return categorys == null ? new ArrayList<>() : categorys;
    }

    public Category getOne(Long id) {
        String sql = fromTable + " WHERE id = :id";
        Query query = session.createQuery(sql, Category.class);
        query.setParameter("id", id);
        Category category = (Category) query.getSingleResult();
        if (ObjectUtils.isEmpty(category)) {
            logger.debug("Category null ");
        }
        return category == null ? null : category;
    }

    public Boolean add(Category category) {
        Transaction transaction = null;
        try (Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
            return true;
        } catch (Exception e) {
        }
        return null;
    }

    public Boolean update(Category category, Long id) {
        Transaction transaction = null;
        try (Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(category);
            transaction.commit();
            return true;
        } catch (Exception e) {
        }
        return null;
    }

    public Boolean delete(Category category) {
        Transaction transaction = null;
        try (Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            //            Query query = session.createQuery("update LopHoc set tenLop = :tenLop"
//                    + " where maLop = :maLop");
//            query.setParameter("tenLop", "Lop update123");
//            query.setParameter("maLop", 113);
//            query.executeUpdate();
            session.delete(category);
            transaction.commit();
            return true;
        } catch (Exception e) {
        }
        return null;
    }
//
    public static void main(String[] args) {
        new CategoryRepository().getAll().forEach(s -> System.out.println(s.toString()));
        System.out.println(new CategoryRepository().getOne(1L).toString());
    }
}
