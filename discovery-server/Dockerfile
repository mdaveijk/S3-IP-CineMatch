FROM eclipse-temurin:17-jdk-alpine

## Set the maintainer label
LABEL maintainer="Maurice Schippers <476719@student.fontys.nl>" 

## Set other labels
LABEL version="1.0"
LABEL description="Docker image for the discovery-server service of CineMatch."

## If no WORKDIR is specified, the root directory will be used.

## To prevent the container being run by a root user, another "user" with less privileges is added
## More about it here: https://spring.io/guides/topicals/spring-boot-docker/
RUN addgroup -S docker && adduser -S docker -G docker
USER docker:docker

## Set the JAR_FILE argument to specify the source JAR file for the application
ARG JAR_FILE=*.jar

## Two arguments: 1. What file to be copied 2. The destination it will be copied to.
COPY ${JAR_FILE} app.jar

## Specify the port
ENV port=8761

## Run on port:
EXPOSE 8761

## Execute the following "exec" command (an array format)
ENTRYPOINT ["java","-jar","/app.jar"]