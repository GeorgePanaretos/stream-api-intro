```
stream-api-project/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── stream/
│   │   │   │   │   ├── intro/
│   │   │   │   │   │   ├── api/
│   │   │   │   │   │   │   ├── CreationStream.java
│   │   │   │   │   │   │   ├── LazyInvocation.java
│   │   │   │   │   │   │   ├── Parallel.java
│   │   │   │   │   │   │   ├── Pipiline.java
│   │   │   │   │   │   │   ├── Reduction.java
│   │   │   │   │   │   │   ├── Reference.java
│   │   │   │   │   │   │   ├── file.txt (Referenced in `CreationStream.java`)

│── pom.xml (if using Maven) or build.gradle (if using Gradle)
│── README.md
│── .gitignore
│── resources/
│   ├── application.properties
│── logs/ (Generated logs if applicable)
```

```md
# Stream API Project

## Overview
This project demonstrates the usage of Java Streams API for various operations like stream creation, lazy invocation, parallel processing, pipelines, reductions, and more. It is a well-organized collection of examples that showcase different stream processing techniques.

## Modules & Features
### **1. Stream Creation**
- **File:** `CreationStream.java`
- Demonstrates different ways of creating streams:
  - Empty streams
  - Streams from collections, arrays, and maps
  - Streams with builders, iterators, and generators
  - Streams from files

### **2. Lazy Invocation**
- **File:** `LazyInvocation.java`
- Demonstrates how Java Streams are lazily evaluated
- Uses logs to track filter and map invocations

### **3. Parallel Streams**
- **File:** `Parallel.java`
- Demonstrates the use of parallel streams for performance improvement
- Compares sequential and parallel stream behaviors

### **4. Stream Pipelines**
- **File:** `Pipiline.java`
- Demonstrates stream operations such as:
  - `skip()`
  - `map()`
  - `sorted()`

### **5. Reduction Operations**
- **File:** `Reduction.java`
- Demonstrates `reduce()` and `collect()` operations in Java Streams
- Uses `Collectors` for grouping, partitioning, and summarizing

### **6. Stream References**
- **File:** `Reference.java`
- Demonstrates `findFirst()` and `findAny()` methods

### **7. Spring Boot Application**
- **File:** `Application.java`
- Main class to bootstrap the Spring Boot application

## Running the Project
### **Prerequisites**
- Java 11+ installed
- Maven or Gradle (if building via dependency manager)
- Spring Boot (if running as an application)

### **Running via Maven**
```sh
mvn clean install
mvn spring-boot:run
```

### **Running Individual Java Classes**
If you want to test a particular Java file:
```sh
javac -d out src/main/java/com/stream/intro/stream/api/CreationStream.java
java -cp out com.stream.intro.stream.api.CreationStream
```

## Logging & Debugging
- Logs are handled via **SLF4J Logger**
- Logs are stored in `logs/` directory
- Modify `application.properties` to configure log levels