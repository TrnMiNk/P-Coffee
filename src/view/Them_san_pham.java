package view;

import controller.SanPhamController;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.SanPham;
import util.CurrentSession; // Import lớp Session

/**
 *
 * @author ADMIN
 */
public class Them_san_pham extends javax.swing.JInternalFrame {

    private SanPhamController sanPhamController;
    private DefaultTableModel tableModel;

    // LẤY ID CỦA NGƯỜI DÙNG HIỆN TẠI TỪ SESSION
    private int currentUserId = CurrentSession.getUserId();



    public Them_san_pham() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);

        // Khởi tạo Controller và Model
        sanPhamController = new SanPhamController();
        tableModel = (DefaultTableModel) Product_table.getModel();

        // Thêm cột ẩn ID nếu chưa có (cột thứ 5)
        if (tableModel.getColumnCount() < 6) {
            tableModel.addColumn("ID");
        }

        customizeTable();

        // TẢI DỮ LIỆU SAU KHI CÓ CONTROLLER VÀ CUSTOMIZE
        if (currentUserId > 0) {
            loadDataSanPham();
        } else {
            JOptionPane.showMessageDialog(this, "Lỗi: Không tìm thấy ID người dùng. Vui lòng đăng nhập lại.", "Lỗi Session", JOptionPane.ERROR_MESSAGE);
        }

        jTextField1.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                timKiemSanPham();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                timKiemSanPham();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                timKiemSanPham();
            }
        });
    }

    // Phương thức tải dữ liệu từ DB lên bảng
    private void loadDataSanPham() {
        tableModel.setRowCount(0); // Xóa dữ liệu cũ

        // TRUYỀN ID CỦA NGƯỜI DÙNG VÀO CONTROLLER
        List<SanPham> danhSachSP = sanPhamController.getAllSanPham(currentUserId);

        int stt = 1;
        for (SanPham sp : danhSachSP) {
            tableModel.addRow(new Object[]{
                    stt++,
                    sp.getName(),
                    sp.getLoai(),
                    sp.getGia(),
                    sp.getLinkAnh(),
                    sp.getId() // ID SẢN PHẨM (cột ẩn - index 5)
            });
        }
    }


    private void customizeTable() {
        // Ẩn cột ID (Index 5)
        Product_table.getColumnModel().getColumn(5).setMinWidth(0);
        Product_table.getColumnModel().getColumn(5).setMaxWidth(0);
        Product_table.getColumnModel().getColumn(5).setWidth(0);

        // Tăng chiều cao hàng
        Product_table.setRowHeight(35);

        // Tăng chiều rộng từng cột
        Product_table.getColumnModel().getColumn(0).setPreferredWidth(5);   // STT
        Product_table.getColumnModel().getColumn(1).setPreferredWidth(150);  // Tên sản phẩm
        Product_table.getColumnModel().getColumn(2).setPreferredWidth(20);  // loại
        Product_table.getColumnModel().getColumn(3).setPreferredWidth(60);  // giá
        Product_table.getColumnModel().getColumn(4).setPreferredWidth(200);  // link ảnh

        // (Tuỳ chọn) căn giữa nội dung cột
        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        for (int i = 0; i < Product_table.getColumnCount() - 1; i++) { // trừ 1 vì cột cuối là cột ẩn
            Product_table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // --- Đổi font và màu cho tiêu đề bảng ---
        Product_table.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        Product_table.getTableHeader().setBackground(new java.awt.Color(153,51,0));
        Product_table.getTableHeader().setForeground(Color.WHITE);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        addProduct = new javax.swing.JLabel();
        modifyProduct = new javax.swing.JLabel();
        deleteproduct = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Product_table = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(732, 617));

        jPanel1.setBackground(new java.awt.Color(153, 51, 0));

        addProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_pr.png"))); // NOI18N
        addProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addProductMouseClicked(evt);
            }
        });

        modifyProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/modify_pr.png"))); // NOI18N
        modifyProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifyProductMouseClicked(evt);
            }
        });

        deleteproduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_pr.png"))); // NOI18N
        deleteproduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteproductMouseClicked(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/954591.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excell.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(addProduct)
                                .addGap(27, 27, 27)
                                .addComponent(modifyProduct)
                                .addGap(30, 30, 30)
                                .addComponent(deleteproduct)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel7)
                                .addGap(44, 44, 44)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel5)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteproduct)
                                        .addComponent(modifyProduct)
                                        .addComponent(addProduct))
                                .addContainerGap(15, Short.MAX_VALUE))
        );

        Product_table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Product_table.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "STT", "Tên sản phẩm", "Loại", "Giá", "Link ảnh"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Product_table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(68, 68, 68)
                                                .addComponent(jLabel1)
                                                .addGap(75, 75, 75)
                                                .addComponent(jLabel6)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                                .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProductMouseClicked
        // Mở form thêm, truyền đối tượng view này (this) để gọi hàm callback
        add_Product add = new  add_Product(this);
        add.setVisible(true);
        add.pack();
        add.setLocationRelativeTo(null);
    }//GEN-LAST:event_addProductMouseClicked

    private void modifyProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyProductMouseClicked
        int selectedRow = Product_table.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần sửa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Lấy chỉ số hàng GỐC trong Model
        int modelRow = Product_table.convertRowIndexToModel(selectedRow);

        // Lấy ID Sản Phẩm từ cột ẩn cuối cùng (index 5)
        int sanPhamId = (int) tableModel.getValueAt(modelRow, 5);

        // Lấy dữ liệu hiện tại
        String name = tableModel.getValueAt(modelRow, 1).toString();
        String loai = tableModel.getValueAt(modelRow, 2).toString();
        int gia = Integer.parseInt(tableModel.getValueAt(modelRow, 3).toString());
        String link = tableModel.getValueAt(modelRow, 4).toString();

        // Tạo đối tượng SanPham VỚI CẢ ID VÀ USER_ID
        SanPham sp = new SanPham(sanPhamId, name, loai, gia, link, currentUserId);

        add_Product formEdit = new add_Product(this);
        formEdit.setEditData(sp, modelRow);
        formEdit.setVisible(true);
        formEdit.pack();
        formEdit.setLocationRelativeTo(null);
    }//GEN-LAST:event_modifyProductMouseClicked

    private void deleteproductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteproductMouseClicked
        int selectedRow = Product_table.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sản phẩm này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            // Lấy chỉ số hàng GỐC trong Model 
            int modelRow = Product_table.convertRowIndexToModel(selectedRow);

            // Lấy ID Sản Phẩm từ cột ẩn (index 5)
            int sanPhamId = (int) tableModel.getValueAt(modelRow, 5);

            // GỌI CONTROLLER VỚI ID SẢN PHẨM VÀ ID USER
            if (sanPhamController.deleteSanPham(sanPhamId, currentUserId)) {
                JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                loadDataSanPham(); // Tải lại dữ liệu
            } else {
                JOptionPane.showMessageDialog(this, "Xóa sản phẩm thất bại! (Lỗi DB hoặc không có quyền)", "Lỗi DB", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteproductMouseClicked


    /**
     * Phương thức được gọi từ form add_Product sau khi THÊM thành công vào DB
     * @param sp Đối tượng SanPham đã thêm
     */
    public void themSanPham(SanPham sp) {
        // GÁN USER ID VÀO ĐỐI TƯỢNG TRƯỚC KHI THÊM
        sp.setUser_id(currentUserId);

        if (sanPhamController.addSanPham(sp)) {
            loadDataSanPham(); // Tải lại dữ liệu để cập nhật ID mới và STT
        } else {
            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thất bại!", "Lỗi DB", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Phương thức được gọi từ form add_Product sau khi SỬA thành công vào DB
     * @param sp Đối tượng SanPham đã sửa
     * @param row Chỉ số hàng GỐC (model index) đã được sửa
     */
    public void suaSanPham(SanPham sp, int row) {
        // GÁN USER ID VÀO ĐỐI TƯỢNG TRƯỚC KHI SỬA
        sp.setUser_id(currentUserId);

        if (sanPhamController.updateSanPham(sp)) {
            loadDataSanPham(); // Tải lại dữ liệu để cập nhật
        } else {
            JOptionPane.showMessageDialog(this, "Sửa sản phẩm thất bại!", "Lỗi DB", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void capNhatSTT() {
        // Hàm này không cần thiết nếu bạn dùng loadDataSanPham()
        // Nhưng nếu bạn muốn cập nhật STT khi xóa/sửa mà không tải lại toàn bộ:
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            tableModel.setValueAt(i + 1, i, 0); // cập nhật lại STT theo thứ tự
        }
    }


    private void timKiemSanPham() {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        Product_table.setRowSorter(sorter);

        String keyword = jTextField1.getText().trim();
        if (keyword.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            // Lọc theo cột 'Tên sản phẩm' (index 1) hoặc 'Loại' (index 2)
            RowFilter<Object, Object> filter = RowFilter.regexFilter("(?i)" + keyword, 1, 2);
            sorter.setRowFilter(filter);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Product_table;
    private javax.swing.JLabel addProduct;
    private javax.swing.JLabel deleteproduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel modifyProduct;
    // End of variables declaration//GEN-END:variables
}