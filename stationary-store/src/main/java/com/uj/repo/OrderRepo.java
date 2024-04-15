package com.uj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uj.entity.OrderProduct;

public interface OrderRepo extends JpaRepository<OrderProduct, Integer> {

}
