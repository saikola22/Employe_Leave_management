package org.example;

import org.example.dao.EmployeeDAO;
import org.example.dao.LeaveDAO;
import org.example.model.Employee;
import org.example.model.Leave;
import org.example.controller.LeaveController;
import org.example.controller.AdminController;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        LeaveDAO leaveDAO = new LeaveDAO();
        LeaveController leaveController = new LeaveController();
        AdminController adminController = new AdminController();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Employee Leave Management ====");
            System.out.println("1. Apply for Leave");
            System.out.println("2. View All Leaves");
            System.out.println("3. Delete Leave");
            System.out.println("4. Exit");
            System.out.println("5. View Leave Requests with Status");
            System.out.println("6. Approve Leave");
            System.out.println("7. Reject Leave");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Apply for leave
                    System.out.print("Enter Employee ID: ");
                    int empId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Start Date (YYYY-MM-DD): ");
                    Date start = Date.valueOf(sc.nextLine());
                    System.out.print("Enter End Date (YYYY-MM-DD): ");
                    Date end = Date.valueOf(sc.nextLine());
                    System.out.print("Enter Reason: ");
                    String reason = sc.nextLine();

                    Leave leave = new Leave(0, empId, start, end, reason, "Pending");
                    boolean success = leaveDAO.addLeave(leave);
                    System.out.println(success ? "Leave applied successfully!" : "Failed to apply leave.");
                    break;

                case 2: // View all leaves (basic)
                    List<Leave> leaves = leaveDAO.getAllLeaves();
                    System.out.println("--- Leave Records ---");
                    for (Leave l : leaves) {
                        System.out.println(l.getId() + " | EmpID: " + l.getEmployeeId() + " | " +
                                l.getStartDate() + " to " + l.getEndDate() + " | " +
                                l.getReason() + " | Status: " + l.getStatus());
                    }
                    break;

                case 3: // Delete leave
                    System.out.print("Enter Leave ID to delete: ");
                    int deleteId = sc.nextInt();
                    boolean deleted = leaveDAO.deleteLeave(deleteId);
                    System.out.println(deleted ? "Leave deleted successfully." : "Failed to delete leave.");
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                case 5: // View all leave requests with status
                    List<Leave> all = leaveDAO.getAllLeaves();
                    System.out.println("--- Leave Requests ---");
                    for (Leave l : all) {
                        System.out.println("Leave ID: " + l.getId() +
                                " | Employee ID: " + l.getEmployeeId() +
                                " | " + l.getStartDate() + " to " + l.getEndDate() +
                                " | Reason: " + l.getReason() +
                                " | Status: " + l.getStatus());
                    }
                    break;

                case 6: // Approve leave
                    System.out.print("Enter Leave ID to approve: ");
                    int approveId = sc.nextInt();
                    adminController.approveLeave(approveId);
                    break;

                case 7: // Reject leave
                    System.out.print("Enter Leave ID to reject: ");
                    int rejectId = sc.nextInt();
                    adminController.rejectLeave(rejectId);
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
