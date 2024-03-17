package com.uj.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uj.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

  Optional<User>	findByEmail(String email);
}
