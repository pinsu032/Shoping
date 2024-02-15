package com.uj.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public boolean save() {
		
		//String sql =  "insert into user  values(?, ?, ?)";
		int result= template.update("INSERT INTO EMPLOYEE VALUES (?, ?, ?)",101,"PINSU","HYD");
		if(result > 0)
			return true;
		
		return false;
	}

	@Override
	public Integer getEmployee() {
		Integer count = template.queryForObject("SELECT count(*) FROM EMPLOYEE", Integer.class);
		return count;
	}

}
