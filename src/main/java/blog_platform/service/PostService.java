package blog_platform.service;

import java.util.List;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;

import blog_platform.entity.Post;
import blog_platform.entity.User;
import blog_platform.repository.PostRepository;
import blog_platform.repository.UserRepository;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository,
                       UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }
    public Post createPost(Post post, String username) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        post.setUser(user);

        return postRepository.save(post);
    }
   

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Post not found"
                        )
                );
    }
    

    public Post updatePost(Long id, Post updatedPost) {

        Post existingPost = getPostById(id);

        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());

        return postRepository.save(existingPost);
    }

    public void deletePost(Long id) {

        Post post = getPostById(id);

        postRepository.delete(post);
    }
}