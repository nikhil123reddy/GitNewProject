package com.nikhil.book.table.dto;

public class BookingResponseDto {
	
	private String bookingId;
	
	private String message;

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BookingResponseDto(String bookingId, String message) {
		super();
		this.bookingId = bookingId;
		this.message = message;
	}

	public BookingResponseDto() {
		// TODO Auto-generated constructor stub
	}
	
}
