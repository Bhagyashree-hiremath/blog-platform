package blog_platform.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import blog_platform.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}