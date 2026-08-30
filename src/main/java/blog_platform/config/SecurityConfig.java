package blog_platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;
@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .securityContext(securityContext -> securityContext
                .requireExplicitSave(false)
            )

            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/",
                    "/index.html",
                    "/login.html",
                    "/register.html",
                    "/style.css",
                    "/script.js",
                    "/login.js",
                    "/register.js",
                    "/post.html",
                    "/post.js"
                ).permitAll()

                .requestMatchers("/api/auth/**").permitAll()

                .requestMatchers(HttpMethod.POST, "/api/comments").authenticated()
                .requestMatchers(HttpMethod.POST, "/api/posts").authenticated()
                .anyRequest().permitAll()
            );

        return http.build();
    }
}