package com.uj.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uj.dto.ProductResponse;
import com.uj.dto.RoleChange;
import com.uj.dto.StockResponse;
import com.uj.entity.Product;
import com.uj.entity.ProductCategory;
import com.uj.fiegn.UserFiegnClinet;
import com.uj.repo.ProductCategoryRepo;
import com.uj.repo.ProductRepo;

@Service
public class AdminOperation implements IAdminOperation {
	
	
	private ProductCategoryRepo cRepo;
	
	private ProductRepo pRepo;
	
	private UserFiegnClinet client;
	
	private static List<ProductCategory> allcategories;
	private static List<String> categories = new ArrayList<>();
	
	@Autowired
	public AdminOperation(ProductCategoryRepo cRepo
			, ProductRepo pRepo , UserFiegnClinet client) {
		this.cRepo = cRepo;
		this.pRepo = pRepo;
		this.client = client;
	}
	

	@Override
	public Boolean saveCategory(ProductCategory category) {
		ProductCategory save = cRepo.save(category);
		return save.getId()!= null;
	}

	@Override
	public Boolean updateCategory(Integer id, ProductCategory category) {
		Optional<ProductCategory> opt = cRepo.findById(id);
		if (opt.isPresent()) {
			ProductCategory productCategory = opt.get();
			category.setId(productCategory.getId());
			BeanUtils.copyProperties(category, productCategory);
			cRepo.save(productCategory);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Integer deleteCategoryById(Integer id) {
		if(cRepo.existsById(id)) {
			cRepo.deleteById(id);
			return id;
		}
		return null;
	}

	@Override
	public void deleteAllCategory() {
		cRepo.deleteAll();
	}

	@Override
	public ProductCategory getCategoryById(Integer id) {
        Optional<ProductCategory> opt = cRepo.findById(id); 
        if(opt.isPresent()) {
        	ProductCategory productCategory = opt.get();
        	Set<Product> pSet = pRepo.getByCategoryId(productCategory.getId());
        	//productCategory.setProduct(pSet);
        	ProductCategory cat = new ProductCategory();
        	
        	BeanUtils.copyProperties(productCategory, cat);
        	cat.setProduct(pSet);
        	return cat;
        }
		return null;
	}

	@Override
	public List<ProductCategory> getAllCategory() {
		allCategory();
		if(!allcategories.isEmpty())
		     return allcategories;
		else
			return null;
	}
	
	private void allCategory(){
		allcategories = cRepo.findAll();

		allcategories.forEach(category -> {
			categories.add(category.getCategory());
		});
	}
	
	@Override
	public List<String> getCategories() {
		allCategory();
		return categories;
	}
	
	@Override
	public List<ProductResponse> getProductByCategory(String categoryName) {
        List<Product> findByProductCategory_Category = pRepo.findByProductCategory_Category(categoryName);
		if(!findByProductCategory_Category.isEmpty()) {
			List<ProductResponse> response = new ArrayList<>();
			findByProductCategory_Category.forEach(product -> {
				ProductResponse pr = new ProductResponse();
				BeanUtils.copyProperties(product, pr);
				response.add(pr);
			});
			return response;
		}
        return null;
	}

	@Override
	public Boolean saveProduct(Product product) {
		String category = product.getProductType();
		ProductCategory productCategory = cRepo.findByCategory(category);
		
		ProductCategory pCategory = new ProductCategory();
		pCategory.setId(productCategory.getId());
		
		product.setProductCategory(pCategory);
		Product save = pRepo.save(product);
		return save.getPid()!= null;
	}

	@Override
	public Boolean updateProduct(Integer id, Product product) {
		Optional<Product> opt = pRepo.findById(id);
		String category = product.getProductType();
		ProductCategory productCategory = cRepo.findByCategory(category);
		
		ProductCategory pCategory = new ProductCategory();
		pCategory.setId(productCategory.getId());
		
		product.setProductCategory(pCategory);
		if (opt.isPresent()) {
			Product prod = opt.get();
			BeanUtils.copyProperties(product, prod);
			prod.setPid(id);
			pRepo.save(prod);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Integer deleteProductById(Integer id) {
		if(pRepo.existsById(id)) {
			pRepo.deleteById(id);
			return id;
		}
		return null;
	}

	@Override
	public void deleteAllProduct() {
		pRepo.deleteAll();
	}

	@Override
	public Product getProductById(Integer id) {
		Optional<Product> opt = pRepo.findById(id);
        if(opt.isPresent()) {
        	return opt.get();
        }
		return null;
	}

	@Override
	public List<ProductResponse> getAllProduct() {
		List<Product> pList = pRepo.findAll();
		List<ProductResponse> prList = new ArrayList<>();
		pList.forEach(product -> {
			ProductResponse pr = new ProductResponse();
			pr.setPid(product.getPid());
			pr.setProductName(pr.getProductName());
			pr.setProductPrice(product.getProductPrice());
		});
		if(!prList.isEmpty())
		     return prList;
		else
			return null;
	}

	@Override
	public String grantRoleOfUser(Integer id,RoleChange role) {
        String changeRole = client.changeRole(id, role);
		return changeRole;
	}
	
	@Override
	public StockResponse checkStocck(Integer pid) {
		Optional<Product> findById = pRepo.findById(pid);
		if(findById.isPresent()) {
			Product product = findById.get();
			Integer quantity = product.getQuantity();
			StockResponse stockResponse = new StockResponse();
			if(quantity != null && quantity != 0) {
				stockResponse.setProductName(product.getProductName());
				stockResponse.setQty(quantity);
				stockResponse.setStock("Available");
			}else {
				stockResponse.setProductName(product.getProductName());
				stockResponse.setQty(quantity);
				stockResponse.setStock("Not Available");
			}
			return stockResponse;
		}
		return null;
	}

	@Override
	public Boolean updateQuantity(Integer id,Integer qty) {
		Optional<Product> findById = pRepo.findById(id);
		if(findById.isPresent()) {
			Product product = findById.get();
			product.setQuantity(qty);
			pRepo.save(product);
			return true;
		}
		return false;
	}

	@Override
	public Integer getQunatity(Integer id) {
		Optional<Product> findById = pRepo.findById(id);
		Integer qty = null;
		if(findById.isPresent()) {
			Product product = findById.get();
			qty = product.getQuantity();
			return qty;
		}
		return null;
	}
	
	
}
