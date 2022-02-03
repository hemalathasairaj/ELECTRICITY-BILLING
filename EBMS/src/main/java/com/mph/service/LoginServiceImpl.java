package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.CustomerDao;
import com.mph.dao.LoginDao;
import com.mph.entity.Login;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{

	@Autowired 
	public LoginDao loginDao;
	@Autowired
	public CustomerDao customerDao;
	@Override
	public void createLogin(Login login) {
		
		loginDao.createLogin(login);
	}

	@Override
	public List<Login> getAllLogin() {
		return loginDao.getAllLogin();
	}

	@Override
	public Login getLogin(Login login) {
		return loginDao.getLogin(login);
	}

	@Override
	public List<Login> updateLogin(Login login) {
		return loginDao.updateLogin(login);
	}

	@Override
	public List<Login> deleteLogin(int id) {
		return loginDao.deleteLogin(id);
	}

	@Override
	public Login getLogin(int id) {
		return loginDao.getLogin(id);
	}

}
