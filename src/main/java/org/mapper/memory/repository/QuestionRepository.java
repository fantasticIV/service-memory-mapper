package org.mapper.memory.repository;

import org.mapper.memory.entity.Question;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface QuestionRepository extends ReactiveCrudRepository<Question, String> {
    public Mono<Question> findOneByQuesId(Long id);
}
