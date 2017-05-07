package com.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.Customer;
import com.project.dto.Driver;
import com.project.repository.DriverRepository;
import com.project.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void bookCab(Customer customer, Driver driver) {
		this.orderRepository.order(driver, customer);
		this.driverRepository.markBusy(driver);
	}
}
