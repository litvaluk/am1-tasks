package cz.litvaluk.fit.am1.bookingprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class BookingProcessor {

    private static final Logger LOG = LoggerFactory.getLogger(BookingProcessor.class);

    @JmsListener(destination = "bookingQueue")
    public void processBooking(String booking) {
        LOG.info("Processing booking");
    }

}
