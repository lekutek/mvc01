package com.example.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DAODataImplementation implements DAOData {

	private String customersFile = "customers.ser";
	private String tripsFile = "trips.ser";

	private List<Customer> customers = new ArrayList<>();
	private List<Trip> trips = new ArrayList<>();

	private void readData(String fileName) {
		File fc = new File(fileName);
		if (fc.exists()) {
			ObjectInputStream ois;
			try {
				ois = new ObjectInputStream(new FileInputStream(fileName));
				if (fileName.equals(customersFile)) {
					customers = (List<Customer>) ois.readObject();
				} else {
					trips = (List<Trip>) ois.readObject();
				}
				ois.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public DAODataImplementation() {
		readData(customersFile);
		readData(tripsFile);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customers;
	}

	@Override
	public void addCustomer(Customer c) {
		if (customers.size() != 0) {
			c.setId(customers.get(customers.size() - 1).id + 1);
		}
		customers.add(c);
		saveData(customersFile);
	}

	@Override
	public void removeCustomer(int id) {
		int find_id = 0, i;
		for (i = 0; i < customers.size(); i++) {
			if (customers.get(i).id == id)
				find_id = i;
		}
		customers.remove(find_id);
		saveData(customersFile);
	}

	private void saveData(String fileName) {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
			if (fileName.equals(customersFile)) {
				oos.writeObject(customers);
			} else {
				oos.writeObject(trips);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Trip> getAllTrips() {
		return trips;
	}

	@Override
	public void addTrip(Trip t) {
		if (trips.size() != 0) {
			t.setId(trips.get(trips.size() - 1).id + 1);
		}
		trips.add(t);
		saveData(tripsFile);
	}

	@Override
	public void removeTrip(int id) {
		int find_id = 0, i;
		for (i = 0; i < trips.size(); i++) {
			if (trips.get(i).id == id)
				find_id = i;
		}
		trips.remove(find_id);
		saveData(tripsFile);
	}

}
