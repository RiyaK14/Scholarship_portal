package com.example.rospl;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface Repostud extends MongoRepository<Student, String> {
    Optional<Student> findByUsername(String username);
    // @Query(value = "{}", fields = "{ 'name' : 1, 'email' : 1, 'contact' : 1, 'course' : 1 }")
    // List<ModelProjection> findAllProjectedBy();

    // Optional<Student> findByUsername(String username);
}
