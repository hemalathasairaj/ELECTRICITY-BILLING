package com.mph.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 * @author Pooja
 * @version 1.0
 */
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int doorno;

	@Column
	private String street;
	private String city;
	private int pincode;
	private String state;

	@OneToOne(mappedBy = "address")
	@JsonBackReference
	private Customer customer;

	public Address() {
		super();
	}

	public Address(int doorno, String street, String city, int pincode, String state, Customer customer) {
		super();
		this.doorno = doorno;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
	}

	/**
	 * 
	 * @return int returns integer which is doorno
	 */
	public int getDoorno() {
		return doorno;
	}

	/**
	 * 
	 * @param doorno accepts address doorno
	 */
	public void setDoorno(int doorno) {
		this.doorno = doorno;
	}

	/**
	 * 
	 * @return string returns string which is street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * 
	 * @param street accepts address street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * 
	 * @return string returns string which is city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 
	 * @param city accepts address city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 
	 * @return int returns integer which is pincode
	 */
	public int getPincode() {
		return pincode;
	}

	/**
	 * 
	 * @param pincode accepts address pincode
	 */
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	/**
	 * 
	 * @return string returns string which is state
	 */
	public String getState() {
		return state;
	}

	/**
	 * 
	 * @param state accepts address state
	 */
	public void setState(String state) {
		this.state = state;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Address [doorno=" + doorno + ", street=" + street + ", city=" + city + ", pincode=" + pincode
				+ ", state=" + state + "]";
	}

}
