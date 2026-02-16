# Kartrace

A karting race simulator for MYLAPS Sports Technology that determines the winner based on the fastest lap time.

## Overview

This Spring Boot application simulates a kart racing system where:
- Multiple karts (2-5) compete in a race with a fixed number of laps
- The system records lap completion times as karts cross the start/finish line
- The race finishes when any kart completes all laps
- The winner is the driver with the **fastest single lap** (not overall race time)

## Technology Stack

- **Java 21** (or 17+)
- **Spring Boot 3.x**
- **Maven** (wrapper included)
- **Bruno** for API testing

## Prerequisites

- **Java 21** (or Java 17+)
- **Docker** (optional, for containerized deployment)
- **Bruno** (for API testing)

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/kartrace.git
cd kartrace
```

### 2. Build the Application
Using Maven wrapper (no Maven installation required):

```bash
./mvnw clean install
```
On Windows:

```
bash
mvnw.cmd clean install
```

### 3. Run the Application
> ./mvnw spring-boot:run

### 4. Open your browser and navigate to:

http://localhost:8080/actuator/health
You should see: {"status":"UP"}

API Usage
Available Endpoints
Method	Endpoint	            Description
POST	/api/races/start	    Start a new race
POST	/api/races/lap-times	Record a lap completion
GET	    /api/races/winner	    Get the winner (fastest lap)

Open your browser and navigate to:

text
http://localhost:8080/actuator/health
You should see: {"status":"UP"}

### 5. Test with Bruno

Install Bruno 
# macOS
brew install bruno

# Windows
winget install Bruno.Bruno

# Ubuntu
sudo snap install bruno

Open Bruno and load the bruno/ directory. Select "local" environment and run tests 1-8 sequentially.




