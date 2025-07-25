CREATE DATABASE IF NOT EXISTS employee_leave_db;

USE employee_leave_db;

CREATE TABLE IF NOT EXISTS employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    department VARCHAR(100),
    join_date DATE
);
