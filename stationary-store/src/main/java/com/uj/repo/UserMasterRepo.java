package com.uj.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uj.entity.UsersMaster;

public interface UserMasterRepo extends JpaRepository<UsersMaster, Integer> {

	Optional<UsersMaster> findByEmail(String email);

	UsersMaster findByEmailAndPassword(String email, String password);

}
