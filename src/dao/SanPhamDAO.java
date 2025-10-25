package dao;

import model.SanPham;
import java.sql.*;
import java.util.*;

public class SanPhamDAO {

    // 1. Lấy danh sách sản phẩm của user
    public List<SanPham> getByUserId(int userId) {
        String sql = "SELECT id, name, loai, gia, linkAnh, user_id FROM sanpham WHERE user_id = ?";
        List<SanPham> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPham sp = new SanPham(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("loai"),
                        rs.getInt("gia"),
                        rs.getString("linkAnh"),
                        rs.getInt("user_id")
                );
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 2. Thêm sản phẩm mới
    public boolean add(SanPham sp) {
        String sql = "INSERT INTO sanpham(name, loai, gia, linkAnh, user_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sp.getName());
            ps.setString(2, sp.getLoai());
            ps.setInt(3, sp.getGia());
            ps.setString(4, sp.getLinkAnh());
            ps.setInt(5, sp.getUser_id());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 3. Sửa sản phẩm (CHECK ID và USER_ID)
    public boolean update(SanPham sp) {
        String sql = "UPDATE sanpham SET name = ?, loai = ?, gia = ?, linkAnh = ? WHERE id = ? AND user_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sp.getName());
            ps.setString(2, sp.getLoai());
            ps.setInt(3, sp.getGia());
            ps.setString(4, sp.getLinkAnh());
            ps.setInt(5, sp.getId());
            ps.setInt(6, sp.getUser_id()); // Kiểm tra quyền sở hữu

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 4. Xóa sản phẩm (CHECK ID và USER_ID)
    public boolean delete(int id, int userId) {
        String sql = "DELETE FROM sanpham WHERE id = ? AND user_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setInt(2, userId); // Kiểm tra quyền sở hữu
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}