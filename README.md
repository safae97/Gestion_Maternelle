# 🎓 Kindergarten Attendance Management 🏫

Welcome to the **Kindergarten Attendance Management** project! This application is designed to manage the attendance of students in a kindergarten using a **Spring Boot** backend and an **Angular** frontend. The project leverages **Spring Data**, **Spring MVC**, **Spring IOC**, and **JPA** with **Hibernate** for database interactions.

## 🛠️ Tools & Technologies Used

- **Backend**: 
  - Spring Boot
  - Spring Data JPA
  - Hibernate
  - MySQL
  - Maven
- **Frontend**: 
  - Angular
- **IDE**: 
  - IntelliJ IDEA
- **Other Tools**: 
  - Spring Boot Initializer

## 📋 Project Overview

The application allows the management of student attendance records in a kindergarten. It provides CRUD operations for both students and their attendance records.

### Key Features:
- **Student Management**: Add, update, delete, and view student details.
- **Attendance Management**: Record and manage attendance for each student.
- **RESTful API**: Exposes endpoints for CRUD operations.
- **Angular Frontend**: Provides a user-friendly interface for managing students and attendance.

## 📂 Project Structure

The project is divided into several layers:

1. **Entities**: JPA entities representing the data model.
2. **Repository**: Interfaces for database operations using Spring Data JPA.
3. **Service**: Business logic layer with interfaces and implementations.
4. **Controller**: REST controllers to handle HTTP requests.
5. **Frontend**: Angular components for the user interface.


## 🚀 Getting Started

### Prerequisites

- **Java 11 or higher**
- **Node.js and Angular CLI**
- **MySQL Database**
- **Maven**

### Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/safae97/Gestion_Maternelle.git
   cd Gestion_Maternelle
   ```

2. **Set Up the Database**:
   - Create a MySQL database named `kindergarten_attendance`.
   - Update the `application.properties` file in the backend with your database credentials:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/kindergarten_attendance
     spring.datasource.username=your-username
     spring.datasource.password=your-password
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Run the Backend**:
   ```bash
   mvn spring-boot:run
   ```

4. **Set Up the Frontend**:
   ```bash
   cd frontend
   npm install
   ng serve
   ```

5. **Access the Application**:
   - Open your browser and navigate to `http://localhost:4200`.

---

## 📝 API Endpoints

### Students
- **GET /etudiants** - Get all students
- **GET /etudiants/{id}** - Get a student by ID
- **POST /etudiants** - Create a new student
- **PUT /etudiants/{id}** - Update a student
- **DELETE /etudiants/{id}** - Delete a student

### Attendance
- **GET /absences** - Get all attendance records
- **GET /absences/{id}** - Get an attendance record by ID
- **POST /absences** - Create a new attendance record
- **PUT /absences/{id}** - Update an attendance record
- **DELETE /absences/{id}** - Delete an attendance record

---


## 📑 Report Section
For a detailed explanation of the project , including demonstrationm and implementation detailsplease refer to the [Project Report](./LAB4_Report.docx).


---


Happy Coding! 🚀

