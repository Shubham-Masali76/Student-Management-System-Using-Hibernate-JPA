# Student Management System

The **Student Management System** is a console-based application built using **Core Java**, **Hibernate JPA**, and **PostgreSQL**. It allows users to perform CRUD (Create, Read, Update, Delete) operations on student records stored in a PostgreSQL database. The application is fully menu-driven, includes multithreaded logging to a `.log` file, and implements strict input validation for cleaner, safer data.

---

## Features

- Add, View, Update, and Delete student records
- Hibernate JPA integration with PostgreSQL
- Multithreaded logging with timestamps saved to `student.log`
- Input validation (email, phone, marks, etc.)
- Menu-driven console interface
- Clean architecture using DAO and POJO
- Maven-based project structure

---

## Technologies Used

- **Java 17 or 17+**
- **PostgreSQL 15+**
- **Hibernate JPA (latest and stable version)**
- **Apache Maven 3.8.6+**
- **Jakarta Persistence 3.1**
- **Multithreading & File I/O**

---

## Dependency

```xml
<dependencies>

    <dependency>
        <groupId>org.hibernate.orm</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>7.0.5.Final</version>
    </dependency>

    <dependency>
        <groupId>jakarta.persistence</groupId>
        <artifactId>jakarta.persistence-api</artifactId>
        <version>3.2.0</version>
    </dependency>

    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.7.7</version>
    </dependency>

</dependencies>
```

---

# Java Persistence API Configuration (persistence.xml file in resources > META-INF)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="https://jakarta.ee/xml/ns/persistence"
             version="3.0">
  <persistence-unit name="student-unit" transaction-type="RESOURCE_LOCAL">
    <class>com.shubham.student.Student</class>
    <properties>
      <property name="jakarta.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/studentdb"/>
      <property name="jakarta.persistence.jdbc.user" value="postgres"/>
      <property name="jakarta.persistence.jdbc.password" value="3546"/>
      <property name="jakarta.persistence.jdbc.driver" value="org.postgresql.Driver"/>
      <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQLDialect"/>
      <property name="hibernate.hbm2ddl.auto" value="update"/>
      <property name="hibernate.show_sql" value="false"/>
      <property name="hibernate.format_sql" value="false"/>
    </properties>
  </persistence-unit>
</persistence>
```

---


## Prerequisites

Ensure the following are installed:

- **Java JDK 17 or 17+**
- **Apache Maven 3.8.6+**
- **PostgreSQL 15+**

---

## Database Setup

1. Create a Database

- **CREATE DATABASE studentdb;**

2. Create a Table

- **CREATE TABLE students (id SERIAL PRIMARY KEY, name VARCHAR(100) NOT NULL, course VARCHAR(100) NOT NULL, marks INT NOT NULL, email VARCHAR(100), phone VARCHAR(20));**

---

## Project Structure

com/shubham/student/
├── Student.java # Entity/Model class
├── StudentDAO.java # DAO with Hibernate logic
├── DBLogging.java # Multithreaded logger
├── MenuApp.java # Menu-driven UI and main class
└── persistence.xml # JPA configuration file (inside resources/META-INF)

---

## How to Run

1. Clone the repo or download the ZIP.
2. Open the project in VS Code, IntelliJ, or Eclipse.
3. Make sure PostgreSQL is running and DB is created.
4. Update DB credentials in persistence.xml under:
   <property name="jakarta.persistence.jdbc.user" value="postgres"/>
   <property name="jakarta.persistence.jdbc.password" value="yourpassword"/>
5. Open terminal and run:
   mvn clean install
6. Run MenuApp.java

---

## Log Output

- \*\*Logs are saved in student-actions.log with timestamps like:

[2025-07-13 14:23:02] Student added: Shubham
[2025-07-13 14:26:45] Retrieved all students from DB.
[2025-07-13 14:29:02] Retrieved all students from DB.
[2025-07-13 14:43:29] Retrieved all students from DB.
[2025-07-13 14:43:56] Deleted student ID: 3
[2025-07-13 14:43:58] Deleted student ID: 4
[2025-07-13 14:44:00] Retrieved all students from DB.
[2025-07-13 14:44:20] Student found by ID: 1
[2025-07-13 14:44:44] Updated student ID: 1
[2025-07-13 14:44:46] Retrieved all students from DB.
[2025-07-13 14:44:53] Student found by ID: 1

Logging is done on a separate thread so it doesn't interrupt user interaction.\*\*

---

## Input Validations

- **Name: Cannot be empty**
- **Course: Cannot be empty**
- **Marks: Must be between 0 and 100**
- **Email: Must match email pattern**
- **Phone: Must be 10-digit number**
- **ID: Must be a positive integer**

---

## Contact

- **Developer: Shubham Santosh Masali**
- **Email: shubhammasali76@gmail.com**
- **GitHub: Shubham-Masali76**

- **Feel free to fork this project and make it your own. Contributions, suggestions, and ideas are always welcome!**

** Happy Coding **
