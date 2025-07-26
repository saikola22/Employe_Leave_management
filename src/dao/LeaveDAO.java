package org.example.dao;

import org.example.util.DBConnection;
import org.example.model.Leave;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeaveDAO {
    private static final String INSERT_LEAVE =
            "INSERT INTO employee_leave (employee_id, start_date, end_date, reason, status) VALUES (?, ?, ?, ?, ?)";

    private static final String GET_ALL_LEAVES = "SELECT * FROM employee_leave";
    private static final String DELETE_LEAVE = "DELETE FROM employee_leave WHERE id = ?";

    public boolean addLeave(Leave leave) {
        try (Connection conn = DBConnection.getConnection();  // ✅ Removed argument
             PreparedStatement stmt = conn.prepareStatement(INSERT_LEAVE)) {

            stmt.setInt(1, leave.getEmployeeId());
            stmt.setDate(2, leave.getStartDate());
            stmt.setDate(3, leave.getEndDate());
            stmt.setString(4, leave.getReason());
            stmt.setString(5, "Pending");

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error adding leave: " + e.getMessage());
            return false;
        }
    }

    public List<Leave> getAllLeaves() {
        List<Leave> leaves = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();  // ✅ Removed argument
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(GET_ALL_LEAVES)) {

            while (rs.next()) {
                Leave leave = new Leave(
                        rs.getInt("id"),
                        rs.getInt("employee_id"),
                        rs.getDate("start_date"),
                        rs.getDate("end_date"),
                        rs.getString("reason"),
                        rs.getString("status")
                );
                leaves.add(leave);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving leaves: " + e.getMessage());
        }
        return leaves;
    }

    public boolean deleteLeave(int leaveId) {
        try (Connection conn = DBConnection.getConnection();  // ✅ Removed argument
             PreparedStatement stmt = conn.prepareStatement(DELETE_LEAVE)) {

            stmt.setInt(1, leaveId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting leave: " + e.getMessage());
            return false;
        }
    }

    public boolean updateLeaveStatus(int leaveId, String status) {
        String sql = "UPDATE employee_leave SET status = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);
            stmt.setInt(2, leaveId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
