package org.mapper.memory.repository;

import org.mapper.memory.entity.Subscribed;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface SubscribedRepo extends ReactiveCrudRepository<Subscribed, String> {
}
