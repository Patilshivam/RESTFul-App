package com.tcs.ascend.CustomerManagement_CT20172209431;

import java.util.List;

public interface CustomerService {

	public List<Customer> findAll();

	public Customer findById(int id);

	public void save(Customer theCustomer);

	public void deleteById(int id);
}
