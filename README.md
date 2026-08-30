# 📝 Blog Platform with Comments

A full-stack blogging platform built using **Spring Boot, Java, MySQL, HTML, CSS, and JavaScript**.

Users can register and log in, create blog posts, view posts, edit and delete their own posts, and interact through comments.

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
- Display post author and creation date

### Comments
- Add comments to blog posts
- Display comments for each post
- Display comment author and creation date
- Comments are associated with the logged-in user

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

## 📁 Project Structure

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
│   │       └── static/
│   │           ├── index.html
│   │           ├── login.html
│   │           ├── register.html
│   │           ├── create-post.html
│   │           ├── post.html
│   │           ├── script.js
│   │           ├── login.js
│   │           ├── register.js
│   │           ├── create-post.js
│   │           ├── post.js
│   │           └── style.css
│   │
│   └── test/
│
├── pom.xml
├── mvn
├── mvnw.cmd
└── README.md
🔗 REST API Endpoints
Authentication
POST /api/auth/register
POST /api/auth/login
Posts
GET    /api/posts
GET    /api/posts/{id}
POST   /api/posts
PUT    /api/posts/{id}
DELETE /api/posts/{id}
Comments
POST   /api/comments
GET    /api/comments/post/{postId}
GET    /api/comments/{id}
PUT    /api/comments/{id}
DELETE /api/comments/{id}
Database Setup
Create a MySQL database
CREATE DATABASE blog_platform;
Configure your local database credentials in:
src/main/resources/application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/blog_platform
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
How to Run
1. Clone the repository.
git clone https://github.com/Bhagyashree-hiremath/blog-platform.git
2.Open the project in Eclipse as a Maven project.
3.Create the MySQL database:
CREATE DATABASE blog_platform;
4.Configure your MySQL username and password.
5.Run:
BlogPlatformApplication.java
as a Spring Boot Application.
6.Open the application:
http://localhost:8080/index.html
Application Pages
Home:
http://localhost:8080/index.html

Login:
http://localhost:8080/login.html

Register:
http://localhost:8080/register.html

Create Post:
http://localhost:8080/create-post.html

Post:
http://localhost:8080/post.html?id={postId}
🧪 Tested Features
✅ Registration
✅ Login
✅ Create Post
✅ View Posts
✅ Read Individual Post
✅ Edit Post
✅ Delete Post
✅ Add Comment
✅ View Comments
✅ MySQL Database Integration
✅ REST API Integration

👨‍💻 Author
Bhagyashree Hiremath
🔗 GitHub Repository

https://github.com/Bhagyashree-hiremath/blog-platform
