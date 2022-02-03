package com.mph.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Login> getAllLogin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Login getLogin(Login login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Login> updateLogin(Login login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Login> deleteLogin(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Login getLogin(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
