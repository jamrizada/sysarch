package com.rizada.sysarch.repository;

import com.rizada.sysarch.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}