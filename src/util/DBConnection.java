package util;

import java.sql.*;

public class DBConnection {
    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn != null) return conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employee_leave_db",
                "root", "your_password"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
