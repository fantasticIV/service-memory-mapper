package org.mapper.memory.repository;

import org.mapper.memory.entity.QAEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface QARepository extends ReactiveCrudRepository<QAEntity, Long> {

}
