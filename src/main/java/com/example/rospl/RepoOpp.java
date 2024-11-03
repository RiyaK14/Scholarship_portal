package com.example.rospl;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepoOpp extends MongoRepository<OppModel, String> {
    List<OppModel> findByProviderId(String ProviderId);

    List<OppModel> findByIdIn(List<String> ids);
}