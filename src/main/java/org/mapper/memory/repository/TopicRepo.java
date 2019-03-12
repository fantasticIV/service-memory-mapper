package org.mapper.memory.repository;

import org.mapper.memory.entity.Topics;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TopicRepo extends ReactiveCrudRepository<Topics, String> {
}
