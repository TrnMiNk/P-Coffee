package view;

import controller.KhachHangController;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import util.CurrentSession;

/**
 *
 * @author ADMIN
 */
public class Khach_hang extends javax.swing.JInternalFrame {

    private KhachHangController khachHangController;
    private DefaultTableModel tableModel;

    // LẤY ID CỦA NGƯỜI DÙNG HIỆN TẠI TỪ SESSION
    private int currentUserId = CurrentSession.getUserId();


    public Khach_hang() {
        initComponents();
        // Loại bỏ đường viền tiêu đề của JInternalFrame
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);

        khachHangController = new KhachHangController();
        tableModel = (DefaultTableModel) Person_table.getModel();

        // Thêm cột ẩn ID nếu chưa có (cột thứ 5)
        if (tableModel.getColumnCount() < 5) {
            tableModel.addColumn("ID");
        }

        customizeTable();

        // KIỂM TRA USER ID TRƯỚC KHI TẢI DỮ LIỆU
        if (currentUserId > 0) {
            loadDataKhachHang();
        } else {
            // Hiển thị lỗi nếu chưa đăng nhập
            JOptionPane.showMessageDialog(this, "Lỗi: Không tìm thấy ID người dùng. Vui lòng đăng nhập lại.", "Lỗi Session", JOptionPane.ERROR_MESSAGE);
        }

