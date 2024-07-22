package org.example.asterixapi;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsterixRepo extends MongoRepository<Character, String> {
}
