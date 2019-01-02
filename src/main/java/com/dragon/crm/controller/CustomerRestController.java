package com.dragon.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.crm.model.Customer;
import com.dragon.crm.model.CustomerErrorResponse;
import com.dragon.crm.model.CustomerNotFoundException;
import com.dragon.crm.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc) {
		CustomerErrorResponse error = new CustomerErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		List<Customer> customers = customerService.getCustomers();
		return customers;
	}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable("customerId") int customerId) {
		Customer customer = customerService.getCustomer(customerId);
		if (customer != null) {
			return customer;
		} else {
			throw new CustomerNotFoundException("The customer id not found - " + Integer.toString(customerId));
		}
	}

	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable("customerId") int customerId) {
		Customer customer = customerService.getCustomer(customerId);
		if (customer != null) {
			customerService.deleteCustomer(customerId);
			return "deleted customer of id - "+customerId;
		} else {
			throw new CustomerNotFoundException("The customer id not found - " + Integer.toString(customerId));
		}
	}

}
