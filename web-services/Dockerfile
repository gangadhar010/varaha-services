# Runtime image with JDK (use Corretto 17 since you're on AWS)
FROM amazoncorretto:21-alpine

# Create a non-root user (better security)
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Set working directory inside container
WORKDIR /app

# Copy the built Spring Boot jar from your machine into the image
# (we'll build from web-services directory, so path is relative)
COPY build/libs/*.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Run as non-root user
USER appuser

# Command to run when container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
