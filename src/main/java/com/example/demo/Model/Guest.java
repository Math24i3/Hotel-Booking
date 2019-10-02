package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Guest {


    //Values for guests
    @Id
    private int guest_id;
    private String first_name;
    private String last_name;
    private int phonenumber;
    private String name = first_name + " " + last_name;
    private String email;
    private String street_name;
    private int street_number;
    private String city;
    private int zip;


    //Constructor

    public Guest() {
    }

    public Guest(int guest_id, String first_name, String last_name, int phonenumber, String name, String email, String street_name, int street_number, String city, int zip) {
        this.guest_id = guest_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phonenumber = phonenumber;
        this.name = name;
        this.email = email;
        this.street_name = street_name;
        this.street_number = street_number;
        this.city = city;
        this.zip = zip;
    }

    public int getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(int guest_id) {
        this.guest_id = guest_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public int getStreet_number() {
        return street_number;
    }

    public void setStreet_number(int street_number) {
        this.street_number = street_number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }
}
