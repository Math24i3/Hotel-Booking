package com.example.demo.Service;

import com.example.demo.Model.Booking;
import com.example.demo.Model.Guest;
import com.example.demo.Model.Room;
import com.example.demo.Repository.BookingRepo;
import com.example.demo.Repository.GuestRepo;
import com.example.demo.Repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@org.springframework.stereotype.Service
public class BookingService {

    @Autowired
    GuestRepo guestRepo;

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    RoomRepo roomRepo;

    //Adds a guest to database
    public Guest addGuest(Guest guest) {

        return guestRepo.addGuest(guest);
    }

    //Update guest
    public Booking updateGuest(int booking_id, Guest guest) {

        return guestRepo.updateGuest(booking_id, guest);
    }


    // Add a booking
    public Booking addBooking(Booking booking) {

        return bookingRepo.addBooking(booking);
    }

    //Gets a list of all bookings
    public List<Booking> fetchAllBookings() {
        return bookingRepo.fetchAllBookings();
    }

    //Returns a specdified booking
    public Booking viewBooking(int booking_id) {
        return bookingRepo.viewBooking(booking_id);
    }


    //DELETE booking
    public boolean deleteBooking(int booking_id) {

        return bookingRepo.deleteBooking(booking_id);
    }

    public Booking updateBooking(int booking_id, Booking booking) {


        return bookingRepo.updateBooking(booking_id, booking);
    }


    public List<Guest> fetchAllGuests() {
        return guestRepo.fetchAllGuests();
    }

    //Gets a list of rooms
    public List<Room> fetchAllRooms() {
        return roomRepo.fetchAllRooms();
    }
}


