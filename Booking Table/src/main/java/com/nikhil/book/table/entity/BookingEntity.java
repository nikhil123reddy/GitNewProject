package com.nikhil.book.table.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class BookingEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "booking_id")
	private int bookingid;
	
	@Column(name = "booking_user_name")
	private String userName;
	
	@Column(name = "booking_mobile_number")
	private String userMobileNumber;
	
	@Column(name = "email_id")
	private String emailId;

	@Column(name = "booking_num_of_table")
	private String table;

	@Column(name = "booking_num_of_person")
	private int noOfPerson;
	
	@Column(name = "booking_num_of_children")
	private int noOfChildren;
	
	@Column(name = "restaurant_open_buffet")
	private String restaurantOpenBuffet;
	
	@Column(name = "arrival_date")
	private String arrivalDate;

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMobileNumber() {
		return userMobileNumber;
	}

	public void setUserMobileNumber(String userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public int getNoOfPerson() {
		return noOfPerson;
	}

	public void setNoOfPerson(int noOfPerson) {
		this.noOfPerson = noOfPerson;
	}

	public int getNoOfChildren() {
		return noOfChildren;
	}

	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	public String getRestaurantOpenBuffet() {
		return restaurantOpenBuffet;
	}

	public void setRestaurantOpenBuffet(String restaurantOpenBuffet) {
		this.restaurantOpenBuffet = restaurantOpenBuffet;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	

}
