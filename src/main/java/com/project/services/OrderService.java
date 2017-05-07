package com.project.services;

import com.project.dto.Customer;
import com.project.dto.Driver;

public interface OrderService {
	public void bookCab(Customer customer, Driver driver);
}
