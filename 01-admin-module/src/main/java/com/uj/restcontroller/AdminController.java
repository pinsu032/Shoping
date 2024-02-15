package com.uj.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uj.dto.ProductResponse;
import com.uj.dto.RoleChange;
import com.uj.dto.StockResponse;
import com.uj.entity.Product;
import com.uj.entity.ProductCategory;
import com.uj.service.IAdminOperation;

@RestController
@RequestMapping("/admin")
public class AdminController {

	private IAdminOperation service;
	
	@Autowired
	public AdminController(IAdminOperation service) {
		this.service = service;
	}
	
	//category operation
	@PostMapping("/create")
	public ResponseEntity<String> saveCategory(@RequestBody ProductCategory category){
		Boolean saveCategory = service.saveCategory(category);
		if(saveCategory) {
			return new ResponseEntity<String>(category.getCategory()+" Category saved",HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>(category.getCategory()+" Category not saved",HttpStatus.OK);
		}
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<String> upadateCategory(@PathVariable("id") Integer id,
			@RequestBody ProductCategory category){
		Boolean updateCategory = service.updateCategory(id, category);
		if(updateCategory) {
			return new ResponseEntity<String>(category.getCategory()+" Category updated",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>(category.getCategory()+" Category not updated",HttpStatus.OK);
		}
	} 
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteCategoryById(@PathVariable("id") Integer id) {
		Integer deleteCategoryById = service.deleteCategoryById(id);
		if(deleteCategoryById!=null)
			return new ResponseEntity<String>("Category deleted of id "+id,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Category not deleted of id "+id,HttpStatus.OK);

	}
	
	@DeleteMapping("deleteAll")
	public ResponseEntity<String> deleteAllCategory() {
		service.deleteAllCategory();
		
		return new ResponseEntity<String>("All Category deleted",HttpStatus.OK);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable("id") Integer id) {
		ProductCategory productCategory = service.getCategoryById(id);
		if(productCategory!=null)
			return new ResponseEntity<ProductCategory>(productCategory,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Something Went wrong...",HttpStatus.OK);

	}
	
	@GetMapping("getAll")
	public ResponseEntity<?> getAllCategory() {
		List<ProductCategory> allCategory = service.getAllCategory();
		if(!allCategory.isEmpty())
			return new ResponseEntity<List<ProductCategory>>(allCategory,HttpStatus.OK);
		else {
			return new ResponseEntity<String>("Something went wrong...",HttpStatus.OK);

		}
	}
	
	@GetMapping("/categories")
	public ResponseEntity<?> getCategories(){
		List<String> categories = service.getCategories();
		return new ResponseEntity<List<String>>(categories,HttpStatus.OK); 
	}
	
	
	//product operation
	@PostMapping("/create_p")
	public ResponseEntity<String> saveProduct(@RequestBody Product product){
		Boolean saveProduct = service.saveProduct(product);
		if(saveProduct) {
			return new ResponseEntity<String>(product.getProductName()+" Product saved",HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>(product.getProductName()+" Product not saved",HttpStatus.OK);
		}
	}
	
	@PutMapping("update_p/{id}")
	public ResponseEntity<String> upadateProduct(@PathVariable("id") Integer id,
			@RequestBody Product product){
		Boolean updateProduct = service.updateProduct(id, product);
		if(updateProduct) {
			return new ResponseEntity<String>(product.getProductName()+" Product updated",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>(product.getProductName()+" Product not updated",HttpStatus.OK);
		}
	} 
	
	@DeleteMapping("delete_p/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable("id") Integer id) {
		Integer deleteProductById = service.deleteProductById(id);
		if(deleteProductById!=null)
			return new ResponseEntity<String>("Product deleted of id "+id,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Product not deleted of id "+id,HttpStatus.OK);

	}
	
	@DeleteMapping("deleteAll_p")
	public ResponseEntity<String> deleteAllProduct() {
		service.deleteAllProduct();
		
		return new ResponseEntity<String>("All Product deleted",HttpStatus.OK);
	}
	
	@GetMapping("get_p/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") Integer id) {
		Product product = service.getProductById(id);
		if(product!=null)
			return new ResponseEntity<Product>(product,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Something Went wrong...",HttpStatus.OK);

	}
	
	@GetMapping("getAll_p")
	public ResponseEntity<?> getAllProduct() {
		List<ProductResponse> allProduct = service.getAllProduct();
		if(!allProduct.isEmpty())
			return new ResponseEntity<List<ProductResponse>>(allProduct,HttpStatus.OK);
		else {
			return new ResponseEntity<String>("Something went wrong...",HttpStatus.OK);

		}
	}
	
	@PutMapping("/role/{id}")
	public ResponseEntity<String> changeRole(@PathVariable("id") Integer id,@RequestBody RoleChange role){
		String grantRoleOfUser = service.grantRoleOfUser(id, role);
		
		return new ResponseEntity<String>(grantRoleOfUser,HttpStatus.OK);
	}
	
	@GetMapping("fetch/{category}")
	public ResponseEntity<?> getProductByCategory(@PathVariable("category") String category){
		List<ProductResponse> productByCategory = service.getProductByCategory(category);
		return new ResponseEntity<List<ProductResponse>>(productByCategory,HttpStatus.OK);
	}
	
	@GetMapping("stock/{pid}")
	public ResponseEntity<?> getProductByCategory(@PathVariable("pid") Integer pid){
		StockResponse checkStocck = service.checkStocck(pid);
		return new ResponseEntity<StockResponse>(checkStocck,HttpStatus.OK);
	}
	
	@PutMapping("/update_qty/{id}/{qty}")
	public ResponseEntity<?> updateQuantity(@PathVariable("id") Integer id,@PathVariable Integer qty){
		Boolean updateQuantity = service.updateQuantity(id, qty);
		if(updateQuantity) {
			return new ResponseEntity<String>("Quantity updated..",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Quantity updated..",HttpStatus.OK);

		}
	}
	
	@GetMapping("/qty/{pid}")
	public ResponseEntity<?> getQuantity(@PathVariable("pid") Integer id){
		Integer qunatity = service.getQunatity(id);
		return new ResponseEntity<Integer>(qunatity,HttpStatus.OK);
	}
	
}
