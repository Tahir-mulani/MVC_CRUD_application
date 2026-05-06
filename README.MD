# MVC CRUD Application

A Java Servlet-based MVC (Model-View-Controller) web application for managing Departments and Employees with full CRUD (Create, Read, Update, Delete) operations.

## Features

- **Admin Authentication**: Simple login system with admin credentials
- **Department Management**:
  - Add new departments
  - View all departments in a table format
  - Update existing department information
  - Delete departments
- **Employee Management**:
  - Add new employees
  - View all employees
- **Responsive UI**: Bootstrap-based modern interface
- **Database Integration**: MySQL database for data persistence

## Technologies Used

- **Backend**:
  - Java 21
  - Jakarta Servlet API 6.0.0
  - Maven for dependency management
- **Database**:
  - MySQL 8.0.33
- **Frontend**:
  - HTML5
  - CSS3
  - Bootstrap 5.3.8
  - JavaScript
- **Development Tools**:
  - Lombok for reducing boilerplate code

## Prerequisites

Before running this application, make sure you have the following installed:

- Java Development Kit (JDK) 21 or higher
- Apache Maven 3.6 or higher
- MySQL Server 8.0 or higher
- A Java EE compatible web server (e.g., Apache Tomcat 10.1+)

## Installation and Setup

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd MVC_CRUD_Application
   ```

2. **Database Setup**:
   - Create a MySQL database named `CRUD_APP`
   - Update the database credentials in `src/main/java/com/MVCProject/repository/DBConnection.java` if needed:
     ```java
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CRUD_APP","root","7083560700");
     ```

3. **Build the Project**:
   ```bash
   mvn clean compile
   ```

4. **Package the Application**:
   ```bash
   mvn package
   ```

5. **Deploy to Web Server**:
   - Copy the generated WAR file from `target/` directory to your web server's webapps directory
   - Or deploy directly using your IDE's deployment tools

## Running the Application

1. Start your MySQL server
2. Start your web server (e.g., Tomcat)
3. Access the application at: `http://localhost:8080/your-app-name/login.html`
4. Login with credentials:
   - Username: `admin`
   - Password: `admin`

## Project Structure

```
MVC_CRUD_Application/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── MVCProject/
│       │           ├── controller/          # Servlet controllers
│       │           │   ├── Login.java
│       │           │   ├── AddDepartmentController.java
│       │           │   ├── ViewDepartmentControl.java
│       │           │   ├── UpdateDepartmentController.java
│       │           │   ├── DeleteDepartmentContoller.java
│       │           │   ├── AddEmployeeController.java
│       │           │   └── ViewEmployeeControl.java
│       │           ├── model/               # Data models
│       │           │   ├── DepartmentModel.java
│       │           │   └── EmployeeModel.java
│       │           ├── repository/          # Data access layer
│       │           │   ├── DBConnection.java
│       │           │   ├── DepartmentRepository.java
│       │           │   ├── DepartmentRepositorymp.java
│       │           │   ├── EmployeeRepository.java
│       │           │   └── EmployeeRepositoryImp.java
│       │           └── service/             # Business logic layer
│       │               ├── DepartmentService.java
│       │               ├── DepartmentServiceImpl.java
│       │               ├── EmployeeService.java
│       │               └── EmployeeServiceImp.java
│       └── webapp/                         # Web resources
│           ├── login.html
│           ├── dashboard.html
│           ├── register.html
│           ├── CSS/
│           └── WEB-INF/
│               └── lib/
├── target/                                 # Compiled classes and build artifacts
├── pom.xml                                 # Maven configuration
└── README.MD                               # Project documentation
```

## Architecture

This application follows the MVC (Model-View-Controller) architectural pattern:

- **Model**: `DepartmentModel` and `EmployeeModel` classes represent the data entities
- **View**: HTML pages with Bootstrap styling for user interface
- **Controller**: Servlet classes handle HTTP requests and responses
- **Repository**: Data access objects for database operations
- **Service**: Business logic layer between controllers and repositories

## Database Schema

### Departments Table
```sql
CREATE TABLE departments (
    did INT PRIMARY KEY AUTO_INCREMENT,
    dname VARCHAR(255) NOT NULL
);
```

### Employees Table
```sql
CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    salary INT NOT NULL,
    contact VARCHAR(255)
);
```

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- Bootstrap for the responsive UI framework
- MySQL for the database management system
- Jakarta Servlet API for web development