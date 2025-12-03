# 🌟 Varaha Services — Cloud-Ready Java Microservices Platform

A modular, scalable, and cloud-ready backend platform built with **Java + Spring Boot**, designed for both traditional service deployments and AWS Lambda serverless environments.  
This project follows **contract-first API development**, clean architecture principles, and modern dev workflows used in enterprise systems.

---

## 🚀 Project Highlights

This project is designed with **enterprise-grade architecture**, focusing on modularity, scalability, cloud readiness, and developer experience.

### ✔️ Modern Java Microservices Architecture
- Built using **Java + Spring Boot** following clean, modular, and domain-driven design principles.
- Service logic is separated into reusable modules, enabling easier maintenance and independent evolution of components.

### ✔️ Multi-Module Gradle Project Structure
- Structured as a **Gradle multi-module** project (`common-core`, `web-services`, `lambda-fn`).
- Ensures clean separation of responsibilities and promotes code reuse across deployment targets.

### ✔️ Dual Deployment Model: EC2/Web Service + AWS Lambda
The system can run as:
- A fully functional **Spring Boot web service** deployable on EC2, ECS, Fargate, Docker, or any JVM platform.
- A lightweight **AWS Lambda function** consuming the same shared core logic.

This ensures flexibility for different runtime environments and supports long-term cost optimization.

### ✔️ Contract-First API Development
- APIs are defined and maintained using the **OpenAPI 3.x specification**.
- Ensures consistent API design, predictable integrations, and high-quality documentation.

### ✔️ Comprehensive Documentation (Docs-as-Code)
All documentation lives inside the repository under `/docs`, including:
- **API Specifications** (OpenAPI YAML/JSON)
- **Business Workflows** (Mermaid diagrams)
- **Architecture Diagrams**
- **API Collections** (Bruno or Postman compatible)
- **Developer & Ops Runbooks**

This supports easy onboarding, enterprise transparency, and version-controlled documentation.

### ✔️ Reusable Core Logic
- The `common-core` module contains shared domain models, service logic, constants, and reusable helpers.
- Prevents duplication and keeps deployable modules lightweight.

### ✔️ Cloud-Ready and CI/CD Friendly
- Designed to integrate smoothly with:
    - **GitHub Actions**
    - **AWS CodeBuild / CodePipeline**
    - **Docker & GitHub Container Registry**
- Supports automated



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
