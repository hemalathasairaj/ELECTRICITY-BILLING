package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Bill;

@Repository
public class BillDaoImpl implements BillDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void createBill(Bill bill) {
		getSession().saveOrUpdate(bill);
		System.out.println("Customer address Saved successfully...");
	}

	@Override
	public List<Bill> getAllBill() {
		Query qry = getSession().createQuery("select b from Bill b");
		List<Bill> billist = qry.list();
		System.out.println("cus list from dao : " + billist);
		return billist;
	}

	@Override
	public Bill getBill(Bill bill) {
		Criteria c = getSession().createCriteria(Bill.class);
		c.add(Restrictions.eq("billno", bill.getBillno()));
		c.add(Restrictions.eq("connection",bill.getConnection()));
		c.add(Restrictions.eq("readingdate",bill.getReadingdate()));
		c.add(Restrictions.eq("duedate",bill.getDuedate()));
		c.add(Restrictions.eq("unitsused",bill.getUnitsused()));
		c.add(Restrictions.eq("amount",bill.getAmount()));
		
		Bill billl = (Bill) c.uniqueResult();
		return billl;
	}

	@Override
	public List<Bill> updateBill(Bill bill) {
		
		Query qry = getSession().createQuery(
				" update Bill  b set connection=:connection,readingdate=:readingdate,unitsused=:unitsused where billno=:cid");
		qry.setParameter("cid", bill.getBillno());
		qry.setParameter("connection",bill.getConnection());
		qry.setParameter("readingdate",bill.getReadingdate());
		qry.setParameter("unitsused", bill.getUnitsused());

		
		int noofrows = qry.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Updated " + noofrows + " rows. ");
		}
		return getAllBill();
	}

	@Override
	public List<Bill> deleteBill(int id) {
		Query qry = getSession().createQuery(" delete Bill  b where billno=:id");
		qry.setParameter("id", id);
		int noofrows = qry.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + " rows. ");
		}
		return getAllBill();
	}

	@Override
	public Bill getBill(int id) {
		Query qry = getSession().createQuery("from Bill b where billno=:id");
		qry.setParameter("id", id);
		Bill bill = (Bill) qry.uniqueResult();
		System.out.println("search result : " + bill);
		return bill;
	}

}