# Use the official OpenJDK image as a base image
FROM openjdk:8-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy the built JAR from target folder and rename to app.jar into the image
COPY target/*.jar ems-apk.jar

# Expose the port on which the Spring Boot application will run
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/ems-apk.jar"]