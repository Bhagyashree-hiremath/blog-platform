package blog_platform.service;

import java.util.List;

import org.springframework.stereotype.Service;

import blog_platform.entity.Comment;
import blog_platform.entity.Post;
import blog_platform.entity.User;
import blog_platform.repository.CommentRepository;
import blog_platform.repository.PostRepository;
import blog_platform.repository.UserRepository;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public CommentService(
            CommentRepository commentRepository,
            UserRepository userRepository,
            PostRepository postRepository) {

        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public Comment createComment(
            String content,
            String username,
            Long postId) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Post post = postRepository.findById(postId)
                .orElseThrow(() ->
                        new RuntimeException("Post not found"));

        Comment comment = new Comment();

        comment.setContent(content);
        comment.setUser(user);
        comment.setPost(post);

        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByPost(Long postId) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() ->
                        new RuntimeException("Post not found"));

        return commentRepository.findByPost(post);
    }

    public Comment getCommentById(Long id) {

        return commentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Comment not found"));
    }

    public Comment updateComment(
            Long id,
            String content) {

        Comment existingComment = getCommentById(id);

        existingComment.setContent(content);

        return commentRepository.save(existingComment);
    }

    public void deleteComment(Long id) {

        Comment comment = getCommentById(id);

        commentRepository.delete(comment);
    }
}