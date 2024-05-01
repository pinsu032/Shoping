package com.uj.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import com.uj.entity.ProductCategory;
import com.uj.repo.ProductCategoryRepo;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {
	
	@Mock
	private ProductCategoryRepo cRepo;
	private AdminOperation adminService;

	@BeforeAll
	public static void init() {
	    
	}
	
	@BeforeEach
	public void setUp() {
		//MockitoAnnotations.openMocks(cRepo);
		adminService = new AdminOperation(cRepo, null);
	}
	
	@Test
	public void saveCategoryTest() {
		ProductCategory expected = new ProductCategory();
		expected.setId(101);
		expected.setCategory("BOOK");
		
		ProductCategory request = new ProductCategory();
		request.setCategory("BOOK");
		
		when(cRepo.save(request)).thenReturn((expected));
		Boolean saveCategory = adminService.saveCategory(request);
		
		assertEquals(expected.getId()!= null, saveCategory);
	}
}
