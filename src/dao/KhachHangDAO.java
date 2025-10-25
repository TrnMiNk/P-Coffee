package dao;

import model.KhachHang;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO {

    // 1. Lấy tất cả Khách Hàng CỦA một User
    public List<KhachHang> getAll(int userId) {
        List<KhachHang> list = new ArrayList<>();
        String sql = "SELECT id, name, sdt, sl, user_id FROM khach_hang WHERE user_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new KhachHang(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("sdt"),
                            rs.getInt("sl"),
                            rs.getInt("user_id")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 2. Thêm Khách Hàng mới
    public boolean add(KhachHang kh) {
        String sql = "INSERT INTO khach_hang (name, sdt, sl, user_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, kh.getName());
            ps.setString(2, kh.getSdt());
            ps.setInt(3, kh.getSl());
            ps.setInt(4, kh.getUser_id()); // Thiết lập user_id

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 3. Sửa thông tin Khách Hàng
    public boolean update(KhachHang kh) {
        // Cần cả ID Khách Hàng và User ID để đảm bảo tính riêng tư
        String sql = "UPDATE khach_hang SET name = ?, sdt = ?, sl = ? WHERE id = ? AND user_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, kh.getName());
            ps.setString(2, kh.getSdt());
            ps.setInt(3, kh.getSl());
            ps.setInt(4, kh.getId());
            ps.setInt(5, kh.getUser_id());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 4. Xóa Khách Hàng
    public boolean delete(int id, int userId) { // Cần cả ID Khách Hàng và User ID
        String sql = "DELETE FROM khach_hang WHERE id = ? AND user_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setInt(2, userId);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}