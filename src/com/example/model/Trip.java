package com.example.model;

import java.util.Date;

public class Trip {
	int id;
	String destination;
	String startDate;
	String endDate;
	String price;
	String discount;

	public Trip(int id, String destination, String startDate, String endDate,
			String price, String discount) {
		super();
		this.id = id;
		this.destination = destination;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.discount = discount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

}
