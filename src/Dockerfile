# Use the official OpenJDK image as a base image
FROM openjdk:8-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

VOLUME /tmp
#COPY target/*.jar app.jar
COPY target/Employee-Management-System.jar /app/your-application.jar
ENTRYPOINT ["java","-jar","/Employee-Management-System.jar"]
# Expose the port on which the Spring Boot application will run
EXPOSE 8080

CMD ["java", "-jar", "Employee-Management-System-0.0.1-SNAPSHOT.jar"]