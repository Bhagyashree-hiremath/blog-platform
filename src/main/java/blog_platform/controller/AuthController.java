package blog_platform.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import blog_platform.entity.User;
import blog_platform.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody User user) {

        User savedUser = userService.registerUser(user);

        UserResponse response = new UserResponse(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail()
        );

        return ResponseEntity.ok(response);
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody LoginRequest request) {

        User user = userService.loginUser(
                request.getUsername(),
                request.getPassword()
        );

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        null,
                        java.util.Collections.emptyList()
                );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        AuthResponse response = new AuthResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );

        return ResponseEntity.ok(response);
    }
}
   