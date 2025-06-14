# Use a lightweight base image with JDK
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the co gb ng7ntainer at /app
COPY target/*.jar app.jar

# Expose the port on which the Spring Boot application will run (assuming it's 8080)
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
