package com.mph.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
/**
 * @author BalaKrishnan 
 * @version 1.0
 */
@Entity
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billno;
	
	@Column
	private String connection;
	private String readingdate;
	private String duedate;
	private int unitsused;
	private int amount;

	public Bill(int billno, String readingdate, String duedate, int unitsused, int amount, Customer customer,
			String connection) {
		super();
		this.billno = billno;
		this.readingdate = readingdate;
		this.duedate = duedate;
		this.unitsused = unitsused;
		this.amount = amount;
		this.connection = connection;
	}

	@OneToOne(mappedBy = "bill")
	@JsonBackReference
	private Customer customer;

	public Bill() {
		super();
	}
	/**
	 * 
	 * @return int returns integer which is billno
	 */
	public int getBillno() {
		return billno;
	}
	/**
	 * 
	 * @param doorno accepts address billno
	 */

	public void setBillno(int billno) {
		this.billno = billno;
	}
	/**
	 * 
	 * @return string returns string which is readingdate
	 */
	public String getReadingdate() {
		return readingdate;
	}
	/**
	 * 
	 * @param readingdate accepts bill readingdate
	 */

	public void setReadingdate(String readingdate) {
		this.readingdate = readingdate;
	}
	/**
	 * 
	 * @return String returns String which is duedate
	 */

	public String getDuedate() {
		return duedate;
	}
	/**
	 * 
	 * @param duedate accepts bill duedate
	 */
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	/**
	 * 
	 * @return int returns integer which is unitsused
	 */
	public int getUnitsused() {
		return unitsused;
	}
	/**
	 * 
	 * @param unitsused accepts bill unitsused
	 */

	public void setUnitsused(int unitsused) {
		this.unitsused = unitsused;
	}
	/**
	 * 
	 * @return string returns string which is connection
	 */

	public String getConnection() {
		return connection;
	}
	/**
	 * 
	 * @param connections accepts bill connection
	 */

	public void setConnection(String connection) {
		this.connection = connection;
	}
	
	/**
	 * 
	 * @return int returns int which is amount
	 */

	public int getAmount() {
		if (connection.equals("household")) {
			amount = unitsused * 2;
		} else {
			amount = unitsused * 5;
		}
		return amount;
	}
	/**
	 * 
	 * @param amount accepts bill amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Bill [billno=" + billno + ", connection=" + connection + ", readingdate=" + readingdate + ", duedate="
				+ duedate + ", unitsused=" + unitsused + ", amount=" + amount + "]";
	}
}
