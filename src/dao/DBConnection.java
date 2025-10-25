package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Lớp tĩnh dùng để quản lý và cung cấp đối tượng Connection đến SQL Server Database.
 */
public class DBConnection {

    // THÔNG TIN KẾT NỐI CHO SQL SERVER

    // Địa chỉ: localhost hoặc tên máy chủ SQL Server instance (VD: localhost\SQLEXPRESS)
    // Cổng mặc định: 1433
    // databaseName: Tên database của bạn (VD: quanlyapp)
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=quanlyapp;encrypt=false;trustServerCertificate=true;";

    // Tên người dùng và mật khẩu SQL Server
    private static final String USER = "sa"; // User mặc định phổ biến là 'sa'
    private static final String PASSWORD = "123456"; // THAY THẾ bằng mật khẩu của bạn

    // Nếu bạn dùng Windows Authentication (chỉ dùng tài khoản Windows, không cần User/Pass)
    // private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=quanlyapp;integratedSecurity=true;";
    // private static final String USER = "";
    // private static final String PASSWORD = "";

    private static final Logger LOGGER = Logger.getLogger(DBConnection.class.getName());

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // DRIVER CHO SQL SERVER
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Kết nối
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Lỗi: Không tìm thấy SQL Server JDBC Driver. Đảm bảo bạn đã thêm file mssql-jdbc.jar vào Libraries!", e);

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Lỗi kết nối CSDL SQL Server: Sai thông tin URL/User/Password hoặc SQL Server chưa chạy.", e);
            LOGGER.log(Level.SEVERE, "Chi tiết lỗi SQL: " + e.getMessage());

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Lỗi không xác định khi kết nối CSDL.", e);
        }
        return conn;
    }
}