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

import com.mph.entity.Bill;
import com.mph.service.BillService;



@RestController
@RequestMapping("/Bill")
@CrossOrigin(allowCredentials = "false",allowedHeaders =  "*"  ,origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE} )
public class BillRestController {

	@Autowired 
	public BillService billService;
	

	@GetMapping("/allcus")
	public ResponseEntity<List<Bill>> listAllAddress() {
		List<Bill> li = billService.getAllBill();
		if (li.isEmpty()) {
			return new ResponseEntity<List<Bill>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Bill>>(li,HttpStatus.OK);
	}
	
	@PostMapping("/createBill")
	public Bill createBill(@RequestBody Bill bill) {
		billService.createBill(bill);
		return bill;
	}
	@DeleteMapping("/deleteCus/{id}")
	public ResponseEntity<List<Bill>> deleteBill(@PathVariable("id") int cid) {
		List<Bill> li = billService.deleteBill(cid);
		if (li.isEmpty()) {
			return new ResponseEntity<List<Bill>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Bill>>(li,HttpStatus.OK);
	}
	
	@PutMapping("/updateCus")
	public ResponseEntity<List<Bill>> updateBill(@RequestBody Bill bill) {
		List<Bill> li = billService.updateBill(bill);
		
		if (li.isEmpty()) {
			return new ResponseEntity<List<Bill>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Bill>>(li,HttpStatus.OK);
	}
	
	@GetMapping("/getCus/{cid}")
    public ResponseEntity<Bill> getBill(@PathVariable("cid") int id) {
        
		Bill bill =billService.getBill(id);
    	if (bill == null) {
			return new ResponseEntity<Bill>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Bill>(bill,HttpStatus.OK);
    }
}