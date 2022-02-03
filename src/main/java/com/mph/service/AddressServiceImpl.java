package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.AddressDao;
import com.mph.dao.CustomerDao;
import com.mph.entity.Address;
import com.mph.entity.Customer;

@Repository
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired 
	public AddressDao addressDao;
	@Autowired
	public CustomerDao customerDao;
	@Override
	public void createAddress(Address address) {
        addressDao.createAddress(address);
	}
	@Override
	public List<Address> getAllAddress() {
		return addressDao.getAllAddress();
	}
	@Override
	public Address getAddress(Address add) {
		return addressDao.getAddress(add);
	}
	@Override
	public List<Address> updateAddress(Address address) {
		// TODO Auto-generated method stub
		return addressDao.updateAddress(address);
	}
	@Override
	public List<Address> deleteAddress(int cid) {
		// TODO Auto-generated method stub
		return addressDao.deleteAddress(cid);
	}
	@Override
	public Address getAddress(int id) {
		// TODO Auto-generated method stub
		return addressDao.getAddress(id);
	}
	
	
}
