# CineMatch
[![Alpine Linux](https://img.shields.io/badge/Alpine_Linux-%230D597F.svg?style=for-the-badge&logo=alpine-linux&logoColor=white)](https://www.alpinelinux.org/)
[![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)](https://maven.apache.org/)
[![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)
[![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)](https://java.com/)
[![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)](https://www.mongodb.com/)
[![MariaDB](https://img.shields.io/badge/MariaDB-%23003561.svg?style=for-the-badge&logo=mariadb&logoColor=white)](https://mariadb.org/)
[![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)](https://www.postman.com/)
[![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/)
[![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)](https://swagger.io/)

CineMatch is a movie match-making software project that allows users to enter their preferences to watch a certain movie or movie genre, their availability, location and their preferred distance. The system will look for potential matches with other users. Once a match has been made, users can communicate through the application to decide on further details and leave a review about their overall experience afterwards. 

This repository is responsible for the backend source files of CineMatch.

## Table of Contents
- [Getting Started](#getting-started)
  - [Using Docker Compose](#using-docker-compose)
    - [Prerequisites](#prerequisites)
    - [Setting Port Numbers](#setting-port-numbers)
    - [Starting the services](#starting-the-services)
    - [Stopping or removing the services](#stopping-or-removing-the-services)
- [Using the API](#using-the-api)

# Getting Started

This section provides information on how to get started with the project and run it locally or on a server.

## Using Docker Compose

### Prerequisites
Before running the project, make sure you have Docker Desktop installed or configured. 

Alternatively, you can run the docker-compose.yaml file with separate components like Docker Engine (provides the core components), Docker CLI (interface which allows you to interact with Docker and manage containers and images), and Docker Compose (necessary for the management of multi-container applications). 
However, for a more convenient and user-friendly experience, I would recommend using Docker Desktop, which provides all the necessary tools and features. It even includes a great UI to work with.

Make sure these prerequisites are properly installed and set up on your system before proceeding with the setup.

### Setting Port Numbers

To ensure the proper functioning of the software on your system, you may need to specify the ports that the application should use. The backend includes two services: the API gateway and the Eureka discovery server. You can set the ports for these services by following these steps:

1. Find the `.env.example` file in the project's root directory.

2. Remove the `.example` extension from the filename, so it becomes `.env`.

3. Open the `.env` file and enter your desired port numbers for the API gateway and Eureka discovery server. For example, the default ports are:

   ```
   GATEWAY_PORT=8080
   EUREKA_PORT=8761
   ```

   Customize the port numbers as per your requirements.

4. Save the file.

By setting the ports in the `.env` file, you can ensure that the CineMatch application uses the specified ports for the API gateway and Eureka discovery server.

## Starting the services

To quickly set up the project using Docker Compose, follow these steps:

1. Download the `docker-compose.yaml` file located in the root of this project.

2. Open a terminal or command prompt and navigate to the directory where you downloaded the `docker-compose.yaml` file.

3. Run the following command to start the project:
   ```
   docker-compose up -d
   ```

   Docker Compose will now pull the latest CineMatch images from DockerHub and start the project.

Using Docker Compose eliminates the need for manual installation and configuration steps, as it takes care of the setup process for you.

## Stopping or removing the services

Run the following command to stop the project:
   ```
   docker-compose down
   ```
   This command will stop and remove the running containers associated with the project.

   Alternatively, you can use the following command to stop the project without removing the containers:
   ```
   docker-compose stop
   ```
   This command will stop the running containers, allowing you to start them again later using the `docker-compose up` command.

Both commands serve different purposes:

- `docker-compose down` stops and removes the containers, providing a clean shutdown of the project. This frees up system resources and ensures a fresh start the next time you run `docker-compose up`.

- `docker-compose stop` simply stops the containers without removing them. This allows you to resume the project from its current state later by using `docker-compose up`.

## Using the API

To interact with the CineMatch project's API, follow these steps:

1. Start the project using Docker Compose as described in the previous section.

2. Open a web browser and navigate to the following URL: `http://localhost:8080/webjars/swagger-ui/index.html`

   This URL will provide access to the API documentation and the UI created by [OpenAPI](https://springdoc.org/).
   You can switch to different services by using the menu in the top-right corner: <!-- TODO upload image -->

3. Explore the available endpoints, request parameters, and response formats in the API documentation.

   The documentation will provide detailed information about each API endpoint, including example requests and responses.

4. Use the UI created by OpenAPI to interact with the APIs directly.

   The UI allows you to send requests to the API endpoints and view the responses. You can test different functionalities and see the results in real-time.