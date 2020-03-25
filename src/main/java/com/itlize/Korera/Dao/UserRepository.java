package com.itlize.Korera.Dao;

import com.itlize.Korera.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
