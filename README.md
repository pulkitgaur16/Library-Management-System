# 📚 Library Management System

<p align="center">

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![Jakarta EE](https://img.shields.io/badge/Jakarta%20EE-11-red?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-8-blue?style=for-the-badge&logo=mysql)
![Bootstrap](https://img.shields.io/badge/Bootstrap-5-purple?style=for-the-badge&logo=bootstrap)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven)
![Tomcat](https://img.shields.io/badge/Tomcat-11-yellow?style=for-the-badge&logo=apachetomcat)

</p>

<p align="center">
A full-stack enterprise web application built using <b>Java, Jakarta EE, JSP, Servlets, JDBC, MySQL and Bootstrap</b> to automate library operations including book management, member registration and transaction tracking.
</p>

---

## 📖 About

This project demonstrates my understanding of Java web application development, including MVC architecture, JDBC, Servlets, JSP, MySQL integration, and responsive UI design. It serves as a practical implementation of enterprise application development concepts.

---


# 🚀 Features

### 📊 Dashboard
- View total books
- Monitor registered users
- Track issued books
- View returned books
- Clean statistics cards for quick insights

### 📚 Book Management
- Add new books
- View available inventory
- Maintain complete catalog
- Store author and publication details

### 👤 Member Management
- Register new members
- Client-side form validation
- Store complete member information
- Prevent invalid submissions

### 🔄 Book Transactions
- Issue books
- Return books
- Automatic due date calculation
- Track issued books

### 📅 Status Tracking
- Active
- Due Today
- Overdue

### 🔒 Security & Reliability
- Authentication filters
- JDBC Prepared Statements
- Null-safe validation
- Transaction handling
- MVC Architecture
- DAO Pattern

---

# 🛠 Tech Stack

| Category | Technologies |
|----------|--------------|
| Language | Java 17 |
| Backend | Jakarta EE 11, Servlets, JSP, JSTL |
| Frontend | HTML5, CSS3, JavaScript, Bootstrap 5 |
| Database | MySQL, JDBC |
| Architecture | MVC + DAO |
| Build Tool | Maven |
| Server | Apache Tomcat 11 |

---

# 📂 Project Structure

```
Library-Management-System
│
├── src/
│   ├── controller/
│   ├── dao/
│   ├── model/
│   ├── util/
│   ├── filter/
│   └── webapp/
│
├── database/
│   └── db.sql
│
├── target/
│
├── pom.xml
│
└── README.md
```

---

# ⚙️ Installation

## 1️⃣ Clone Repository

```bash
git clone https://github.com/pulkitgaur16/Library-Management-System.git

cd Library-Management-System
```

---

## 2️⃣ Create Database

Create a MySQL database.

```sql
CREATE DATABASE library_db;
```

Execute

```
database/db.sql
```

to create all required tables.

---

## 3️⃣ Configure Database

Update your JDBC connection details inside the database utility class.

```java
URL = jdbc:mysql://localhost:3306/library_db

Username = your_username

Password = your_password
```

---

## 4️⃣ Build Project

```bash
mvn clean package
```

This generates a `.war` file inside:

```
target/
```

---

## 5️⃣ Deploy

Copy the generated WAR file into

```
Tomcat/webapps/
```

Start Apache Tomcat.

Open

```
http://localhost:8080/libraryapp
```

---

## 🔑 Demo Credentials

Use the following administrator account to access the application after setup.

| Field | Value |
|-------|-------|
| **Username** | `admin@library.com` |
| **Password** | `admin123` |

> **Note:** This project currently supports a single administrator account for managing library operations. Additional authentication and role-based access can be implemented in future enhancements.

# 📸 Screenshots

## Dashboard

> Replace with your own screenshot

```
assets/dashboard.png
```

---

## Add Member

```
assets/add-member.png
```

---

## Issue Book

```
assets/issue-book.png
```

---

## Return Book

```
assets/return-book.png
```

---

## 🚀 Future Enhancements

- Secure Admin Authentication
- Advanced Search & Filtering
- Email Notifications
- Fine Calculation for Late Returns
- REST API Integration

---

# 🧠 Concepts Used

- MVC Architecture
- DAO Pattern
- Object-Oriented Programming
- JDBC
- Servlets
- JSP
- JSTL
- HTTP Filters
- Prepared Statements
- Exception Handling
- Form Validation

---

# 📈 Project Highlights

✔ Enterprise Architecture

✔ Responsive UI

✔ Clean Code Structure

✔ Secure Database Operations

✔ Maven Build Management

✔ Reusable DAO Layer

✔ Authentication Filters

✔ Bootstrap Responsive Design
