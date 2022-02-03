package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Login;

@Repository
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void createLogin(Login login) {
		getSession().saveOrUpdate(login);
		System.out.println("Customer Saved successfully...");
	}

	@Override
	public List<Login> getAllLogin() {
		Query qry = getSession().createQuery("select l from Login l");
		List<Login> loglist = qry.list();
		System.out.println("cus list from dao : " + loglist);
		return loglist;
	}

	@Override
	public Login getLogin(Login login) {
		Criteria c = getSession().createCriteria(Login.class);
		c.add(Restrictions.eq("email", login.getEmail()));
		c.add(Restrictions.eq("password",login.getPassword()));
		Login loglist = (Login) c.uniqueResult();
		return loglist;
	}

	@Override
	public List<Login> updateLogin(Login login) {
		Query qry = getSession().createQuery(
				" update Login  l set email=:email,password=:password where login_id=:login_id");
	
		qry.setParameter("email",login.getEmail());
		qry.setParameter("password",login.getPassword());
		qry.setParameter("login_id", login.getLogin_id());
		
		int noofrows = qry.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Updated " + noofrows + " rows. ");
		}
		return getAllLogin();
	}

	@Override
	public List<Login> deleteLogin(int id) {
		Query qry = getSession().createQuery(" delete Login  l where login_id=:id");
		qry.setParameter("login_id", id);
		int noofrows = qry.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + " rows. ");
		}
		return getAllLogin();
	}

	@Override
	public Login getLogin(int id) {
		Query qry = getSession().createQuery("from Login l where login_id=:id");
		qry.setParameter("login_id", id);
		Login log = (Login) qry.uniqueResult();
		System.out.println("search result : " + log);
		return log;
	}

}
