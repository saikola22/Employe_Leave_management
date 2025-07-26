package org.example.controller;

import org.example.dao.LeaveDAO;

public class AdminController {

    LeaveDAO dao = new LeaveDAO();

    public void approveLeave(int leaveId) {
        if (dao.updateLeaveStatus(leaveId, "Approved")) {
            System.out.println("Leave approved successfully.");
        } else {
            System.out.println("Failed to approve leave.");
        }
    }

    public void rejectLeave(int leaveId) {
        if (dao.updateLeaveStatus(leaveId, "Rejected")) {
            System.out.println("Leave rejected successfully.");
        } else {
            System.out.println("Failed to reject leave.");
        }
    }
}
