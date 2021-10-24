package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * Kacey morris and Alex vergara
 * Milestone
 * 10/22/2021
 */
public class ProductModel {
	
	@NotNull(message="Vacation Name is a required field")
	@Size(min=3, max=32, message="Vacation Name must be between 3 and 32 characters")
	private String vacationName;

	@NotNull(message="Price is a required field")
	private int price;
	
	@NotNull(message="Location is a required field")
	@Size(min=2, max=50, message="Location must be between 2 and 50 characters")
	private String location;
	
	@Size(min=2, max=50, message="Description must be between 2 and 50 characters")
	private String details;
	
	private int availability;
	
	@NotNull(message="Location is a required field")
	@Size(min=2, max=50, message="Description must be between 2 and 50 characters")
	private String contact;
	
	public ProductModel()
	{}
	
	public ProductModel(String vacationName2, int price2, String location2, String details2, int availability2, String contact2) {
		vacationName = vacationName2;
		price = price2;
		location = location2;
		details = details2;
		availability = availability2;
		contact = contact2;
	}
	
	public String toString() {
		return "Product Model [Vacation Name = " + this.vacationName + " price = " + this.price + " , this.location = " + this.location + "]";
	}
	
	public String getVacationName() {
		return vacationName;
	}

	public void setVacationName(String vacationName) {
		this.vacationName = vacationName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
}