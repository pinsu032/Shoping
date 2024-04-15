package com.uj.service;

import java.util.List;

import com.uj.dto.ProductResponse;
import com.uj.dto.RoleChange;
import com.uj.dto.StockResponse;
import com.uj.entity.Product;
import com.uj.entity.ProductCategory;

public interface IAdminOperation {

	//category operation
	Boolean saveCategory(ProductCategory category);

	Boolean updateCategory(Integer id, ProductCategory category);

	Integer deleteCategoryById(Integer id);

	void deleteAllCategory();

	ProductCategory getCategoryById(Integer id);

	List<ProductCategory> getAllCategory();
	
	List<String> getCategories();
	
	List<ProductResponse> getProductByCategory(String categoryName);
	
	//product operation
	Boolean saveProduct(Product product);

	Boolean updateProduct(Integer id, Product product);

	Integer deleteProductById(Integer id);

	void deleteAllProduct();

	Product getProductById(Integer id);

	List<ProductResponse> getAllProduct();
	
	//provide role
	
	//String grantRoleOfUser(Integer id,RoleChange role);
	
	StockResponse checkStocck(Integer pid);
	
	Boolean updateQuantity(Integer id,Integer qty);
	
	Integer getQuantity(Integer id);

}
