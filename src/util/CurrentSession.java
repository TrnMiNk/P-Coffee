// File: util/CurrentSession.java

package util;

import model.User;

public class CurrentSession {
    private static int userId = -1;
    private static String roleName = "";

    // (Phương thức setLoggedInUser đã được đề cập trước đó)
    public static void setLoggedInUser(User user) {
        if (user != null) {
            userId = user.getId();
            roleName = user.getRole_name();
        }
    }

    // 🌟 PHƯƠNG THỨC NÀY CẦN PHẢI CÓ 🌟
    // Phương thức xóa thông tin khi đăng xuất
    public static void clearSession() {
        userId = -1;
        roleName = "";
    }

    public static int getUserId() {
        return userId;
    }

    public static String getRoleName() {
        return roleName;
    }
}