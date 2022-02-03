package com.mph.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Address;
import com.mph.entity.Customer;

@Repository
public class AddressDaoImpl implements AddressDao{

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public List<Address> getAllAddress() {
		Query qry = getSession().createQuery("select a from Address a");
		List<Address> addlist = qry.list();
		System.out.println("address list from dao : " + addlist);
		return addlist;
	}

	@Override
	public Address getAddress(Address add) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> updateAddress(Address address) {
		Query qry = getSession().createQuery(
				" update Address  a set street=:street,city=:city,state=:state,pincode=:pincode where doorno=:cid");
		qry.setParameter("street", address.getStreet());
		qry.setParameter("city",address.getCity());
		qry.setParameter("state",address.getState());
		qry.setParameter("pincode", address.getPincode());
		qry.setParameter("cid", address.getDoorno());
		
		int noofrows = qry.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Updated " + noofrows + " rows. ");
		}
		return getAllAddress();
	}

	@Override
	public List<Address> deleteAddress(int cid) {
		Query qry = getSession().createQuery(" delete Address  a where doorno=:cid");
		qry.setParameter("cid", cid);
		int noofrows = qry.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + " rows. ");
		}
		return getAllAddress();
	}

	@Override
	public Address getAddress(int id) {
		Query qry = getSession().createQuery("from Address a where cid=:id");
		qry.setParameter("id", id);
		Address add = (Address) qry.uniqueResult();
		System.out.println("search result : " + add);
		return add;
	}
	@Override
	public void createAddress(Address address) {
		
		getSession().saveOrUpdate(address);
		System.out.println("Customer address Saved successfully...");
	}

}
