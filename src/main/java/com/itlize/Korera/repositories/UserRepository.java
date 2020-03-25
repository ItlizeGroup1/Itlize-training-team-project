package com.itlize.Korera.repositories;

import com.itlize.Korera.dbModels.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
