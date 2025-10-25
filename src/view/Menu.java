package view;

import java.awt.Color;
import javax.swing.JOptionPane;
import util.CurrentSession; // 🌟 Import CurrentSession để lấy User ID và Role

/**
 *
 * @author ADMIN
 */
public class Menu extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Menu.class.getName());

    Color DefaultColor,ClickedColor;

    // Constructor không tham số
    public Menu() {
        initComponents();
        initializeMenuLogic(); // Gọi hàm khởi tạo logic
    }

    // Hàm khởi tạo logic chung cho Menu
    private void initializeMenuLogic() {
        // Lấy thông tin từ Session
        String role = CurrentSession.getRoleName();

        // Cập nhật UI và log thông tin
        if (role.isEmpty()) {
            logger.warning("Lỗi: Không tìm thấy Session. Chạy Menu mà không đăng nhập.");
        } else {
            logger.info("Menu loaded for Role: " + role + " (ID: " + CurrentSession.getUserId() + ")");
        }

        // 🌟 PHÂN QUYỀN HIỂN THỊ MENU 🌟
        // Nếu role là 'User', ẩn nút Thêm sản phẩm
        if ("User".equalsIgnoreCase(role)) {
            Them_san_pham.setVisible(false);
        } else {
            // Role khác (Admin, Manager,...) thì hiển thị
            Them_san_pham.setVisible(true);
        }

        DefaultColor=new Color(153,51,0);
        ClickedColor=new Color(204,0,51);

        // Thiết lập màu sắc và trạng thái ban đầu
        Trang_chu.setOpaque(true);
        Them_san_pham.setOpaque(true);
        Don_hang.setOpaque(true);
        Khach_hang.setOpaque(true);
        San_pham.setOpaque(true);
        Dang_Xuat.setOpaque(true);
        Gio_hang.setOpaque(true);

        Trang_chu.setBackground(DefaultColor);
        Them_san_pham.setBackground(DefaultColor);
        Don_hang.setBackground(DefaultColor);
        Khach_hang.setBackground(DefaultColor);
        San_pham.setBackground(DefaultColor);
        Dang_Xuat.setBackground(DefaultColor);
        Gio_hang.setBackground(DefaultColor);

        // Mở Trang chủ mặc định khi mở Menu
        Trang_chuMouseClicked(null);
        Trang_chuMousePressed(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
// ... (GIỮ NGUYÊN PHẦN CODE GENERATED BỞI NETBEANS)
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Trang_chu = new javax.swing.JLabel();
        San_pham = new javax.swing.JLabel();
        Them_san_pham = new javax.swing.JLabel();
        Dang_Xuat = new javax.swing.JLabel();
        Don_hang = new javax.swing.JLabel();
        Khach_hang = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Gio_hang = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(153, 51, 0));

        Trang_chu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Trang_chu.setForeground(new java.awt.Color(255, 255, 255));
        Trang_chu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        Trang_chu.setText("  Trang chủ");
        Trang_chu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Trang_chuMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Trang_chuMousePressed(evt);
            }
        });

        San_pham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        San_pham.setForeground(new java.awt.Color(255, 255, 255));
        San_pham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/list_product.png"))); // NOI18N
        San_pham.setText("  Sản phẩm");
        San_pham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                San_phamMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                San_phamMousePressed(evt);
            }
        });

        Them_san_pham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Them_san_pham.setForeground(new java.awt.Color(255, 255, 255));
        Them_san_pham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/product.png"))); // NOI18N
        Them_san_pham.setText("  Thêm");
        Them_san_pham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Them_san_phamMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Them_san_phamMousePressed(evt);
            }
        });

        Dang_Xuat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Dang_Xuat.setForeground(new java.awt.Color(255, 255, 255));
        Dang_Xuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        Dang_Xuat.setText("  Đăng xuất");
        Dang_Xuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Dang_XuatMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Dang_XuatMousePressed(evt);
            }
        });

        Don_hang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Don_hang.setForeground(new java.awt.Color(255, 255, 255));
        Don_hang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/don_hang.png"))); // NOI18N
        Don_hang.setText("  Đơn hàng");
        Don_hang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Don_hangMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Don_hangMousePressed(evt);
            }
        });

        Khach_hang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Khach_hang.setForeground(new java.awt.Color(255, 255, 255));
        Khach_hang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer.png"))); // NOI18N
        Khach_hang.setText(" Khách hàng");
        Khach_hang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Khach_hangMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Khach_hangMousePressed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(204, 0, 0));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/P_coffe.png"))); // NOI18N
        jLabel3.setText(" P_Coffee");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(17, Short.MAX_VALUE))
        );

        Gio_hang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Gio_hang.setForeground(new java.awt.Color(255, 255, 255));
        Gio_hang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/giohang.png"))); // NOI18N
        Gio_hang.setText("  Giỏ hàng");
        Gio_hang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Gio_hangMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Gio_hangMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Trang_chu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(Them_san_pham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Don_hang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Khach_hang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Dang_Xuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(San_pham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Gio_hang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(0, 9, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(Trang_chu)
                                .addGap(18, 18, 18)
                                .addComponent(San_pham)
                                .addGap(18, 18, 18)
                                .addComponent(Gio_hang)
                                .addGap(18, 18, 18)
                                .addComponent(Khach_hang)
                                .addGap(18, 18, 18)
                                .addComponent(Them_san_pham)
                                .addGap(18, 18, 18)
                                .addComponent(Don_hang)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                                .addComponent(Dang_Xuat)
                                .addGap(31, 31, 31))
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(732, 617));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 732, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // ... (GIỮ NGUYÊN CÁC PHƯƠNG THỨC MOUSE PRESSED)
    private void Trang_chuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Trang_chuMousePressed

        Trang_chu.setBackground(ClickedColor);
        Them_san_pham.setBackground(DefaultColor);
        Don_hang.setBackground(DefaultColor);
        Khach_hang.setBackground(DefaultColor);
        San_pham.setBackground(DefaultColor);
        Dang_Xuat.setBackground(DefaultColor);
        Gio_hang.setBackground(DefaultColor);
    }//GEN-LAST:event_Trang_chuMousePressed

    private void San_phamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_San_phamMousePressed

        Trang_chu.setBackground(DefaultColor);
        Them_san_pham.setBackground(DefaultColor);
        Don_hang.setBackground(DefaultColor);
        Khach_hang.setBackground(DefaultColor);
        San_pham.setBackground(ClickedColor);
        Dang_Xuat.setBackground(DefaultColor);
        Gio_hang.setBackground(DefaultColor);
    }//GEN-FIRST:event_San_phamMousePressed

    private void Them_san_phamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Them_san_phamMousePressed

        Trang_chu.setBackground(DefaultColor);
        Them_san_pham.setBackground(ClickedColor);
        Don_hang.setBackground(DefaultColor);
        Khach_hang.setBackground(DefaultColor);
        San_pham.setBackground(DefaultColor);
        Dang_Xuat.setBackground(DefaultColor);
        Gio_hang.setBackground(DefaultColor);
    }//GEN-LAST:event_Them_san_phamMousePressed

    private void Don_hangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Don_hangMousePressed

        Trang_chu.setBackground(DefaultColor);
        Them_san_pham.setBackground(DefaultColor);
        Don_hang.setBackground(ClickedColor);
        Khach_hang.setBackground(DefaultColor);
        San_pham.setBackground(DefaultColor);
        Dang_Xuat.setBackground(DefaultColor);
        Gio_hang.setBackground(DefaultColor);
    }//GEN-LAST:event_Don_hangMousePressed

    private void Khach_hangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Khach_hangMousePressed

        Trang_chu.setBackground(DefaultColor);
        Them_san_pham.setBackground(DefaultColor);
        Don_hang.setBackground(DefaultColor);
        Khach_hang.setBackground(ClickedColor);
        San_pham.setBackground(DefaultColor);
        Dang_Xuat.setBackground(DefaultColor);
        Gio_hang.setBackground(DefaultColor);
    }//GEN-LAST:event_Khach_hangMousePressed

    private void Dang_XuatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Dang_XuatMousePressed

        Trang_chu.setBackground(DefaultColor);
        Them_san_pham.setBackground(DefaultColor);
        Don_hang.setBackground(DefaultColor);
        Khach_hang.setBackground(DefaultColor);
        San_pham.setBackground(DefaultColor);
        Dang_Xuat.setBackground(ClickedColor);
        Gio_hang.setBackground(DefaultColor);
    }//GEN-LAST:event_Dang_XuatMousePressed

    private void Dang_XuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Dang_XuatMouseClicked
        // XÓA SESSION
        CurrentSession.clearSession();

        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);

        this.dispose();
    }//GEN-LAST:event_Dang_XuatMouseClicked

    private void Them_san_phamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Them_san_phamMouseClicked
        // Kiểm tra lại quyền truy cập trước khi mở
        if (!Them_san_pham.isVisible()) {
            JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập chức năng này!", "Lỗi Phân Quyền", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Khởi tạo và hiển thị Panel
        try {
            // Bạn cần đảm bảo class Them_san_pham đã được import nếu nó ở package khác
            Them_san_pham Them=new Them_san_pham();
            jPanel3.removeAll();
            jPanel3.add(Them).setVisible(true);

            // 🌟 THÊM HAI DÒNG NÀY ĐỂ BUỘC CONTAINER CẬP NHẬT 🌟
            jPanel3.revalidate();
            jPanel3.repaint();

        } catch (Exception e) {
            logger.severe("Lỗi khi mở Them_san_pham: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Không thể mở màn hình Thêm sản phẩm. Vui lòng kiểm tra file Them_san_pham.java.", "Lỗi Hệ Thống", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Them_san_phamMouseClicked

    private void Gio_hangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Gio_hangMousePressed

        Trang_chu.setBackground(DefaultColor);
        Them_san_pham.setBackground(DefaultColor);
        Don_hang.setBackground(DefaultColor);
        Khach_hang.setBackground(DefaultColor);
        San_pham.setBackground(DefaultColor);
        Dang_Xuat.setBackground(DefaultColor);
        Gio_hang.setBackground(ClickedColor);
    }//GEN-LAST:event_Gio_hangMousePressed

    private void Trang_chuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Trang_chuMouseClicked
        Trang_chu trangChu=new Trang_chu();
        jPanel3.removeAll();
        jPanel3.add(trangChu).setVisible(true);
        jPanel3.revalidate();
        jPanel3.repaint();
    }//GEN-LAST:event_Trang_chuMouseClicked

    private void San_phamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_San_phamMouseClicked
        San_Pham SanPham=new San_Pham();
        jPanel3.removeAll();
        jPanel3.add(SanPham).setVisible(true);
        jPanel3.revalidate();
        jPanel3.repaint();
    }//GEN-LAST:event_San_phamMouseClicked

    private void Gio_hangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Gio_hangMouseClicked
        Gio_hang GioHang=new Gio_hang();
        jPanel3.removeAll();
        jPanel3.add(GioHang).setVisible(true);
        jPanel3.revalidate();
        jPanel3.repaint();
    }//GEN-LAST:event_Gio_hangMouseClicked

    private void Khach_hangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Khach_hangMouseClicked
        Khach_hang KhachHang=new Khach_hang();
        jPanel3.removeAll();
        jPanel3.add(KhachHang).setVisible(true);
        jPanel3.revalidate();
        jPanel3.repaint();
    }//GEN-LAST:event_Khach_hangMouseClicked

    private void Don_hangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Don_hangMouseClicked
        Don_hang DonHang=new Don_hang();
        jPanel3.removeAll();
        jPanel3.add(DonHang).setVisible(true);
        jPanel3.revalidate();
        jPanel3.repaint();
    }//GEN-LAST:event_Don_hangMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dang_Xuat;
    private javax.swing.JLabel Don_hang;
    private javax.swing.JLabel Gio_hang;
    private javax.swing.JLabel Khach_hang;
    private javax.swing.JLabel San_pham;
    private javax.swing.JLabel Them_san_pham;
    private javax.swing.JLabel Trang_chu;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}