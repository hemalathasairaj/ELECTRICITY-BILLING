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

import com.mph.entity.Address;
import com.mph.service.AddressService;

@RestController
@RequestMapping("/Address")
@CrossOrigin(allowCredentials = "false",allowedHeaders =  "*"  ,origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE} )
public class AddressRestController {

	@Autowired 
	public AddressService addressService;
	

	@GetMapping("/allcus")
	public ResponseEntity<List<Address>> listAllAddress() {
		List<Address> li = addressService.getAllAddress();
		if (li.isEmpty()) {
			return new ResponseEntity<List<Address>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Address>>(li,HttpStatus.OK);
	}
	
	@PostMapping("/createCus")
	public Address createAddress(@RequestBody Address address) {
		addressService.createAddress(address);
		return address;
	}
	@DeleteMapping("/deleteCus/{id}")
	public ResponseEntity<List<Address>> deleteAddress(@PathVariable("id") int cid) {
		List<Address> li = addressService.deleteAddress(cid);
		if (li.isEmpty()) {
			return new ResponseEntity<List<Address>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Address>>(li,HttpStatus.OK);
	}
	
	@PutMapping("/updateCus")
	public ResponseEntity<List<Address>> updateAddress(@RequestBody Address address) {
		List<Address> li = addressService.updateAddress(address);
		
		if (li.isEmpty()) {
			return new ResponseEntity<List<Address>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Address>>(li,HttpStatus.OK);
	}
	
	@GetMapping("/getCus/{cid}")
    public ResponseEntity<Address> getAddress(@PathVariable("cid") int id) {
        
		Address address = addressService.getAddress(id);
    	if (address == null) {
			return new ResponseEntity<Address>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Address>(address,HttpStatus.OK);
    }
}
