package org.example.controller;

import org.example.dao.LeaveDAO;
import org.example.model.Leave;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class LeaveController {
    private LeaveDAO leaveDAO;
    private Scanner scanner;

    public LeaveController() {
        leaveDAO = new LeaveDAO();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n==== Employee Leave Management ====");
            System.out.println("1. Apply for Leave");
            System.out.println("2. View All Leaves");
            System.out.println("3. Delete Leave");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    applyLeave();
                    break;
                case 2:
                    viewAllLeaves();
                    break;
                case 3:
                    deleteLeave();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private void applyLeave() {
        try {
            System.out.print("Enter Employee ID: ");
            int empId = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Enter Start Date (YYYY-MM-DD): ");
            Date startDate = Date.valueOf(scanner.nextLine());

            System.out.print("Enter End Date (YYYY-MM-DD): ");
            Date endDate = Date.valueOf(scanner.nextLine());

            System.out.print("Enter Reason for Leave: ");
            String reason = scanner.nextLine();

            Leave leave = new Leave(empId, startDate, endDate, reason, "Pending");

            if (leaveDAO.addLeave(leave)) {
                System.out.println("Leave applied successfully!");
            } else {
                System.out.println("Failed to apply leave.");
            }
        } catch (Exception e) {
            System.out.println("Error in applying leave: " + e.getMessage());
        }
    }

    private void viewAllLeaves() {
        List<Leave> leaves = leaveDAO.getAllLeaves();
        System.out.println("\n--- Leave Records ---");
        for (Leave leave : leaves) {
            System.out.println("Leave ID: " + leave.getId() +
                    ", Employee ID: " + leave.getEmployeeId() +
                    ", Start: " + leave.getStartDate() +
                    ", End: " + leave.getEndDate() +
                    ", Reason: " + leave.getReason());
        }
    }

    private void deleteLeave() {
        System.out.print("Enter Leave ID to delete: ");
        int leaveId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (leaveDAO.deleteLeave(leaveId)) {
            System.out.println("Leave deleted successfully.");
        } else {
            System.out.println("Failed to delete leave.");
        }
    }
}
