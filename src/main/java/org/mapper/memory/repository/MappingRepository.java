package org.mapper.memory.repository;

import org.mapper.memory.entity.UserAndQAMapping;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MappingRepository extends ReactiveCrudRepository<UserAndQAMapping, Long> {
}
