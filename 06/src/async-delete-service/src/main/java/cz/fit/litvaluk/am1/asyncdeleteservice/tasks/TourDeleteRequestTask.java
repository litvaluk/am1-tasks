package cz.fit.litvaluk.am1.asyncdeleteservice.tasks;

import cz.fit.litvaluk.am1.asyncdeleteservice.repository.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TourDeleteRequestTask {

    private static final Logger log = LoggerFactory.getLogger(TourDeleteRequestTask.class);

    @Autowired
    private Repository repository;

    @Scheduled(initialDelay = 10000, fixedRate = 20000)
    public void processTourDeleteRequests() {
        int processed = repository.processWaitingTourDeleteRequests();
        log.info(processed + " tour delete requests processed.");
    }

}
