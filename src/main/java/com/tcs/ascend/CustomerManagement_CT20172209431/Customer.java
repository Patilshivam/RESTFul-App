package com.tcs.ascend.CustomerManagement_CT20172209431;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Customer {

	@Id
	private int customerId;
	
	@Column
	private String ssnId;
	
	@Column
	private String customerName;
	
	@Column
	private int age;
	
	@Column
	private String address;
	
	@Column
	private String state;
	
	@Column
	private String city;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getSsnId() {
		return ssnId;
	}

	public void setSsnId(String ssnId) {
		this.ssnId = ssnId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "[customerId:" + customerId + ", ssnId:" + ssnId + ", customerName:" + customerName + ", age:"
				+ age + ", address:" + address + ", state:" + state + ", city:" + city + "]";
	}
}
