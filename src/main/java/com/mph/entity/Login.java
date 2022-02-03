package com.mph.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 * @author Vijaya Lakshmi
 *
 */
@Entity
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int login_id;

	private String email;
	private String password;

	@OneToOne(mappedBy = "login")
	@JsonBackReference
	private Customer customer;

	public Login() {
		super();
	}

	public Login(int login_id, String email, String password, Customer customer) {
		super();
		this.login_id = login_id;
		this.email = email;
		this.password = password;
	}

	/**
	 * 
	 * @return int returns integer which is doorno
	 */
	public int getLogin_id() {
		return login_id;
	}

	/**
	 * 
	 * @param login_id accepts login ID
	 */
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}

	/**
	 * 
	 * @return String returns String which is email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email accepts login email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return String returns String which is password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password accepts login password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Login [login_id=" + login_id + ", email=" + email + ", password=" + password + "]";
	}

}
