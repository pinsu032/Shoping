package com.uj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uj.entity.UsersMaster;

public interface UserMasterRepo extends JpaRepository<UsersMaster, Integer> {

	UsersMaster findByMobile(Long mobile);

	UsersMaster findByMobileAndPassword(Long mobile, String password);

}
