package controller;

import dao.SanPhamDAO;
import model.SanPham;
import java.util.List;

public class SanPhamController {

    private SanPhamDAO sanPhamDAO;

    public SanPhamController() {
        // Khởi tạo DAO thực tế
        sanPhamDAO = new SanPhamDAO();
    }

    // Lấy tất cả sản phẩm CỦA một User
    public List<SanPham> getAllSanPham(int userId) {
        return sanPhamDAO.getByUserId(userId);
    }

    // Thêm sản phẩm
    public boolean addSanPham(SanPham sp) {
        if (sp.getName().trim().isEmpty() || sp.getUser_id() <= 0) {
            System.out.println("Dữ liệu không hợp lệ hoặc thiếu User ID!");
            return false;
        }
        return sanPhamDAO.add(sp);
    }

    // Sửa sản phẩm
    public boolean updateSanPham(SanPham sp) {
        if (sp.getId() <= 0 || sp.getUser_id() <= 0) {
            System.out.println("ID sản phẩm hoặc User ID không hợp lệ!");
            return false;
        }
        return sanPhamDAO.update(sp);
    }

    // Xóa sản phẩm
    public boolean deleteSanPham(int sanPhamId, int userId) {
        if (sanPhamId <= 0 || userId <= 0) {
            System.out.println("ID không hợp lệ để xóa!");
            return false;
        }
        return sanPhamDAO.delete(sanPhamId, userId);
    }
}