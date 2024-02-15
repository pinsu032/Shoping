package com.uj.fiegn;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.uj.dto.RoleChange;

@FeignClient(name = "users-details/user")
public interface UserFiegnClinet {

	@PutMapping("/change/{id}")
	public String changeRole(@PathVariable("id") Integer id,@RequestBody RoleChange role);
}
