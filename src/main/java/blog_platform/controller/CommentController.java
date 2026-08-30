package blog_platform.controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import blog_platform.entity.Comment;
import blog_platform.entity.Post;
import blog_platform.entity.User;
import blog_platform.service.CommentService;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "*")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping
    public ResponseEntity<CommentResponse> createComment(
            @RequestParam String content,
            @RequestParam Long postId,
            Authentication authentication) {

        String username = authentication.getName();

        Comment comment = commentService.createComment(
                content, username, postId);

        return ResponseEntity.ok(toResponse(comment));
    }
   
    @GetMapping("/post/{postId}")
    public ResponseEntity<List<CommentResponse>> getCommentsByPost(
            @PathVariable Long postId) {

        List<CommentResponse> comments =
                commentService.getCommentsByPost(postId)
                        .stream()
                        .map(this::toResponse)
                        .toList();

        return ResponseEntity.ok(comments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentResponse> getCommentById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                toResponse(commentService.getCommentById(id))
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentResponse> updateComment(
            @PathVariable Long id,
            @RequestParam String content) {

        Comment comment =
                commentService.updateComment(id, content);

        return ResponseEntity.ok(toResponse(comment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(
            @PathVariable Long id) {

        commentService.deleteComment(id);

        return ResponseEntity.ok("Comment deleted successfully");
    }

    private CommentResponse toResponse(Comment comment) {

        User user = comment.getUser();
        Post post = comment.getPost();

        UserResponse userResponse = new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );

        UserResponse postUserResponse = new UserResponse(
                post.getUser().getId(),
                post.getUser().getUsername(),
                post.getUser().getEmail()
        );

        PostResponse postResponse = new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt() != null
                        ? post.getCreatedAt().toString()
                        : null,
                post.getUpdatedAt() != null
                        ? post.getUpdatedAt().toString()
                        : null,
                postUserResponse
        );

        return new CommentResponse(
                comment.getId(),
                comment.getContent(),
                comment.getCreatedAt() != null
                        ? comment.getCreatedAt().toString()
                        : null,
                userResponse,
                postResponse
        );
    }
}