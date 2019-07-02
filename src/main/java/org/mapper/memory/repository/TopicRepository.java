package org.mapper.memory.repository;

import org.mapper.memory.entity.Topic;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends ReactiveCrudRepository<Topic, String> {
}
