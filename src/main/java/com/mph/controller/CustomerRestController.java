package com.mph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mph.entity.Customer;
import com.mph.service.CustomerService;


@RestController
@RequestMapping("/Customer")
@CrossOrigin(allowCredentials = "false",allowedHeaders =  "*"  ,origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE} )
public class CustomerRestController {
	@Autowired
	public CustomerService customerService;

	@GetMapping("/allcus")
	public ResponseEntity<List<Customer>> listAllCustomer() {
		List<Customer> li = customerService.getAllCustomer();
		if (li.isEmpty()) {
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Customer>>(li,HttpStatus.OK);
	}
	
	@PostMapping("/createCus")
	public Customer createCustomer(@RequestBody Customer customer) {
		customerService.createCustomer(customer);
		return customer;
	}
	
	@DeleteMapping("/deleteCus/{id}")
	public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable("id") int cid) {
		List<Customer> li = customerService.deleteCustomer(cid);
		if (li.isEmpty()) {
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Customer>>(li,HttpStatus.OK);
	}
	
	@PutMapping("/updateCus")
	public ResponseEntity<List<Customer>> updateCustomer(@RequestBody Customer customer) {
		List<Customer> li = customerService.updateCustomer(customer);
		
		if (li.isEmpty()) {
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Customer>>(li,HttpStatus.OK);
	}
	
	@GetMapping("/getCus/{cid}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("cid") int id) {
        
        Customer customer = customerService.getCustomer(id);
    	if (customer == null) {
			return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
    }
}