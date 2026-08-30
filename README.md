# 📝 Blog Platform with Comments

A full-stack blogging platform built using **Spring Boot, Java, MySQL, HTML, CSS, and JavaScript**.

Users can register and log in, create blog posts, view posts, edit and delete posts, and interact through comments.

---

## 🚀 Features

### User Management

- User registration
- User login
- Password encryption using BCrypt
- User information associated with posts and comments

### Blog Posts

- Create blog posts
- View all blog posts
- View individual blog posts
- Edit blog posts
- Delete blog posts

### Comments

- Add comments to blog posts
- Display comments for each post
- Display comment author and creation date
- Comments are associated with the logged-in user

---

## 🛠️ Technologies Used

### Backend

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- Hibernate
- Maven

### Database

- MySQL

### Frontend

- HTML5
- CSS3
- JavaScript
- Fetch API

### Tools

- Eclipse
- Postman
- Git
- GitHub

---

## 📂 Project Structure

```text
blog-platform/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── blog_platform/
│   │   │       ├── config/
│   │   │       ├── controller/
│   │   │       ├── entity/
│   │   │       ├── repository/
│   │   │       └── service/
│   │   │
│   │   └── resources/
│   │       ├── static/
│   │       │   ├── index.html
│   │       │   ├── login.html
│   │       │   ├── register.html
│   │       │   ├── create-post.html
│   │       │   ├── post.html
│   │       │   ├── script.js
│   │       │   ├── login.js
│   │       │   ├── register.js
│   │       │   ├── create-post.js
│   │       │   ├── post.js
│   │       │   └── style.css
│   │       │
│   │       └── application.properties
│   │
│   └── test/
│
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
└── README.md
```

---

## 🔗 REST API Endpoints

### Authentication

```text
POST /api/auth/register
POST /api/auth/login
```

### Posts

```text
GET    /api/posts
GET    /api/posts/{id}
POST   /api/posts
PUT    /api/posts/{id}
DELETE /api/posts/{id}
```

### Comments

```text
POST   /api/comments
GET    /api/comments/post/{postId}
GET    /api/comments/{id}
PUT    /api/comments/{id}
DELETE /api/comments/{id}
```

---

## 🗄️ Database Setup

Create the MySQL database:

```sql
CREATE DATABASE blog_platform;
```

Configure the database credentials in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blog_platform
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

> **Note:** Database credentials should not be committed to GitHub.

---

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone https://github.com/Bhagyashree-hiremath/blog-platform.git
```

### 2. Open the project

Open the project in **Eclipse** as a Maven project.

### 3. Create the MySQL database

```sql
CREATE DATABASE blog_platform;
```

### 4. Configure MySQL

Update the MySQL username and password in:

```text
src/main/resources/application.properties
```

### 5. Run the application

Run:

```text
BlogPlatformApplication.java
```

as a **Spring Boot Application**.

### 6. Open the application

```text
http://localhost:8080/index.html
```

---

## 🌐 Application Pages

### Home

```text
http://localhost:8080/index.html
```

### Login

```text
http://localhost:8080/login.html
```

### Register

```text
http://localhost:8080/register.html
```

### Create Post

```text
http://localhost:8080/create-post.html
```

### View Post

```text
http://localhost:8080/post.html?id={postId}
```

---

## 🧪 Tested Features

- ✅ User Registration
- ✅ User Login
- ✅ Password Encryption
- ✅ Create Post
- ✅ View All Posts
- ✅ View Individual Post
- ✅ Edit Post
- ✅ Delete Post
- ✅ Add Comment
- ✅ View Comments
- ✅ Logged-in User Association
- ✅ MySQL Database Integration
- ✅ REST API Integration

---

## 👨‍💻 Author

**Bhagyashree Hiremath**

---

## 🔗 GitHub Repository

https://github.com/Bhagyashree-hiremath/blog-platform
