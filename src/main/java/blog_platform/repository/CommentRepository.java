package blog_platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import blog_platform.entity.Comment;
import blog_platform.entity.Post;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPost(Post post);
}