package com.hangnt.demo_sof3011.B3_CRUD_FixCung.service.impl;

import com.hangnt.demo_sof3011.B3_CRUD_FixCung.entity.SinhVien;
import com.hangnt.demo_sof3011.B3_CRUD_FixCung.service.SinhVienService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hangnt169
 */
public class SinhVienServiceImpl implements SinhVienService {
    @Override
    public List<SinhVien> searchVien(List<SinhVien> sinhViens, String name) {
        List<SinhVien> listSearch = new ArrayList<>();
        for (SinhVien sv : sinhViens) {
            if (sv.getTen().contains(name)) {
                listSearch.add(sv);
            }
        }
        return listSearch;
    }

    @Override
    public boolean updateSinhVien(String mssv, List<SinhVien> sinhViens, SinhVien newSinhVien) {
        int indexFind = findIndexSinhVien(sinhViens, mssv);
        if (indexFind == -1) {
            return false;
        }
        // update
        sinhViens.set(indexFind, newSinhVien);
        return true;
    }

    @Override
    public boolean deleteSinhVien(String mssv, List<SinhVien> sinhViens) {
        int indexFind = findIndexSinhVien(sinhViens, mssv);
        if (indexFind == -1) {
            return false;
        }
        // delete
        sinhViens.remove(indexFind);
        return true;
    }

    @Override
    public void addSinhVien(SinhVien sinhVien, List<SinhVien> sinhViens) {
        sinhViens.add(sinhVien);
    }

    @Override
    public int findIndexSinhVien(List<SinhVien> sinhViens, String mssv) {
        for (int i = 0; i < sinhViens.size(); i++) {
            if (sinhViens.get(i).getMssv().equalsIgnoreCase(mssv)) {
                return i;
            }
        }
        return -1;
    }
}
