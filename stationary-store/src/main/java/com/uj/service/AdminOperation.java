package com.uj.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uj.dto.ProductResponse;
import com.uj.dto.StockResponse;
import com.uj.entity.Product;
import com.uj.entity.ProductCategory;
import com.uj.repo.ProductCategoryRepo;
import com.uj.repo.ProductRepo;

@Service
public class AdminOperation implements IAdminOperation {
	
	
	private ProductCategoryRepo cRepo;
	
	private ProductRepo pRepo;
		
	private static List<ProductCategory> allcategories = new ArrayList<>();
	private static List<String> categories = new ArrayList<>();
	
	@Autowired
	public AdminOperation(ProductCategoryRepo cRepo
			, ProductRepo pRepo) {
		this.cRepo = cRepo;
		this.pRepo = pRepo;
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

		if(!categories.isEmpty())
			categories.clear();
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
	public Boolean updateProduct(Integer id, ProductResponse res) {
		Optional<Product> opt = pRepo.findById(id);
		if(opt.isPresent()) {
			Product product = opt.get();
			System.out.println(res.getQuantity());
			product.setQuantity(res.getQuantity());
			
			Product save = pRepo.save(product);
			return save.getPid()!=null;
		}
		return false;
		
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
			pr.setProductName(product.getProductName());
			pr.setProductPrice(product.getProductPrice());
			pr.setFilePath(product.getFilePath());
			pr.setQuantity(product.getQuantity());
			pr.setCategory(product.getProductType());
			if(product.getQuantity()>0) {
				pr.setStockStatus("Available");
				pr.setStock(true);
			}else {
				pr.setStockStatus("Out Of Stock");
				pr.setStock(false);
			}
			prList.add(pr);
		});
		if(!prList.isEmpty())
		     return prList;
		else
			return null;
	}

//	@Override
//	public String grantRoleOfUser(Integer id,RoleChange role) {
//        String changeRole = client.changeRole(id, role);
//		return changeRole;
//	}
	
	@Override
	public StockResponse checkStocck(Integer pid,Integer noOfProduct) {
		Optional<Product> findById = pRepo.findById(pid);
		StockResponse stockResponse = new StockResponse();
		if (findById.isPresent()) {
			Product product = findById.get();
			Integer quantity = product.getQuantity();

			if (noOfProduct != 0) {
				if (quantity != null && quantity != 0 && quantity >= noOfProduct) {
					stockResponse.setProductName(product.getProductName());
					stockResponse.setQty(quantity);
					stockResponse.setStock("Available");
				} else {
					stockResponse.setProductName(product.getProductName());
					stockResponse.setQty(quantity);
					stockResponse.setStock("Not Available");
				}
				return stockResponse;

			} else {
				stockResponse.setProductName(product.getProductName());
				stockResponse.setQty(quantity);
				stockResponse.setStock("Please Enter quantity..");
				return stockResponse;
			}
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
	public Integer getQuantity(Integer id) {
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
