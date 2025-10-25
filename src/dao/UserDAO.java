package dao;

import model.User;
import java.sql.*;

public class UserDAO {

    // Thêm user mới (đăng ký)
    public boolean add(User user) {
        // Đảm bảo cột role_name tồn tại trong DB
        String sql = "INSERT INTO users(username, password, fullname, role_name) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFullname());
            ps.setString(4, user.getRole_name());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Kiểm tra username đã tồn tại chưa
    public boolean checkExist(String username) {
        // Dùng SELECT TOP 1 cho SQL Server và MySQL
        String sql = "SELECT TOP 1 id FROM users WHERE username = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Đăng nhập
    public User login(String username, String password) {
        // Đảm bảo câu lệnh SELECT lấy ra role_name
        String sql = "SELECT id, username, password, fullname, role_name FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("fullname"),
                        rs.getString("role_name")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}