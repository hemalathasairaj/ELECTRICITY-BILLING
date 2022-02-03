package com.mph.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * 
 * @author Hemalatha
 * @version 1.0
 *
 */
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;

	@Column
	private String fullname;
	private int phone;
	private String email;
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doorno")
	@JsonManagedReference
	private Address address;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "billno")
	@JsonManagedReference
	private Bill bill;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "login_id")
	@JsonManagedReference
	private Login login;

	public Customer() {
		super();
	}

	public Customer(int cid, String fullname, int phone, String email, String password, Address address, Bill bill,
			Login login) {
		super();
		this.cid = cid;
		this.fullname = fullname;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.address = address;
		this.bill = bill;
		this.login = login;
	}

	/**
	 * 
	 * @return int returns integer which is customer ID
	 */
	public int getCid() {
		return cid;
	}

	/**
	 * 
	 * @param cid accepts customer ID
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}

	/**
	 * 
	 * @return String returns String which is fullname
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * 
	 * @param fullname accepts customer fullname
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	/**
	 * 
	 * @return int returns integer which is phone number
	 */
	public int getPhone() {
		return phone;
	}

	/**
	 * 
	 * @param phone accepts customer's phone number
	 */
	public void setPhone(int phone) {
		this.phone = phone;
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
	 * @param email accepts customer email Id
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
	 * @param password accepts password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", fullname=" + fullname + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + ", address=" + address + ", bill=" + bill + ", login=" + login + "]";
	}

}
