package com.programmingfree.model;

public class Customers {

	public Customers(String customerid,String customername,String email,String phone,String city){
		this.customerid=customerid;
		this.customername=customername;
		this.email=email;
		this.phone=phone;
		this.city=city;
	}
	private String customerid;
	private String customername;
	private String email;
	private String phone;
	private String city;
	
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomername() {
		return customername;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCity() {
		return city;
	}
}
