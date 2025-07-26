package org.example.model;

import java.sql.Date;

public class Leave {
    private int id;
    private int employeeId;
    private Date startDate;
    private Date endDate;
    private String reason;
    private String status;

    // Constructor with ID (for reading from DB)
    public Leave(int id, int employeeId, Date startDate, Date endDate, String reason, String status) {
        this.id = id;
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.status = status;
    }

    // Constructor without ID (for inserting into DB)
    public Leave(int employeeId, Date startDate, Date endDate, String reason,String status) {
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.status=status;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getReason() {
        return reason;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
