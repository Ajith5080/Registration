# Registration Management System

This project is a simple web-based registration management system that allows users to create and view registration records. It is built using **Java Servlets**, **JSP** (JavaServer Pages), and a **MySQL** database.

## Project Overview

The application allows users to:
1. **Create new registration entries**: Users can enter their details (name, email, date of birth, etc.) through a form.
2. **View all registrations**: Displays a list of all registrations stored in the MySQL database.

The application follows the **Model-View-Controller (MVC)** pattern:
- **Model**: `registerTo.java` - A class that represents the registration entity.
- **View**: JSP files (`index.jsp`, `create.jsp`, `view.jsp`) which present the UI to the user.
- **Controller**: `registrationController.java` - A servlet that handles user requests and manages interactions with the model.

## Project Structure

The project is structured as follows:


### Backend (Java, JSP, Servlets)
- **DBUtil.java**: Contains the database connection logic.
- **registerTo.java**: Data model for the registration entity.
- **registrationController.java**: Servlet for handling registration creation and retrieval.
- **JSP files**:
  - `index.jsp`: The homepage, provides links to create a registration and view registrations.
  - `create.jsp`: Form to create a new registration.
  - `view.jsp`: Displays a list of all registrations.

## Requirements

Before running the application, make sure you have the following:
1. **JDK 8 or higher**: Required for compiling and running the Java code.
2. **Apache Tomcat (or any other Java EE container)**: To deploy and run the servlet-based application.
3. **MySQL Database**: To store registration data.
4. **MySQL JDBC Driver**: Make sure the MySQL JDBC driver (`mysql-connector-java`) is in your classpath.

## Setting Up the Project

### 1. **Set up MySQL Database**:

1. Create a new database named `registration`:
   ```sql
   CREATE DATABASE registration;
CREATE TABLE registratiom (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Email VARCHAR(100) UNIQUE NOT NULL,
    DateOfBirth DATE NOT NULL,
    PhoneNumber VARCHAR(15),
    Address TEXT
);



