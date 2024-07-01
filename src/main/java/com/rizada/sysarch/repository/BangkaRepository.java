package com.rizada.sysarch.repository;

import com.rizada.sysarch.model.Bangka;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BangkaRepository extends MongoRepository<Bangka, String> {
    List<Bangka> findByBangkaNameContainingIgnoreCase(String bangkaName);
}