package com.tech.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.domain.Customer;
import com.tech.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/customers")
	public List<Customer> getAllCustomer() {
		return customerService.listAll();
	}

	@RequestMapping(value = "/customers", produces = { "application/json" }, method = RequestMethod.POST)
	public Customer savecustomer(@RequestBody Customer customer) {
		return customerService.saveOrUpdate(customer);
	}

}
