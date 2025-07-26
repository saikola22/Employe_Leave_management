# 🗂️ Employee Leave Management System

The **Employee Leave Management System** is a Java-based backend application that helps organizations manage employee leave requests efficiently. It supports applying for leave, viewing and deleting leave records, and includes an **admin approval/rejection workflow** — all through a simple **console interface** and **MySQL backend**.

---

## ✅ Features

-  **Employee Leave Application**
-  **View All Leave Requests**
-  **Delete Leave Entries**
-  **Admin Approval/Rejection of Leaves**
-  **Track Leave Status**: Pending, Approved, Rejected

---

## 🛠️ Tech Stack

- **Java 21**
- **MySQL**
- **JDBC (Java Database Connectivity)**
- **Maven**
- **IntelliJ IDEA** (or any Java IDE)

---

## 🧠 Core Concepts Demonstrated

- JDBC CRUD operations (`INSERT`, `SELECT`, `DELETE`, `UPDATE`)
- SQL Table Relationships and Foreign Keys
- Modular design (Model, DAO, Controller)
- Console-based input handling
- Status-based filtering and updates
- Real-world backend logic without a UI

---

## 🗃️ Database Schema

```sql
CREATE TABLE leave_requests (
  leave_id INT AUTO_INCREMENT PRIMARY KEY,
  employee_id INT NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  reason VARCHAR(255),
  status VARCHAR(20) DEFAULT 'Pending',
  FOREIGN KEY (employee_id) REFERENCES employee(id)
);
