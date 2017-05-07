package com.project.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.dto.Customer;
import com.project.dto.Driver;

@Repository
public class OrderRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void order(Driver driver, Customer customer){
		String sql = "insert into orders"
				+ "(customer_name, customer_latitude, customer_longitude, driver_id) "
				+ "values(?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[]{
			customer.getName(), customer.getLatitude(), customer.getLongitude(),
			driver.getId()
		});
	}
}
