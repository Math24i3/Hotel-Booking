package com.example.demo.Repository;


import com.example.demo.Model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@org.springframework.stereotype.Repository
public class RoomRepo {

    @Autowired
    JdbcTemplate template;

    public List<Room> fetchAllRooms() {

        String sql = "SELECT * FROM hotel_booking.rooms WHERE booking_status =1;";

        List<Room> rooms = template.query(sql, new BeanPropertyRowMapper<>(Room.class));

        return rooms;
    }


}
