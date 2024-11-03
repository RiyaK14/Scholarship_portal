package com.example.rospl;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface Repository extends MongoRepository<Modell, String> {
    @Query(value = "{}", fields = "{ 'name' : 1, 'email' : 1, 'contact' : 1, 'course' : 1 }")
    List<ModelProjection> findAllProjectedBy();

    // Optional<Student> findByUsername(String username);
    List<ModelProjection> findByoppId(String Id);

    @Query(value = "{}", fields = "{ 'oppId' : 1 }") // Retrieve only field1
    List<ModelProjection> findBystudid(String Id);

}
