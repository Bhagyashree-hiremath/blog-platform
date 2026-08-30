package blog_platform.controller;

public class CommentResponse {

    private Long id;
    private String content;
    private String createdAt;
    private UserResponse user;
    private PostResponse post;

    public CommentResponse() {
    }

    public CommentResponse(Long id, String content, String createdAt,
                           UserResponse user, PostResponse post) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.user = user;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public PostResponse getPost() {
        return post;
    }

    public void setPost(PostResponse post) {
        this.post = post;
    }
}