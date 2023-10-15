package com.nikhil.book.table.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikhil.book.table.dto.BookingRequestDto;
import com.nikhil.book.table.dto.BookingResponseDto;
import com.nikhil.book.table.entity.BookingEntity;
import com.nikhil.book.table.repository.BookingRepository;
import com.nikhil.book.table.service.BookingService;

import java.util.Collection;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookingServiceImpl.class);
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ModelMapper modelMapper;

    public BookingServiceImpl(BookingRepository bookingRepository, ModelMapper modelMapper) {
        this.bookingRepository = bookingRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<BookingEntity> getBookingsForLoggedUserById(int resId) {
        try {
            return bookingRepository.findById(resId);
        } catch (Exception e) {
            LOGGER.error("Failed to get booking with ID: {}", resId, e);
            throw e;
        }
    }

    @Override
    public Collection<BookingEntity> getBookingsForLoggedUser() {
        try {
            return bookingRepository.findAll();
        } catch (Exception e) {
            LOGGER.error("Failed to get bookings for logged user", e);
            throw e;
        }
    }

    @Override
    public BookingResponseDto saveBooking(BookingRequestDto booking) {
    	BookingResponseDto response= new BookingResponseDto();
        try {
            BookingEntity bookingEntity = modelMapper.map(booking, BookingEntity.class);
            bookingEntity= bookingRepository.save(bookingEntity);
            response.setBookingId(String.valueOf(bookingEntity.getBookingid()));
            response.setMessage("Booking done successfully");
        } catch (Exception e) {
            LOGGER.error("Failed to save booking", e);
            throw e;
        }
		return response;
    }
    
    @Override
    public BookingResponseDto updateBooking(int bookingId, BookingRequestDto booking) {
    	BookingResponseDto response= new BookingResponseDto();
        try {
            // Retrieve the existing booking entity from the database
            Optional<BookingEntity> optionalBookingEntity = bookingRepository.findById(bookingId);
            if (!optionalBookingEntity.isPresent()) {
                // Handle the case when the booking entity is not found
            	LOGGER.error("Booking not found with ID: " + bookingId);
            }

            BookingEntity existingBookingEntity = optionalBookingEntity.get();

            existingBookingEntity.setEmailId(booking.getEmailId());
            existingBookingEntity.setNoOfChildren(booking.getNoOfChildren());
            existingBookingEntity.setNoOfPerson(booking.getNoOfPerson());
            existingBookingEntity.setTable(booking.getTable());
            existingBookingEntity.setUserMobileNumber(booking.getUserMobileNumber());
            existingBookingEntity.setUserName(booking.getUserName());
            existingBookingEntity.setRestaurantOpenBuffet(booking.getRestaurantOpenBuffet());
            existingBookingEntity.setArrivalDate(booking.getArrivalDate());

            // Save the updated booking entity
            BookingEntity updatedBookingEntity = bookingRepository.save(existingBookingEntity);
            
            response.setBookingId(String.valueOf(updatedBookingEntity.getBookingid()));
            response.setMessage("Booking done successfully");

            return response;
        } catch (Exception e) {
            LOGGER.error("Failed to update booking", e);
            throw e;
        }
    }



    @Override
    public boolean deleteBooking(int resId) {
        try {
            bookingRepository.deleteById(resId);
            return true;
        } catch (Exception e) {
            LOGGER.error("Failed to delete booking with ID: {}", resId, e);
            throw e;
        }
    }

    @Override
    public BookingRequestDto bookingToCurrentBookingById(int resId) {
        try {
            Optional<BookingEntity> bookingEntity = bookingRepository.findById(resId);
            return modelMapper.map(bookingEntity, BookingRequestDto.class);
        } catch (Exception e) {
            LOGGER.error("Failed to map booking with ID: {} to BookingRequestDto", resId, e);
            throw e;
        }
    }
}
