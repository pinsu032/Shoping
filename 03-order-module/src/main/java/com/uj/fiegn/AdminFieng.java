package com.uj.fiegn;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "admin-module/admin")
public interface AdminFieng {

	@PutMapping("/update_qty/{id}/{qty}")
	public String updateProductQuantity(@PathVariable("id") Integer id,@PathVariable("qty") Integer qty);

	@GetMapping("/qty/{pid}")
	public Integer getQuantity(@PathVariable("pid") Integer qty);
}
