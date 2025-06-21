# Start from a lightweight JDK image
FROM eclipse-temurin:21-jre

# Set the working directory
WORKDIR /app

# Copy the JAR file (adjust the filename if necessary)
COPY target/eshop-1.0-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]

