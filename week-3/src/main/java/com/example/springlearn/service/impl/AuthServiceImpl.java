package com.example.springlearn.service.impl;

import com.example.springlearn.model.AuthRequest;
import com.example.springlearn.model.AuthResponse;
import com.example.springlearn.security.JwtTokenUtil;
import com.example.springlearn.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class AuthServiceImpl implements AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    private final JwtTokenUtil jwtTokenUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(JwtTokenUtil jwtTokenUtil, PasswordEncoder passwordEncoder) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        logger.info("Authenticating user: {}", authRequest.getUsername());

        if ("admin".equals(authRequest.getUsername()) && "admin123".equals(authRequest.getPassword())) {
            // Use fully qualified name for Spring Security User
            org.springframework.security.core.userdetails.User userDetails = 
                new org.springframework.security.core.userdetails.User(
                    "admin",
                    "admin123",
                    java.util.Collections.emptyList()
                );
            
            String token = jwtTokenUtil.generateToken(userDetails);
            return new AuthResponse(token, "admin", "ROLE_USER", "Login successful");
        }
        throw new RuntimeException("Invalid credentials");
    }

    @Override
    @Transactional
    public String registerUser(AuthRequest authRequest) {
        logger.info("Registering user: {}", authRequest.getUsername());

        // Use fully qualified name for our User entity
        Long count = entityManager.createQuery(
            "SELECT COUNT(u) FROM User u WHERE u.username = :username", Long.class)
            .setParameter("username", authRequest.getUsername())
            .getSingleResult();

        if (count > 0) {
            throw new RuntimeException("Username already exists: " + authRequest.getUsername());
        }

        com.example.springlearn.model.User user = new com.example.springlearn.model.User();
        user.setUsername(authRequest.getUsername());
        user.setPassword(passwordEncoder.encode(authRequest.getPassword()));
        user.setEmail(authRequest.getUsername() + "@test.com");
        user.setFirstName("Test");
        user.setLastName("User");
        user.setRole("USER");
        user.setIsActive(true);

        entityManager.persist(user);
        return "User registered successfully: " + authRequest.getUsername();
    }
}