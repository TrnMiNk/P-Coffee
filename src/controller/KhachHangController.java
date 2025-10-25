package controller;

import dao.KhachHangDAO;
import model.KhachHang;
import java.util.List;

public class KhachHangController {

    private KhachHangDAO khachHangDAO;

    public KhachHangController() {
        khachHangDAO = new KhachHangDAO();
    }

    // Lấy tất cả Khách Hàng CỦA một User
    public List<KhachHang> getAllKhachHang(int userId) {
        return khachHangDAO.getAll(userId);
    }

    // Thêm Khách Hàng
    public boolean addKhachHang(KhachHang kh) {
        if (kh.getName().trim().isEmpty() || kh.getUser_id() <= 0) {
            System.out.println("Dữ liệu không hợp lệ hoặc thiếu User ID!");
            return false;
        }
        return khachHangDAO.add(kh);
    }

    // Sửa Khách Hàng
    public boolean updateKhachHang(KhachHang kh) {
        if (kh.getId() <= 0 || kh.getUser_id() <= 0) {
            System.out.println("ID Khách Hàng hoặc User ID không hợp lệ!");
            return false;
        }
        return khachHangDAO.update(kh);
    }

    // Xóa Khách Hàng
    public boolean deleteKhachHang(int khachHangId, int userId) {
        if (khachHangId <= 0 || userId <= 0) {
            System.out.println("ID không hợp lệ để xóa!");
            return false;
        }
        // Gọi DAO với cả 2 ID để đảm bảo phân quyền
        return khachHangDAO.delete(khachHangId, userId);
    }
}