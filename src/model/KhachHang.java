package model;

public class KhachHang {
    private int id;
    private String name;
    private String sdt;
    private int sl; // Số lượng sản phẩm đã mua
    private int user_id; // Khóa ngoại

    // Constructor khi đọc từ DB
    public KhachHang(int id, String name, String sdt, int sl, int user_id) {
        this.id = id;
        this.name = name;
        this.sdt = sdt;
        this.sl = sl;
        this.user_id = user_id;
    }

    // Constructor khi thêm mới (chưa có ID)
    public KhachHang(String name, String sdt, int sl, int user_id) {
        this.name = name;
        this.sdt = sdt;
        this.sl = sl;
        this.user_id = user_id;
    }

    // --- Getters & Setters ---
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }
    public int getSl() { return sl; }
    public void setSl(int sl) { this.sl = sl; }
    public int getUser_id() { return user_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }
}