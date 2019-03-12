package org.mapper.memory.repository;

import org.mapper.memory.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepo extends ReactiveCrudRepository<User, String> {
}
