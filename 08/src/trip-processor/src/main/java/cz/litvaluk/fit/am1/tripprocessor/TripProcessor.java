package cz.litvaluk.fit.am1.tripprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TripProcessor {

    private static final Logger LOG = LoggerFactory.getLogger(TripProcessor.class);

    @JmsListener(destination = "tripQueue")
    public void processTrip(String trip) {
        LOG.info("Processing trip");
    }

}
