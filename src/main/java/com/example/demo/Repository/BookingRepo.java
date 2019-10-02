package com.example.demo.Repository;


import com.example.demo.Model.Booking;
import com.example.demo.Model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

@org.springframework.stereotype.Repository
public class BookingRepo {

    @Autowired
    JdbcTemplate template;


    int tempRoomNumber;

    public Booking addBooking(Booking booking) {

        String sqlInsert = "INSERT INTO bookings (guest_id, room_number) VALUES ((SELECT guest_id FROM guests ORDER BY guest_id DESC LIMIT 1), ?);";
        String sqlUpdate = "UPDATE rooms SET booking_status = 0 WHERE rooms.room_number = ?;";

        template.update(sqlInsert, booking.getRoom_number());
        template.update(sqlUpdate, booking.getRoom_number());

        return null;
    }

    public List<Booking> fetchAllBookings() {

        String sql = "SELECT bookings.booking_id, bookings.room_number, rooms.room_type, rooms.price, guests.first_name, guests.last_name, guests.phonenumber, guests.email, guests.street_name, guests.street_number, guests.city, guests.zip\n" +
                "FROM bookings \n" +
                "INNER JOIN rooms \n" +
                "ON bookings.room_number = rooms.room_number \n" +
                "INNER JOIN guests ON bookings.guest_id = guests.guest_id;";

        List<Booking> bookings = template.query(sql, new BeanPropertyRowMapper<>(Booking.class));
        return bookings;
    }

    public Booking viewBooking(int booking_id) {
        String sql = "SELECT bookings.booking_id, bookings.room_number, rooms.room_type, rooms.price, guests.first_name, guests.last_name, guests.phonenumber, guests.email, guests.street_name, guests.street_number, guests.city, guests.zip\n" +
                "FROM bookings \n" +
                "INNER JOIN rooms \n" +
                "ON bookings.room_number = rooms.room_number \n" +
                "INNER JOIN guests ON bookings.guest_id = guests.guest_id WHERE bookings.booking_id = ?;";
        RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
        Booking booking = template.queryForObject(sql, rowMapper, booking_id);

        tempRoomNumber = booking.getRoom_number();
        System.out.println(tempRoomNumber);

        return booking;
    }

    public boolean deleteBooking(int booking_id) {

        String sql = "DELETE FROM bookings WHERE booking_id = ?;";
        String sqlu = "UPDATE rooms SET rooms.booking_status = 1 WHERE rooms.room_number = (SELECT room_number FROM bookings WHERE bookings.booking_id = ?); ";

        return template.update(sqlu, booking_id) + template.update(sql, booking_id) > 0;
    }
//______________________________________________________________________


    public Booking updateBooking(int booking_id, Booking booking) {

        String sqlUpdateBooking = "UPDATE bookings SET bookings.room_number = ? WHERE bookings.booking_id = ?";
        String sqlUpdatePrevRoom = "UPDATE rooms SET rooms.booking_status = 0 WHERE rooms.room_number = (SELECT room_number FROM bookings WHERE bookings.booking_id = ?);";
        String sqlUpdateRoom = "UPDATE rooms SET booking_status = 1 WHERE rooms.room_number = ?;";

        template.update(sqlUpdateBooking, booking.getRoom_number(), booking_id);
        template.update(sqlUpdatePrevRoom, booking_id);
        template.update(sqlUpdateRoom, tempRoomNumber);
        return null;
    }

}
