package com.hangnt.demo_sof3011.B3_CRUD_FixCung.service;

import com.hangnt.demo_sof3011.B3_CRUD_FixCung.entity.SinhVien;

import java.util.List;

/**
 * @author hangnt169
 */
public interface SinhVienService {

    List<SinhVien> searchVien(List<SinhVien> sinhViens, String name);

    boolean updateSinhVien(String mssv, List<SinhVien> sinhViens, SinhVien newSinhVien);

    boolean deleteSinhVien(String mssv, List<SinhVien> sinhViens);

    void addSinhVien(SinhVien sinhVien, List<SinhVien> sinhViens);

    int findIndexSinhVien(List<SinhVien> sinhViens, String mssv);

}
