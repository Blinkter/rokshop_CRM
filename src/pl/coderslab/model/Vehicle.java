package pl.coderslab.model;

import java.sql.Date;

public class Vehicle {

	private int id;
	private String brand;
	private String model;
	private int year;
	private String reg_number;
	private Date next_service;
	private int customer_id;

	public Vehicle(String brand, String model, int year, String reg_number, Date next_service, int customer_id) {
		setBrand(brand);
		setModel(model);
		setYear(year);
		setReg_number(reg_number);
		setNext_service(next_service);
		setCustomer_id(customer_id);
	}

	public Vehicle() {
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getReg_number() {
		return reg_number;
	}

	public void setReg_number(String reg_number) {
		this.reg_number = reg_number;
	}

	public Date getNext_service() {
		return next_service;
	}

	public void setNext_service(Date next_service) {
		this.next_service = next_service;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", brand=" + brand + ", model=" + model + ", year=" + year + ", reg_number="
				+ reg_number + ", next_service=" + next_service + ", customer_id=" + customer_id + "]";
	}

}
