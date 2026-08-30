package blog_platform.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import blog_platform.entity.Post;
import blog_platform.service.PostService;
import org.springframework.security.core.Authentication;
@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping
    public ResponseEntity<PostResponse> createPost(
            @RequestBody Post post,
            Authentication authentication) {

        String username = authentication.getName();

        Post createdPost = postService.createPost(
                post, username);

        return ResponseEntity.ok(toResponse(createdPost));
    }
    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts() {

        List<PostResponse> posts = postService.getAllPosts()
                .stream()
                .map(this::toResponse)
                .toList();

        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPostById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                toResponse(postService.getPostById(id))
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponse> updatePost(
            @PathVariable Long id,
            @RequestBody Post post) {

        Post updatedPost = postService.updatePost(id, post);

        return ResponseEntity.ok(toResponse(updatedPost));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(
            @PathVariable Long id) {

        postService.deletePost(id);

        return ResponseEntity.ok("Post deleted successfully");
    }

    private PostResponse toResponse(Post post) {

        UserResponse userResponse = new UserResponse(
                post.getUser().getId(),
                post.getUser().getUsername(),
                post.getUser().getEmail()
        );

        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt() != null
                        ? post.getCreatedAt().toString()
                        : null,
                post.getUpdatedAt() != null
                        ? post.getUpdatedAt().toString()
                        : null,
                userResponse
        );
    }
}