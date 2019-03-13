package org.mapper.memory.repository;

import org.mapper.memory.entity.Subscribed;
import org.springframework.data.repository.CrudRepository;

public interface SubscribedNonReactiveRepo extends CrudRepository<Subscribed, String> {
}
