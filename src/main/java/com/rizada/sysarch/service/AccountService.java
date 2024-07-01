package com.rizada.sysarch.service;

import com.rizada.sysarch.dto.LoginRequest;
import com.rizada.sysarch.dto.SignUpRequest;
import com.rizada.sysarch.model.User;
import com.rizada.sysarch.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    public User registerUser(SignUpRequest signUpRequest) throws Exception {
        logger.info("Signing up user: {}", signUpRequest.getUsername());

        if (signUpRequest.getUsername() == null || signUpRequest.getPassword() == null || signUpRequest.getEmail() == null) {
            throw new Exception("Username, password, or email cannot be null");
        }

        Optional<User> existingUser = accountRepository.findByUsername(signUpRequest.getUsername());
        if (existingUser.isPresent()) {
            throw new Exception("Username already exists");
        }

        User user = new User();
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword())); // Encrypt password before saving
        user.setEmail(signUpRequest.getEmail());

        logger.info("User signed up: {}", user.getUsername());
        return accountRepository.save(user);
    }

    public User authenticateUser(LoginRequest loginRequest) throws Exception {
        logger.info("Logging in user: {}", loginRequest.getUsername());

        Optional<User> userOptional = accountRepository.findByUsername(loginRequest.getUsername());
        User user = userOptional.orElseThrow(() -> new Exception("Invalid username or password"));

        if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            logger.info("Login successful for user: {}", user.getUsername());
            return user; // Successfully logged in
        } else {
            logger.warn("Login failed for user: {}", loginRequest.getUsername());
            throw new Exception("Invalid username or password");
        }
    }
}
