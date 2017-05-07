package com.project.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.Customer;
import com.project.dto.Driver;
import com.project.repository.DriverRepository;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverRepository driverRepository;
	
	@Override
	public List<Driver> getAllDrivers() {
		return this.driverRepository.findAll();
	}

	@Override
	public void markBusy(Driver driver) {
		this.driverRepository.markBusy(driver);		
	}

	@Override
	public Driver getNearestAvailableDriver(Customer customer) {
		// TODO Get nearest driver as per geo coordinates.
		List<Driver> availableDrivers = this.driverRepository.findAllAvailable();
		availableDrivers = this.calculateDriverPassengerDistance(customer, availableDrivers);
		return availableDrivers.get(0);
	}
	
	private List<Driver> calculateDriverPassengerDistance(Customer customer, List<Driver> availableDrivers) {
		List<Driver> drivers = new ArrayList<Driver>();
		for (Driver driver : availableDrivers) {
			driver.setDistanceFromPassenger(
					this.distance(driver.getLatitude(),
							driver.getLongitude(),
							customer.getLatitude(),
							customer.getLongitude()));
			drivers.add(driver);		
		}
		Collections.sort(availableDrivers, new DriverDistanceComparator());
		return drivers;
	}

	private double distance(double lat1, double lon1, double lat2, double lon2) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) 
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) 
				* Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		return dist;
	}
	
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
	
	class DriverDistanceComparator implements Comparator<Driver>{
		@Override
		public int compare(Driver o1, Driver o2) {
			if(o1.getDistanceFromPassenger() >= o2.getDistanceFromPassenger())
				return 1;
			else
				return -1;
		}
		
	}
}
