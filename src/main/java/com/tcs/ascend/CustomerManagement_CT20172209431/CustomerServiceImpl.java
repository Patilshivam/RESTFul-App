package com.tcs.ascend.CustomerManagement_CT20172209431;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo customerRepository;

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}
	
	@Override
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		Optional<Customer> result = customerRepository.findById(id);
		
		Customer theCustomer = null;
		
		if (result.isPresent()) {
			theCustomer = result.get();
		} else {
//			throw new RuntimeException("Not Present");
		}
		return theCustomer;
	}

	@Override
	public void save(Customer theCustomer) {
		// TODO Auto-generated method stub
		customerRepository.save(theCustomer);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
	}
}
