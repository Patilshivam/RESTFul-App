package com.tcs.ascend.CustomerManagement_CT20172209431;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@GetMapping("/6865viewAllCustomers")
	@CrossOrigin
	public List<Customer> findAll(){
		
		List<Customer> customers = service.findAll();
		
		return customers;
	}
	
	@GetMapping("/6865viewCustomerById/{id}")
	@CrossOrigin
	public Customer findById(@PathVariable int id) {
		
		Customer theCustomer = service.findById(id);
		
		if(theCustomer == null) {
			throw new RuntimeException("Not Present");
		}
		return theCustomer;
	}

	@PostMapping("/6865registerCustomer")
	@CrossOrigin
	public String save(@RequestBody Customer theCustomer) {
		
//		if(theCustomer != null) {
//			service.save(theCustomer);
//		} else {
//			return "Customer with ssnid: " + theCustomer.getSsnId() + "  is registered successfully";
//		}
		
		service.save(theCustomer);
		
		return "Customer with ssnid: " + theCustomer.getSsnId() + " is registered successfully";
	}
	
	@PutMapping("/6865updateCustomer")
	@CrossOrigin
	public String update(@RequestBody Customer theCustomer) {
		
		List<Customer> customers = service.findAll();
		
		boolean flag = false;
		for(Customer c: customers) {
			if(c.getCustomerId() == theCustomer.getCustomerId() && c.getSsnId() == theCustomer.getSsnId()) {
				flag = true;
			}
		}
		if(flag) {
			service.save(theCustomer);
		} else {
			return "Customer updation failed for id: " + theCustomer.getCustomerId() + " and ssn: " + theCustomer.getSsnId();
		}
		
		return "Customer with id: " + theCustomer.getCustomerId() + " updated successfully";
	}
	
	@DeleteMapping("/6865deleteCustomer/{id}")
	@CrossOrigin
	public String deleteById(@PathVariable int id) {
		
		List<Customer> customers = service.findAll();
		
		boolean flag = false;
		for(Customer c:customers) {
			if(c.getCustomerId() == id) {
				flag = true;
			} 
		}
		if(flag) {
			service.deleteById(id);
		} else {
			return "No customer exists with id: " + id + " for deletion";
		}
		return "Customer with id: " + id + " is deleted successfully";
	}
}
