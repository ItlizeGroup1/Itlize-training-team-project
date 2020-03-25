package com.itlize.korera.Dao;

import com.itlize.korera.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User1, Integer> {
}
