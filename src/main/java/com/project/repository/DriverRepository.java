package com.project.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.project.dto.Driver;

@Repository
public class DriverRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Driver> findAll() {
		return jdbcTemplate.query("select * from driver as d LEFT JOIN orders as o ON o.driver_id = d.id ", 
				new DriverRowMapper());
	}
	
	public List<Driver> findAllAvailable() {
		return jdbcTemplate.query("select * from driver as d LEFT JOIN orders as o ON o.driver_id = d.id "
				+ "WHERE d.status = 'AVAILABLE'", 
				new DriverRowMapper());
	}
	
	public void markBusy(Driver driver){
		String sql = "UPDATE driver set driver.status = 'BUSY' where driver.id = ?";
		this.jdbcTemplate.update(sql, driver.getId());
	}
	
	public void markAvailable(Driver driver){
		String sql = "UPDATE driver set driver.status = 'AVAILABLE' where driver.id = ?";
		this.jdbcTemplate.update(sql, driver.getId());
	}
}

class DriverRowMapper implements RowMapper<Driver>
{
    @Override
    public Driver mapRow(ResultSet rs, int rowNum) throws SQLException {
        Driver driver = new Driver();
        driver.setId(rs.getInt("id"));
        driver.setName(rs.getString("name"));
        driver.setEmail(rs.getString("email"));
        driver.setLatitude(rs.getDouble("latitude"));
        driver.setLongitude(rs.getDouble("longitude"));
        driver.setStatus(rs.getString("status"));
        driver.setPassenger(rs.getString("customer_name"));
        return driver;
    }
}