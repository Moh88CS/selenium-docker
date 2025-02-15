# Selenium Docker Testing Framework

This repository contains a **Selenium-based testing framework** designed to test two web applications: a **Flight Reservation Web App** and a **Vendor Portal App**. The framework is built to run in a **CI/CD pipeline** using **Jenkins**, **Docker**, and **Selenium Grid**. It leverages **multi-layered parallelism** to distribute tests across multiple machines in an **AWS EC2 fleet**, multiple browsers via **Selenium Grid**, and multiple threads within each test suite.

## Key Features

- **Multi-Layered Parallelism**:
  - **AWS EC2 Fleet**: Tests are distributed across multiple machines.
  - **Selenium Grid**: Enables cross-browser testing (e.g., Chrome, Firefox, Edge).
  - **Multi-Threaded Tests**: Each test suite runs on multiple threads for faster execution.
- **CI/CD Integration**: Fully integrated with **Jenkins** for automated testing in a CI/CD pipeline.
- **Dockerized Environment**: Uses **Docker** to containerize the testing environment, ensuring consistency across machines.
- **Two Test Suites**:
  - **Flight Reservation Web App**: Tests for flight booking functionality.
  - **Vendor Portal App**: Tests for vendor management and portal functionality.

## Prerequisites

Before you begin, ensure you have the following installed:

- **Docker**: For containerizing the testing environment.
- **Jenkins**: For CI/CD pipeline automation.
- **AWS EC2 Instances**: For distributed test execution.
- **Java Development Kit (JDK)**: Version 8 or higher.
- **Maven**: For dependency management and build automation.
- **Git**: To clone the repository.

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Moh88CS/selenium-docker.git
   cd selenium-docker
   mvn clean install
   mvn test

You can also manually run each test suite individually

## IMPORTATNT NOTICE
Unfortunaly, I no longer have access to the cloud environments and Jenkins, meaning the CI/CD demo is hard to replicate. Due to this, I have commented out the remote driver function in the code (please staticly review the code). The good news is that we can still run the tests locally with Maven. You can also see how the tests suites are run in a multi-threaded way which I think is really cool! Thank you so much for understanding :)
