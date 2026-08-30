package blog_platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import blog_platform.entity.Post;
import blog_platform.entity.User;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUser(User user);
}