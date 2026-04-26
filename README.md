🏥 Hospital Management System (HMS)

A full-stack web application built with Spring Boot to manage core hospital operations including patients, doctors, appointments, donors, and laboratories.
Designed with clean architecture principles and modular layering to simulate real-world backend systems.


🚀 Overview
This project demonstrates a production-style backend system using the Spring ecosystem.
It focuses on structured code organization, data integrity, and scalable design, rather than just UI.


✨ Key Features
- 🔐 User Registration & Authentication (basic flow)
- 🧑‍⚕️ Doctor Management (CRUD)
- 🧍 Patient Management with relational mapping
- 📅 Appointment Scheduling System
- 🩸 Donor & Laboratory Management
- 🔎 Repository-level query methods for filtering/search
- ✅ Server-side validation using Hibernate Validator
- 🔄 Layered Architecture (Controller → Service → Repository)


🏗️ Architecture
Follows standard Spring Boot layered architecture:

Controller  → Handles HTTP requests
Service     → Business logic layer
Repository  → Data access layer (JPA)
Entity      → Database models
View        → Thymeleaf templates

- Loose coupling between layers
- Separation of concerns
- Easily extensible for REST APIs or microservices


🛠️ Tech Stack
Layer| Technology
Backend| Spring Boot, Spring MVC
ORM| Hibernate (JPA)
Database| MySQL
Frontend| Thymeleaf, HTML, CSS
Build Tool| Maven
Language| Java


📊 Database Design
- Normalized relational schema

- Entity relationships:
  
  - Patient ↔ Doctor (Many-to-One)
  - Patient ↔ Appointment (One-to-One)
  - Donor ↔ Laboratory (Many-to-One)

- Automatic schema generation using:

spring.jpa.hibernate.ddl-auto=update


⚙️ Setup & Run

1. Clone repository

git clone https://github.com/your-username/hospital-management-system.git

2. Configure database

Update "application.properties":

spring.datasource.url=jdbc:mysql://localhost:3306/hospital
spring.datasource.username=your_username
spring.datasource.password=your_password

3. Create database

CREATE DATABASE hospital;

4. Run application

Run:

BackendWebFinalApplication.java

5. Access application

http://localhost:8081


📌 Code Highlights

- Use of Spring Data JPA query methods:

List<Patient> findByFirstName(String firstName);
List<Doctor> findBySpecialty(String specialty);

- Clean repository abstraction (no boilerplate SQL)

- Validation example:

@NotNull
@Email
private String email;


📈 What This Project Demonstrates
- Strong understanding of Spring Boot fundamentals
- Practical use of ORM (Hibernate) and relational mapping
- Ability to design modular and maintainable backend systems
- Experience with real-world debugging (DB + mapping issues)


🔮 Possible Enhancements
- Spring Security (JWT / Role-based access)
- REST API layer (for frontend frameworks)
- Pagination & advanced search
- Docker deployment
- Improved UI/UX
- 

👤 Author
Anandita
ECE Student | Backend Development (Java + Spring Boot)

📄 License
Open-source project for learning and demonstration purposes.
