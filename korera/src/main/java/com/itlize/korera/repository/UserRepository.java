package com.itlize.korera.repository;

import com.itlize.korera.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer > {

}
