package com.hangnt.demo_sof3011.B3_CRUD_FixCung.controller.sinhvien;
/**
 * @author hangnt169
 */

import com.hangnt.demo_sof3011.B3_CRUD_FixCung.entity.SinhVien;
import com.hangnt.demo_sof3011.B3_CRUD_FixCung.service.SinhVienService;
import com.hangnt.demo_sof3011.B3_CRUD_FixCung.service.impl.SinhVienServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",  // GET
        "/sinh-vien/view-add",    // GET
        "/sinh-vien/add",        // POST
        "/sinh-vien/view-update",// GET
        "/sinh-vien/update",    // POST
        "/sinh-vien/delete",    // GET
        "/sinh-vien/detail",    // GET
        "/sinh-vien/search"     // GET
})
public class SinhVienServlet extends HttpServlet {

    private List<SinhVien> sinhViens = new ArrayList<>();
    private SinhVienService sinhVienService = new SinhVienServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiSinhVien(request, response);
        } else if (uri.contains("detail")) {
            this.detailSinhVien(request, response);
        } else if (uri.contains("view-add")) {
            this.hienThiAdd(request, response);
        } else if (uri.contains("view-update")) {
            this.hienThiUpdate(request, response);
        } else if (uri.contains("delete")) {
            this.deleteSinhVien(request, response);
        } else {
            this.searchSinhVien(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addSinhVien(request, response);
        } else {
            this.updateSinhVien(request, response);
        }
    }

    private void addSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String mssv = request.getParameter("mssv");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String diaChi = request.getParameter("diaChi");
        String gioiTinh = request.getParameter("gioiTinh");
        SinhVien sinhVien = new SinhVien(mssv, ten, Integer.valueOf(tuoi), diaChi, Boolean.parseBoolean(gioiTinh));
        sinhVienService.addSinhVien(sinhVien, sinhViens);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void updateSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String mssv = request.getParameter("mssv");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String diaChi = request.getParameter("diaChi");
        String gioiTinh = request.getParameter("gioiTinh");
        SinhVien newSinhVien = new SinhVien(mssv, ten, Integer.valueOf(tuoi), diaChi, Boolean.parseBoolean(gioiTinh));
        sinhVienService.updateSinhVien(mssv, sinhViens, newSinhVien);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void hienThiSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (sinhViens.isEmpty()) {
            sinhViens.add(new SinhVien("HangNT169", "Nguy???n Thu?? H???ng", 10, "H?? N???i", false));
            sinhViens.add(new SinhVien("PhongTT35", "Tr???n Tu???n Phong", 11, "H?? N???i1", true));
            sinhViens.add(new SinhVien("NguyenVV4", "V?? V??n Nguy??n", 12, "H?? N???i2", true));
            sinhViens.add(new SinhVien("KhanhPG", "Ph???m Gia Kh??nh", 13, "H?? N???i", true));
            sinhViens.add(new SinhVien("TienNH21", "Nguy???n Ho??ng Ti???n", 14, "H?? N???i3", true));
            sinhViens.add(new SinhVien("DungNA29", "Nguy???n Anh D??ng", 15, "H?? N???i4", true));
        }
        request.setAttribute("sinhViens", sinhViens);
        request.getRequestDispatcher("/view/buoi3/sinhviens.jsp").forward(request, response);
    }

    private void detailSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mssv = request.getParameter("mssv");
        int index = sinhVienService.findIndexSinhVien(sinhViens, mssv);
        SinhVien sinhVien = sinhViens.get(index);
        request.setAttribute("sinhVien", sinhVien);
        request.getRequestDispatcher("/view/buoi3/detail-sinh-vien.jsp").forward(request, response);
    }

    private void hienThiAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/buoi3/add-sinh-vien.jsp").forward(request, response);
    }

    private void hienThiUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mssv = request.getParameter("mssv");
        int index = sinhVienService.findIndexSinhVien(sinhViens, mssv);
        SinhVien sinhVien = sinhViens.get(index);
        request.setAttribute("sinhVien", sinhVien);
        request.getRequestDispatcher("/view/buoi3/update-sinh-vien.jsp").forward(request, response);
    }

    private void deleteSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mssv = request.getParameter("mssv");
        sinhVienService.deleteSinhVien(mssv, sinhViens);
        response.sendRedirect("/sinh-vien/hien-thi");
//        request.setAttribute("sinhViens", sinhViens);
//        request.getRequestDispatcher("/view/buoi3/sinhviens.jsp").forward(request, response);
    }

    private void searchSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("ten");
        List<SinhVien> listSearch = sinhVienService.searchVien(sinhViens, ten);
        request.setAttribute("sinhViens", listSearch);
        request.getRequestDispatcher("/view/buoi3/sinhviens.jsp").forward(request, response);
    }
}
