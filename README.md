# 📚 Library Management System

<p align="center">

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Jakarta Servlet](https://img.shields.io/badge/Jakarta_Servlet-6.1-005C8A?style=for-the-badge&logo=eclipse&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-9.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Bootstrap](https://img.shields.io/badge/Bootstrap-5.3.2-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Tomcat](https://img.shields.io/badge/Tomcat-11-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black)

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

## 🛠 Tech Stack

| Category | Technologies |
|----------|--------------|
| Language | Java 17 |
| Backend | Jakarta Servlet 6.1, JSP, JSTL |
| Frontend | HTML5, CSS3, JavaScript (ES6), Bootstrap 5 |
| Database | MySQL, JDBC (MySQL Connector/J 9.0.0) |
| Architecture | MVC + DAO |
| Build Tool | Maven |
| Server | Apache Tomcat 11 |

---

## 📋 Prerequisites

Before running the project, ensure the following software is installed:

- Java JDK 17 or higher
- Apache Maven
- Apache Tomcat 11
- MySQL Server 8.0 or higher
- MySQL Workbench *(optional, for database management)*

---

## 📂 Project Structure

```text
Library-Management-System
│
├── database/
│   └── db.sql
│
├── libraryapp/
│   ├── src/main/
│   │   ├── java/com/lms/
│   │   │   ├── controller/
│   │   │   ├── dao/
│   │   │   ├── service/
│   │   │   ├── filter/
│   │   │   ├── pojo/
│   │   │   └── util/
│   │   │
│   │   └── webapp/
│   │       ├── assets/
│   │       ├── jsp/
│   │       └── WEB-INF/
│   │
│   ├── pom.xml
│   └── target/
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
