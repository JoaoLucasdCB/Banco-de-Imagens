# Image Bank System

## Overview
The Image Bank System is a simple web application that allows users to upload, view, update, and delete images. It is built using Spring Boot for the backend and utilizes MySQL as the database for storing image data. The frontend is developed using HTML, CSS, and JavaScript.

## Features
- **CRUD Functionality**: Users can create, read, update, and delete images.
- **Responsive Design**: The web interface is designed to be user-friendly and responsive.
- **Dynamic Gallery**: The image gallery updates dynamically as images are added or removed.

## Technologies Used
- **Backend**: Spring Boot, Java, MySQL
- **Frontend**: HTML, CSS, JavaScript
- **Build Tool**: Maven

## Project Structure
```
image-bank-system
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── imagebank
│   │   │               ├── ImageBankApplication.java
│   │   │               ├── controller
│   │   │               │   └── ImageController.java
│   │   │               ├── model
│   │   │               │   └── Image.java
│   │   │               ├── repository
│   │   │               │   └── ImageRepository.java
│   │   │               └── service
│   │   │                   └── ImageService.java
│   │   ├── resources
│   │   │   ├── static
│   │   │   │   ├── css
│   │   │   │   │   └── styles.css
│   │   │   │   └── js
│   │   │   │       └── scripts.js
│   │   │   ├── templates
│   │   │   │   └── index.html
│   │   │   └── application.properties
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── imagebank
│                       └── ImageBankApplicationTests.java
├── pom.xml
└── README.md
```

## Getting Started
1. **Clone the repository**:
   ```
   git clone <repository-url>
   cd image-bank-system
   ```

2. **Set up the database**:
   - Create a MySQL database for the application.
   - Update the `application.properties` file with your database connection details.

3. **Build the project**:
   ```
   mvn clean install
   ```

4. **Run the application**:
   ```
   mvn spring-boot:run
   ```

5. **Access the application**:
   Open your web browser and navigate to `http://localhost:8080`.

## API Endpoints
- `POST /images`: Add a new image.
- `GET /images`: Retrieve all images.
- `DELETE /images/{id}`: Remove an image by ID.
- `PUT /images/{id}`: Update an image by ID.

## License
This project is licensed under the MIT License.