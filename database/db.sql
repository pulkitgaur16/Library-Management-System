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

CREATE TABLE IF NOT EXISTS books (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(250) NOT NULL,
    author VARCHAR(250) NOT NULL,
    category VARCHAR(120),
    isbn VARCHAR(30),
    publisher VARCHAR(250),
    total_copies INT NOT NULL,
    available_copies INT NOT NULL,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

SELECT*FROM books;

CREATE TABLE IF NOT EXISTS book_issued (
    issue_id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT NOT NULL,
    user_id INT NOT NULL,
    issue_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    due_date TIMESTAMP NULL,
    return_date TIMESTAMP NULL,
    status VARCHAR(50) NOT NULL,
    book_condition VARCHAR(1024),
    assignment_notes VARCHAR(1024),
    return_notes VARCHAR(1024),
    CONSTRAINT fk_book FOREIGN KEY (book_id) REFERENCES books(book_id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);

SELECT*FROM book_issued;