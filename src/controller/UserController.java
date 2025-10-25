package controller;

import dao.UserDAO;
import model.User;

public class UserController {
    private UserDAO userDAO;

    public UserController() {
        userDAO = new UserDAO();
    }

    // Đăng ký tài khoản mới
    public boolean register(User user) {
        if (user.getUsername().trim().isEmpty() || user.getPassword().trim().isEmpty()) {
            System.out.println("Tên đăng nhập hoặc mật khẩu không được để trống!");
            return false;
        }
        if (userDAO.checkExist(user.getUsername())) {
            System.out.println("Tài khoản đã tồn tại!");
            return false;
        }

        // --- BỔ SUNG: Thiết lập vai trò mặc định cho tài khoản mới ---
        // Chúng ta giả định user mới đăng ký là 'User' (không phải 'Admin')
        // Dù DB đã có DEFAULT 'User', việc set trong code giúp nhất quán
        if (user.getRole_name() == null || user.getRole_name().isEmpty()) {
            user.setRole_name("User");
        }
        // -------------------------------------------------------------

        return userDAO.add(user);
    }

    // Đăng nhập (Giữ nguyên - đã chuẩn xác)
    public User login(String username, String password) {
        // Trả về User object, bao gồm ID và role_name
        User user = userDAO.login(username.trim(), password.trim());
        if (user == null) {
            System.out.println("Sai tên đăng nhập hoặc mật khẩu!");
        }
        return user;
    }
}