        // Thêm DocumentListener cho ô tìm kiếm
        jTextField2.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                timKiemKhachHang();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                timKiemKhachHang();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                timKiemKhachHang();
            }
        });
    }

    // Phương thức tải dữ liệu từ DB lên bảng
    private void loadDataKhachHang() {
        tableModel.setRowCount(0); // Xóa dữ liệu cũ

        // TRUYỀN ID CỦA NGƯỜI DÙNG VÀO CONTROLLER
        List<KhachHang> danhSachKH = khachHangController.getAllKhachHang(currentUserId);

        int stt = 1;
        for (KhachHang kh : danhSachKH) {
            tableModel.addRow(new Object[]{
                    stt++,
                    kh.getName(),
                    kh.getSdt(),
                    kh.getSl(),
                    kh.getId() // ID KHÁCH HÀNG (cột ẩn - index 4)
            });
        }
    }

    private void customizeTable() {
        // Thiết lập cột ẩn ID
        Person_table.getColumnModel().getColumn(4).setMinWidth(0);
        Person_table.getColumnModel().getColumn(4).setMaxWidth(0);
        Person_table.getColumnModel().getColumn(4).setWidth(0);

        // Tăng chiều cao hàng
        Person_table.setRowHeight(35);

        // Tăng chiều rộng từng cột
        Person_table.getColumnModel().getColumn(0).setPreferredWidth(50);   // STT
        Person_table.getColumnModel().getColumn(1).setPreferredWidth(200);  // Họ và tên
        Person_table.getColumnModel().getColumn(2).setPreferredWidth(150);  // SĐT
        Person_table.getColumnModel().getColumn(3).setPreferredWidth(180);  // Số lượng

        // (Tuỳ chọn) căn giữa nội dung cột
        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        for (int i = 0; i < Person_table.getColumnCount() - 1; i++) { // trừ 1 vì cột cuối là cột ẩn
            Person_table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // --- Đổi font và màu cho tiêu đề bảng ---
        Person_table.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        Person_table.getTableHeader().setBackground(new java.awt.Color(153,51,0));
        Person_table.getTableHeader().setForeground(Color.WHITE);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        add_per = new javax.swing.JLabel();
        modify_per = new javax.swing.JLabel();
        delete_per = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Person_table = new javax.swing.JTable();

        jTextField1.setText("jTextField1");

        jLabel1.setText("jLabel1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        setPreferredSize(new java.awt.Dimension(732, 617));

        jPanel1.setBackground(new java.awt.Color(153, 51, 0));

        add_per.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_p.png"))); // NOI18N
        add_per.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_perMouseClicked(evt);
            }
        });

        modify_per.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/modify_p.png"))); // NOI18N
        modify_per.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modify_perMouseClicked(evt);
            }
        });

        delete_per.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_p.png"))); // NOI18N
        delete_per.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delete_perMouseClicked(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/954591.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excell.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(add_per)
                                .addGap(29, 29, 29)
                                .addComponent(modify_per)
                                .addGap(33, 33, 33)
                                .addComponent(delete_per)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(34, 34, 34)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(16, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel8)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(modify_per)
                                                .addComponent(add_per, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(delete_per))
                                        .addComponent(jLabel2))
                                .addGap(13, 13, 13))
        );

        Person_table.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Person_table.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "STT", "Họ và tên", "SĐT", "Số lượng sản phẩm"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Person_table);
        if (Person_table.getColumnModel().getColumnCount() > 0) {
            Person_table.getColumnModel().getColumn(0).setResizable(false);
            Person_table.getColumnModel().getColumn(1).setResizable(false);
            Person_table.getColumnModel().getColumn(2).setResizable(false);
            Person_table.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel3))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(98, 98, 98)
                                                .addComponent(jLabel3)
                                                .addGap(71, 71, 71)
                                                .addComponent(jLabel7)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                                .addContainerGap())))
        );

        pack();
    }// </editor-fold>

    private void add_perMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_perMouseClicked
        // Mở form thêm, truyền đối tượng Khach_hang này (this) để gọi hàm callback
        add_person add = new add_person(this);
        add.setVisible(true);
        add.pack();
        add.setLocationRelativeTo(null);
    }//GEN-LAST:event_add_perMouseClicked

    private void delete_perMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_perMouseClicked
        int selectedRow = Person_table.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng cần xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa khách hàng này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            int modelRow = Person_table.convertRowIndexToModel(selectedRow);
            int khachHangId = (int) tableModel.getValueAt(modelRow, 4);

            // TRUYỀN CẢ ID KHÁCH HÀNG VÀ ID USER để xóa
            if (khachHangController.deleteKhachHang(khachHangId, currentUserId)) {
                JOptionPane.showMessageDialog(this, "Xóa khách hàng thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                loadDataKhachHang();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa khách hàng thất bại! (Lỗi DB hoặc không có quyền)", "Lỗi DB", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_delete_perMouseClicked

    private void modify_perMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modify_perMouseClicked
        int selectedRow = Person_table.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng cần sửa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int modelRow = Person_table.convertRowIndexToModel(selectedRow);

        int khachHangId = (int) tableModel.getValueAt(modelRow, 4);

        String name = tableModel.getValueAt(modelRow, 1).toString();
        String sdt = tableModel.getValueAt(modelRow, 2).toString();
        int sl = Integer.parseInt(tableModel.getValueAt(modelRow, 3).toString());

        // TẠO ĐỐI TƯỢNG KhachHang VỚI CẢ ID VÀ USER_ID
        KhachHang kh = new KhachHang(khachHangId, name, sdt, sl, currentUserId);

        add_person formEdit = new add_person(this);
        // Truyền đối tượng KhachHang (đã có ID và USER_ID) và chỉ số hàng GỐC
        formEdit.setEditData(kh, modelRow);
        formEdit.setVisible(true);
        formEdit.pack();
        formEdit.setLocationRelativeTo(null);
    }//GEN-LAST:event_modify_perMouseClicked


    /**
     * Phương thức được gọi từ form add_person sau khi THÊM thành công vào DB
     * @param kh Đối tượng KhachHang đã thêm (chỉ cần name, sdt, sl)
     */
    public void themKhachHang(KhachHang kh) {
        // GÁN USER ID VÀO ĐỐI TƯỢNG TRƯỚC KHI THÊM
        kh.setUser_id(currentUserId);

        if (khachHangController.addKhachHang(kh)) {
            loadDataKhachHang();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại!", "Lỗi DB", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Phương thức được gọi từ form add_person sau khi SỬA thành công vào DB
     * @param kh Đối tượng KhachHang đã sửa (chỉ cần id, name, sdt, sl)
     * @param row Chỉ số hàng GỐC (model index) đã được sửa
     */
    public void suaKhachHang(KhachHang kh, int row) {
        // GÁN USER ID VÀO ĐỐI TƯỢNG TRƯỚC KHI SỬA
        kh.setUser_id(currentUserId);

        if (khachHangController.updateKhachHang(kh)) {
            loadDataKhachHang();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa khách hàng thất bại!", "Lỗi DB", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Đã xóa phương thức capNhatSTT() vì loadDataKhachHang() đã tự động cập nhật STT.

    private void timKiemKhachHang() {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        Person_table.setRowSorter(sorter);

        String keyword = jTextField2.getText().trim();
        if (keyword.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            // Lọc theo cột 'Họ và tên' (index 1) hoặc 'SĐT' (index 2)
            RowFilter<Object, Object> nameFilter = RowFilter.regexFilter("(?i)" + keyword, 1, 2);
            sorter.setRowFilter(nameFilter);
        }
    }


    // Variables declaration - do not modify
    private javax.swing.JTable Person_table;
    private javax.swing.JLabel add_per;
    private javax.swing.JLabel delete_per;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.GroupLayout jPanel3Layout;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel modify_per;
    // End of variables declaration
}