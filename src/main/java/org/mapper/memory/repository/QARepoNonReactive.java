package org.mapper.memory.repository;

import org.mapper.memory.entity.QAEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QARepoNonReactive extends MongoRepository<QAEntity, Long> {
}
