# Final_Project
TechPro Final Project

Spring Boot and React CRUD Application with Docker
This is a README file for a CRUD (Create, Read, Update, Delete) application built using Spring Boot and React, containerized with Docker. The application demonstrates the integration of a backend API built with Spring Boot and a frontend user interface developed with React, packaged and deployed using Docker containers.

Prerequisites
Before running the application with Docker, ensure that you have the following prerequisites installed:

Docker Engine: Install Docker on your machine. Refer to the Docker documentation for instructions specific to your operating system.
Getting Started
To get started with the Spring Boot and React CRUD application using Docker, follow the steps below:

Clone the repository or download the source code.

git clone https://github.com/KostasTheG/Final_Project.git

Build and Run the Docker Containers

Open a terminal and navigate to the root folder of the project.

Build the backend Docker image:
docker build -t backend:latest -f backend/Dockerfile

Build the frontend Docker image:
docker build -t frontend:latest -f frontend/Dockerfile

Run the Docker containers:
docker-compose up -d

The Docker Compose file (docker-compose.yml) will spin up two containers, one for the backend and one for the frontend. It will automatically configure the necessary networking between the containers.

Access the Application

Open your web browser and visit http://localhost:3000 to access the React frontend.

The application will allow you to perform CRUD operations on the specified resource.

Folder Structure

The project structure of the Spring Boot and React CRUD application with Docker may look as follows:

spring-boot-react-crud/
├── backend/                 # Backend Spring Boot project
│   ├── src/
│   ├── Dockerfile
│   └── ...
├── frontend/                # Frontend React project
│   ├── src/
│   ├── public/
│   ├── Dockerfile
│   └── ...
├── docker-compose.yml       # Docker Compose configuration
└── ...


The backend folder contains the Spring Boot application source code and a Dockerfile to build the backend Docker image.
The frontend folder contains the React application source code, public assets, and a Dockerfile to build the frontend Docker image.
The docker-compose.yml file defines the services, networking, and configurations for running the backend and frontend containers.

Additional Notes

The backend API endpoints can be defined in the Spring Boot controllers.

The frontend React components can be modified in the React application's source code.

Customize the frontend user interface as per your requirements using React components, styles, and routing.

Ensure that the necessary environment variables, such as database connection details, are properly configured in the respective Dockerfiles or passed as environment variables in the Docker Compose file.

Resources

Spring Boot Documentation
React Documentation
Docker Documentation

License

This project is licensed under the MIT License.

Feel free to modify and use this application as a starting point for your own projects.






