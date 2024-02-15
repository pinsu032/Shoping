package com.uj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.uj.entity.Customer;

import jakarta.transaction.Transactional;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	@Query("UPDATE CUSTOMER SET  name = ? WHERE id = ?")
	@Transactional
	@Modifying
	void updateCustomerName(String name, Integer id);

	@Query("DELETE FROM CUSTOMER WHERE id = ?")
	@Transactional
	@Modifying
	void removeCustomer(Integer id);
}
