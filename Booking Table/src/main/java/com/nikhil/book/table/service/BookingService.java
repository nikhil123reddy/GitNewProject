package com.nikhil.book.table.service;

import java.util.Collection;
import java.util.Optional;

import com.nikhil.book.table.dto.BookingRequestDto;
import com.nikhil.book.table.dto.BookingResponseDto;
import com.nikhil.book.table.entity.BookingEntity;

public interface BookingService {
	
	public Optional<BookingEntity> getBookingsForLoggedUserById(int resId);

	public Collection<BookingEntity> getBookingsForLoggedUser();
	
	public BookingResponseDto saveBooking(BookingRequestDto booking);
	
	public boolean deleteBooking(int resId);

	public BookingRequestDto bookingToCurrentBookingById(int resId);

	public BookingResponseDto updateBooking(int bookingId, BookingRequestDto booking);

}
