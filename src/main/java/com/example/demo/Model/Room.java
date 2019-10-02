package com.example.demo.Model;


import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {

    @Id
    private int room_number;
    private String room_type;
    private double price;
    private boolean booking_status;


    public Room() {
    }

    public Room(int room_number, String room_type, double price, boolean booking_status) {
        this.room_number = room_number;
        this.room_type = room_type;
        this.price = price;
        this.booking_status = booking_status;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBooking_status() {
        return booking_status;
    }

    public void setBooking_status(boolean booking_status) {
        this.booking_status = booking_status;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_number=" + room_number +
                ", room_type='" + room_type + '\'' +
                ", price=" + price +
                ", booking_status=" + booking_status +
                '}';
    }
}
