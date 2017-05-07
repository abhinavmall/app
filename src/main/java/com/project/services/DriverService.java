package com.project.services;

import java.util.List;

import com.project.dto.Customer;
import com.project.dto.Driver;

public interface DriverService {
	public List<Driver> getAllDrivers();
	public void markBusy(Driver driver);
	public Driver getNearestAvailableDriver(Customer customer);
}
