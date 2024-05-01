package com.uj.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uj.entity.OrderProduct;

public interface OrderRepo extends JpaRepository<OrderProduct, Integer> {

	List<OrderProduct> findByUserId(String email);
}
