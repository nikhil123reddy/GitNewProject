package com.nikhil.book.table.dto;


public class BookingRequestDto {
	
	private int bookingid;
	private String userName;
	private String userMobileNumber;
	private String emailId;
	private String table;
	private int noOfPerson;
	private int noOfChildren;
	private String restaurantOpenBuffet;
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
