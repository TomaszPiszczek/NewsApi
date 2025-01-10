# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY app.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "app.jar"]
