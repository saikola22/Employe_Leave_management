# Employee Leave Management System

## 🛠 Tech Stack
- Java (JDK 17)
- MySQL
- JDBC

## 📌 Description
A simple Java-based Employee Leave Management System that allows HR/Admins to store employee details and manage their leave records. It uses JDBC to interact with a MySQL database.

## 💡 Features
- Add new employee records
- Connects to MySQL using JDBC
- Clean code with DAO pattern
- Modular and extensible

## 🗃 Database Structure
```sql
CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    department VARCHAR(100),
    join_date DATE
);
