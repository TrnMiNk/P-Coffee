package model;

public class SanPham {
    private int id;
    private String name;
    private String loai;
    private int gia;
    private String linkAnh;
    private int user_id; // Khóa ngoại

    // Constructor khi thêm mới (chưa có ID)
    public SanPham(String name, String loai, int gia, String linkAnh, int user_id) {
        this.name = name;
        this.loai = loai;
        this.gia = gia;
        this.linkAnh = linkAnh;
        this.user_id = user_id;
    }

    // Constructor khi đọc từ DB hoặc Sửa (có ID)
    public SanPham(int id, String name, String loai, int gia, String linkAnh, int user_id) {
        this.id = id;
        this.name = name;
        this.loai = loai;
        this.gia = gia;
        this.linkAnh = linkAnh;
        this.user_id = user_id;
    }

    // Constructor cũ (cho form thêm/sửa nhanh)
    public SanPham(String name, String loai, int gia, String linkAnh) {
        this.name = name;
        this.loai = loai;
        this.gia = gia;
        this.linkAnh = linkAnh;
        this.user_id = -1;
    }

    // --- Getters & Setters ---
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLoai() { return loai; }
    public void setLoai(String loai) { this.loai = loai; }
    public int getGia() { return gia; }
    public void setGia(int gia) { this.gia = gia; }
    public String getLinkAnh() { return linkAnh; }
    public void setLinkAnh(String linkAnh) { this.linkAnh = linkAnh; }
    public int getUser_id() { return user_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }
}