package cz.litvaluk.fit.am1.flightbookingservice;

import https.lukaslitvan_com.flight_booking_service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@org.springframework.ws.server.endpoint.annotation.Endpoint
public class Endpoint {

    @Autowired
    private Repository repository;

    @PayloadRoot(namespace = "https://lukaslitvan.com/flight-booking-service/", localPart = "getBookingsRequest")
    @ResponsePayload
    public GetBookingsResponse getBookings(@RequestPayload GetBookingsRequest request) {
        GetBookingsResponse response = new GetBookingsResponse();
        response.getBooking().addAll(repository.getBookings());
        return response;
    }

    @PayloadRoot(namespace = "https://lukaslitvan.com/flight-booking-service/", localPart = "addBookingRequest")
    @ResponsePayload
    public AddBookingResponse addBooking(@RequestPayload AddBookingRequest request) {
        AddBookingResponse response = new AddBookingResponse();
        repository.addBooking(request.getBooking());
        return response;
    }

    @PayloadRoot(namespace = "https://lukaslitvan.com/flight-booking-service/", localPart = "deleteBookingRequest")
    @ResponsePayload
    public DeleteBookingResponse deleteBooking(@RequestPayload DeleteBookingRequest request) {
        DeleteBookingResponse response = new DeleteBookingResponse();
        repository.deleteBooking(request.getId());
        return response;
    }

    @PayloadRoot(namespace = "https://lukaslitvan.com/flight-booking-service/", localPart = "updateBookingRequest")
    @ResponsePayload
    public UpdateBookingResponse updateBooking(@RequestPayload UpdateBookingRequest request) {
        UpdateBookingResponse response = new UpdateBookingResponse();
        repository.updateBooking(request.getId(), request.getBooking());
        return response;
    }

}
