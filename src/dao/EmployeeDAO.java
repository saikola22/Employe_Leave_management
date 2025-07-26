package org.example.dao;


import org.example.model.Employee;
import org.example.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
public class EmployeeDAO {
    private Connection conn;

    public EmployeeDAO() {
        conn = DBConnection.getConnection();
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String query = "SELECT * FROM employee";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getString("position"),
                        rs.getDouble("salary"),
                        rs.getDate("join_date")
                );
                list.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Add an employee
    public boolean addEmployee(Employee emp) {
        String query = "INSERT INTO employee (name, department, position, salary, join_date) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getDepartment());
            stmt.setString(3, emp.getPosition());
            stmt.setDouble(4, emp.getSalary());
            stmt.setDate(5, emp.getJoinDate());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update an employee
    public boolean updateEmployee(Employee emp) {
        String query = "UPDATE employee SET name=?, department=?, position=?, salary=?, join_date=? WHERE id=?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getDepartment());
            stmt.setString(3, emp.getPosition());
            stmt.setDouble(4, emp.getSalary());
            stmt.setDate(5, emp.getJoinDate());
            stmt.setInt(6, emp.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete an employee
    public boolean deleteEmployee(int id) {
        String query = "DELETE FROM employee WHERE id=?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get employee by ID
    public Employee getEmployeeById(int id) {
        String query = "SELECT * FROM employee WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getString("position"),
                        rs.getDouble("salary"),
                        rs.getDate("join_date")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

