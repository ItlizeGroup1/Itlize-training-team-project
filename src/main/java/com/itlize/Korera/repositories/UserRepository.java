package com.itlize.Korera.repositories;

import com.itlize.Korera.dbModels.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
