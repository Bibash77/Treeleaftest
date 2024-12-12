# Treeleaf Job Qualification Task

This repository contains the solution to the Treeleaf Job Qualification Task, implemented as a modular Java project with three distinct modules.

## Project Structure

- **Module 1: logical-task**  
  Solutions for:
  - **Q1:** Count inversions in an array.
  - **Q2:** Find n-digit numbers with a specified digit sum.

- **Module 2: web-app-task**  
  A simple web app implementing:
  - User registration, login, and role-based permissions.
  - CRUD operations for blog posts and comments.
  - MySQL database integration.

    - Default username/pw for admin user is "admin"
    - find postman collection under logical-task module >> resources >> json
- **Module 3: problem-solving-task**  
  Converts customer profiles from a 4-byte integer ID to a 128-bit UUID.

## Requirements

- Java 17+
- Maven
- MySQL (for `web-app-task` module)
- Postman (for API testing)

## Setup Instructions

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/treeleaf-job-qualification.git
   cd treeleaf-job-qualification
