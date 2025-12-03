# Varaha Services

This is a multi-module Spring Boot application built with Gradle.

## Prerequisites

- Java 17 or higher (the project is configured for Java 17)
- An internet connection (for Gradle to download dependencies)

## Project Structure

- `common-core`: A library module containing shared business logic and domain models.
- `web-services`: A Spring Boot application that provides REST APIs.
- `lambda-fn`: A module for creating an AWS Lambda function.

## Building the Project

The standard way to build the project is to run the `build` command from the root directory. This will build all modules, including the executable JAR for `web-services`.

**Primary Build Command:**
```sh
# From the root directory (varaha-services)
./gradlew build
```
*(On Windows, use `gradlew.bat build`)*

This command will:
- Compile all Java code.
- Run all unit tests.
- Create the executable "fat JAR" for the `web-services` application.

The main output artifact will be located at:
- `web-services/build/libs/web-services-0.0.1-SNAPSHOT.jar`

### Building Individual Artifacts (Optional)

If you only want to build a specific module, you can target it directly.

- **Web Services JAR only:** `./gradlew :web-services:bootJar`
- **Lambda Function JAR only:** `./gradlew :lambda-fn:jar`

## Running the Web Application

To run the `web-services` application locally, use the `bootRun` task:
```sh
./gradlew :web-services:bootRun
```
The application will be available at `http://localhost:8080`.

### Accessing Swagger UI

Once the `web-services` application is running, you can access the API documentation and test endpoints via Swagger UI at:
[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
