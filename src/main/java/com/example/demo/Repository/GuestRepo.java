package com.example.demo.Repository;

import com.example.demo.Model.Booking;
import com.example.demo.Model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.awt.*;
import java.util.List;


@org.springframework.stereotype.Repository
public class GuestRepo {

    @Autowired
    JdbcTemplate template;


    public List<Guest> fetchAllGuests() {
        String sql = "SELECT * FROM guests;";

        List<Guest> guests = template.query(sql, new BeanPropertyRowMapper<>(Guest.class));
        return guests;
    }

    public Guest addGuest(Guest guest) {

        String sqlInsert = "INSERT INTO guests (first_name, last_name, phonenumber, email, street_name, street_number, city, zip) VALUES (?, ?, ?, ?, ? ,?, ?, ?);";

        template.update(sqlInsert, guest.getFirst_name(), guest.getLast_name(), guest.getPhonenumber(), guest.getEmail(), guest.getStreet_name(), guest.getStreet_number(), guest.getCity(), guest.getZip());

        return null;
    }

    public Booking updateGuest(int booking_id, Guest guest) {

        String sqlUpdateGuest = "UPDATE guests SET guests.first_name = ?, guests.last_name = ?, guests.phonenumber = ?, guests.email = ?, guests.street_name = ?, guests.street_number = ?, guests.city = ?, guests.zip = ? WHERE guests.guest_id = (SELECT bookings.guest_id FROM bookings  WHERE bookings.booking_id = ?);";
        template.update(sqlUpdateGuest, guest.getFirst_name(), guest.getLast_name(), guest.getPhonenumber(), guest.getEmail(), guest.getStreet_name(), guest.getStreet_number(), guest.getCity(), guest.getZip(), booking_id);

        return null;
    }
}
