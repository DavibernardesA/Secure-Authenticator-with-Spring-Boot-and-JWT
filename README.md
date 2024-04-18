# Spring Boot Login System

This is an example Spring Boot application that implements a login system with JWT authentication and password encryption.

## Features

- User authentication using JWT.
- User registration.
- Password encryption for security.

## Routes

- `POST /auth/login`: Route to authenticate a user. Receives user credentials (email and password) and returns a valid JWT token.
- `POST /auth/register`: Route to register a new user. Receives new user information (name, email, and password) and creates a new account.

## Configuration

Before running the application, you need to configure the database and other properties. You can configure the database information in the `application.properties` file.

Make sure you have Java and Maven installed on your machine to compile and run the application.

## How to Run

1. Clone this repository:
```
https://github.com/DavibernardesA/Secure-Authenticator-with-Spring-Boot-and-JWT
```

2. Navigate to the project directory: cd Secure-Authenticator-with-Spring-Boot-and-JWT

3. Compile the application using Maven: mvn clean install

4. Run the application: java -jar target/Secure-Authenticator-with-Spring-Boot-and-JWT

5. The application will be available at `http://localhost:8080`.

### Example of use:

![Captura de tela 2024-04-17 233711](https://github.com/DavibernardesA/Secure-Authenticator-with-Spring-Boot-and-JWT/assets/133716733/e5a2f845-9b26-48f6-b0aa-a920545f43f8)
