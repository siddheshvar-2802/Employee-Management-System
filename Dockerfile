# Use official OpenJDK 8 image as a base image
FROM openjdk:8-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# VOLUME /tmp - This line is commented out because it's not necessary for this Dockerfile

# Copy the packaged JAR file into the container at /app
COPY target/Employee-Management-System-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which the Spring Boot application will run (assuming it's 8080)
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
