package model;

public class User {
    private int id;
    private String username;
    private String password;
    private String fullname;
    private String role_name; // Vai trò: 'Admin' hoặc 'User'

    // 1. Constructor ĐẦY ĐỦ (Dùng khi đọc từ DB/Đăng nhập)
    public User(int id, String username, String password, String fullname, String role_name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.role_name = role_name;
    }

    // 2. Constructor khi ĐĂNG KÝ/Thêm mới (chưa có ID)
    // Cần 4 tham số: username, password, fullname, role_name
    public User(String username, String password, String fullname, String role_name) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.role_name = role_name;
    }

    // Constructor cơ bản (có thể dùng trong một số trường hợp)
    public User() {
    }

    // --- Getters and Setters ---

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }
    public String getRole_name() { return role_name; }
    public void setRole_name(String role_name) { this.role_name = role_name; }
}