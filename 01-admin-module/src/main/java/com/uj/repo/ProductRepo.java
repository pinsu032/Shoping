package com.uj.repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uj.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	@Query(value = "select * from product where category_id=?",nativeQuery = true)
	Set<Product> getByCategoryId(Integer id);

	List<Product> findByProductCategory_Category(String categoryName);

}
