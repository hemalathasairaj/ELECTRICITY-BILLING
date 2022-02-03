package com.mph.service;

import java.util.List;

import com.mph.entity.Login;

public interface LoginService {

	public void createLogin( Login login);
	public List<Login > getAllLogin();
	public  Login getLogin( Login login);
	public List< Login> updateLogin( Login login);
	public List< Login> deleteLogin(int id);
	public Login getLogin(int id);
}
