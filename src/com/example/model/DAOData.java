package com.example.model;

import java.util.List;

public interface DAOData {
	public List<Customer> getAllCustomers();
	public void addCustomer(Customer c);
	public void removeCustomer(int id);
	
	public List<Trip> getAllTrips();
	public void addTrip(Trip t);
	public void removeTrip(int id);
}
