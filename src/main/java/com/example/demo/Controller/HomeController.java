package com.example.demo.Controller;


import com.example.demo.Model.Booking;
import com.example.demo.Model.Guest;
import com.example.demo.Model.Room;
import com.example.demo.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.util.List;

//Controller class
@Controller
public class HomeController {

    @Autowired
    BookingService bookingService;


    @GetMapping("/")
    public String index(Model model) {

        List<Guest> guestsInfo = bookingService.fetchAllGuests();
        List<Booking> bookingInfo = bookingService.fetchAllBookings();

        model.addAttribute("guests", guestsInfo);
        model.addAttribute("bookings", bookingInfo);

        return "Home/mainView";
    }

    @GetMapping("/booking")
    public String bookingPage(Model model) {

        List<Room> rooms = bookingService.fetchAllRooms();
        model.addAttribute("rooms", rooms);

        return "Home/booking";
    }

    @GetMapping("/viewBooking/{booking_id}")
    public String viewBooking(@PathVariable("booking_id") int booking_id, Model model) {
        model.addAttribute("booking", bookingService.viewBooking(booking_id));

        return "Home/viewBooking";
    }

    //Delete a booking
    @GetMapping("/delete/{booking_id}")
    public String deleteBooking(@PathVariable("booking_id") int booking_id) {

        boolean deleted = bookingService.deleteBooking(booking_id);
        if (deleted) {
            return "redirect:/";

        } else {
            return "redirect:/";
        }
    }

    //Update an vehicle
    @GetMapping("/updateBooking/{booking_id}")
    public String updateBooking(@PathVariable("booking_id") int booking_id, Model model) {
        model.addAttribute("booking", bookingService.viewBooking(booking_id));
        List<Room> rooms = bookingService.fetchAllRooms();
        model.addAttribute("rooms", rooms);
        return "home/updateBooking";
    }

    @PostMapping("/updateBooking")
    public String update(@ModelAttribute Booking booking, @ModelAttribute Guest guest) {
        bookingService.updateBooking(booking.getBooking_id(), booking);
        bookingService.updateGuest(booking.getBooking_id(), guest);
        return "redirect:/";
    }


    @PostMapping("/addGuest")
    public String addGuest(@ModelAttribute Guest guest, @ModelAttribute Booking booking) {
        bookingService.addGuest(guest);
        bookingService.addBooking(booking);
        return "redirect:/";
    }


    //Pages
    @GetMapping("/deleteBooking")
    public String deleteBookingPage() {
        return "Home/deleteBooking";
    }

    @GetMapping("employees")
    public String employeesPage() {
        return "Home/employees";
    }

}
