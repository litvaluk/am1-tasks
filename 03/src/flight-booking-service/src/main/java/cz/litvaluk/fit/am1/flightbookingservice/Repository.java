package cz.litvaluk.fit.am1.flightbookingservice;

import https.lukaslitvan_com.flight_booking_service.Booking;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Repository {

    private static final List<Booking> bookings = new ArrayList<>();

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void deleteBooking(int id) {
        bookings.removeIf(booking -> booking.getId() == id);
    }

    public void updateBooking(int id, Booking booking) {
        if (bookings.removeIf(b -> b.getId() == id)) {
            bookings.add(booking);
        }
    }

}
