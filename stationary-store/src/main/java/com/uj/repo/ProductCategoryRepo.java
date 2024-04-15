package com.uj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uj.entity.ProductCategory;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Integer>{

	ProductCategory findByCategory(String category);
}
