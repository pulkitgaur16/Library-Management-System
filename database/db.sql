CREATE DATABASE IF NOT EXISTS library_db DEFAULT CHARACTER SET utf8mb4;
USE library_db;

CREATE TABLE IF NOT EXISTS users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(120) NOT NULL UNIQUE,
    password VARCHAR(255),
    role VARCHAR(20) NOT NULL DEFAULT 'USER',
    phone_no VARCHAR(120) NOT NULL,
    address text(250),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- insert an default admin user
INSERT INTO users (first_name, last_name, email, password, role, phone_no)
VALUES ('Admin', 'test', 'admin@library.com', 'admin123', 'ADMIN', "84848454545")
ON DUPLICATE KEY UPDATE email = email;

SELECT*FROM users;