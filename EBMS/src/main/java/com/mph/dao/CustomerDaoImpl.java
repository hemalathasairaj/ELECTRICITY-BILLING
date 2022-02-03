package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Customer createCustomer(Customer customer) {
		getSession().saveOrUpdate(customer);
		System.out.println("Customer Saved successfully...");
		return customer;

	}

	@Override
	public List<Customer> getAllCustomer() {
		Query qry = getSession().createQuery("select c from Customer c");
		List<Customer> cuslist = qry.list();
		System.out.println("cus list from dao : " + cuslist);
		return cuslist;
	}

	@Override
	public Customer getCustomer(Customer cus) {
		Criteria c = getSession().createCriteria(Customer.class);
		c.add(Restrictions.eq("email", cus.getEmail()));
		c.add(Restrictions.eq("password",cus.getPassword()));
		Customer cusl = (Customer) c.uniqueResult();
		return cusl;
	}

	@Override
	public List<Customer> updateCustomer(Customer customer) {		
		Query qry = getSession().createQuery(
				" update Customer  c set fullname=:fullname,phone=:phone,email=:email,password=:password where cid=:cid");
		qry.setParameter("fullname", customer.getFullname());
		qry.setParameter("phone", customer.getPhone());
		qry.setParameter("email",customer.getEmail());
		qry.setParameter("password",customer.getPassword());
		qry.setParameter("cid", customer.getCid());
		
		int noofrows = qry.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Updated " + noofrows + " rows. ");
		}
		return getAllCustomer();
	}

	@Override
	public List<Customer> deleteCustomer(int cid) {
		Query qry = getSession().createQuery(" delete Customer  c where cid=:cid");
		qry.setParameter("cid", cid);
		int noofrows = qry.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + " rows. ");
		}
		return getAllCustomer();
	}

	@Override
	public Customer getCustomer(int id) {
		Query qry = getSession().createQuery("from Customer c where cid=:id");
		qry.setParameter("id", id);
		Customer cus = (Customer) qry.uniqueResult();
		System.out.println("search result : " + cus);
		return cus;
	}

}