# 🎰 Slot Machine - Java Spring Boot Backend

This is the backend service for a slot machine web game.  
Built using Java and Spring Boot, it handles user registration, login, and point updates with a connected MySQL database.

---

## 📦 Features

- 🔐 Register & Login endpoints
- 🎯 Score tracking per user
- 🧠 Spring Boot REST API
- 🛢️ MySQL database (can run with Docker)
- ☁️ Deploy-ready (Render, Railway, etc.)

---

## 🚀 API Endpoints

| Method | Endpoint                     | Description             |
|--------|------------------------------|-------------------------|
| POST   | `/api/register`              | Register a new user     |
| POST   | `/api/login`                 | Authenticate user       |
| POST   | `/api/user/update-score`     | Update user score       |
| GET    | `/api/user?email=...`        | Get user info by email  |

---

## ⚙️ Setup Locally

```bash
# Run MySQL using Docker (optional)
docker-compose up -d

# Then run the app:
./mvnw spring-boot:run
