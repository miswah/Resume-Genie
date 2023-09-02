# Resume Genie - Open Source Resume Building Platform

Welcome to Resume Genie, an open-source project aimed at simplifying the process of creating professional resumes. This project is built using Spring Boot, Spring MVC, Spring Security, Thymeleaf, and MariaDB. With Resume Genie, users can easily create, customize, and share their resumes with potential employers.

![image](https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=white)
&nbsp;
![image](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
&nbsp;
![image](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
&nbsp;
![image](https://img.shields.io/badge/OpenJDK-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
&nbsp;
![image](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=whit)
&nbsp;
![image](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white)

## Features

- User-friendly interface for creating and editing resumes.
- Wide range of beautifully designed templates to choose from.
- Secure user authentication and data privacy with Spring Security.
- Integration with MariaDB for robust and scalable data storage.
- Seamless export of resumes to PDF for easy sharing.

## Getting Started

These instructions will help you set up the project on your local machine for development and testing purposes.

### Prerequisites

- Java Development Kit (JDK) - [Download](https://www.oracle.com/java/technologies/javase-downloads.html)
- Apache Maven - [Download](https://maven.apache.org/download.cgi)
- MariaDB - [Download](https://mariadb.org/download/)
  OR
- MYSQL - [Download](https://www.mysql.com/downloads/)

### Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/miswah/resume-Resume-Geniee.git
   cd Resume-Genie
   ```

2. Configure the database:

- Create a database named resume_genie in MariaDB.

- Update the application.properties file with your MariaDB credentials:

  ```
  spring.datasource.url=jdbc:mariadb://localhost:3306/resume_geni
  spring.datasource.username=your-username
  spring.datasource.password=your-password
  ```

3. Build and run the application:

   ```bash
   mvn spring-boot:run
   ```

4. Access the application:
   Open your web browser and go to http://localhost:8080 to use Resume Genie.
   You can use the default account username : Adam | password : appl3; Dummy data is seed for this user using postConstruct on main
   Additionally you can also signup

### Contributing

We welcome contributions from the community! Feel free to open issues for bug reports, feature requests, or questions. If you'd like to contribute code, please fork the repository and submit a pull request.

### License

This project is licensed under the MIT License - see the LICENSE file for details.
