package com.nikhil.book.table.controller;


import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nikhil.book.table.dto.BookingRequestDto;
import com.nikhil.book.table.dto.BookingResponseDto;
import com.nikhil.book.table.entity.BookingEntity;
import com.nikhil.book.table.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);

    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingEntity> getBookingById(@PathVariable int bookingId) {
        try {
            Optional<BookingEntity> booking = bookingService.getBookingsForLoggedUserById(bookingId);
            if (booking.isPresent()) {
                return ResponseEntity.ok(booking.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            LOGGER.error("Failed to retrieve booking with ID: {}", bookingId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping
    public ResponseEntity<Collection<BookingEntity>> getAllBookings() {
        try {
            Collection<BookingEntity> bookings = bookingService.getBookingsForLoggedUser();
            return ResponseEntity.ok(bookings);
        } catch (Exception e) {
            LOGGER.error("Failed to retrieve bookings for logged user", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<BookingResponseDto> saveUpdateBooking(@RequestBody BookingRequestDto booking) {
        try {
        	BookingResponseDto response= bookingService.saveBooking(booking);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOGGER.error("Failed to save or update booking", e);
            BookingResponseDto response = new BookingResponseDto("Error", "Failed to save or update booking");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> deleteBooking(@PathVariable int bookingId) {
        try {
            boolean deleted = bookingService.deleteBooking(bookingId);
            if (deleted) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            LOGGER.error("Failed to delete booking with ID: {}", bookingId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{bookingId}/convert")
    public ResponseEntity<BookingRequestDto> convertBookingToDto(@PathVariable int bookingId) {
        try {
            BookingRequestDto bookingDto = bookingService.bookingToCurrentBookingById(bookingId);
            if (bookingDto != null) {
                return ResponseEntity.ok(bookingDto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            LOGGER.error("Failed to convert booking with ID: {} to DTO", bookingId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PutMapping("/{bookingId}")
    public ResponseEntity<BookingResponseDto> updateBooking(@PathVariable int bookingId, @RequestBody BookingRequestDto booking) {
        try {
            BookingResponseDto response = bookingService.updateBooking(bookingId, booking);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOGGER.error("Failed to update booking", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
