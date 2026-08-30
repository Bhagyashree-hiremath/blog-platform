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
├── mvnw
├── mvnw.cmd
└── README.md
