package cz.fit.litvaluk.am1.asyncdeleteservice.repository;

import cz.fit.litvaluk.am1.asyncdeleteservice.entity.Tour;
import cz.fit.litvaluk.am1.asyncdeleteservice.entity.TourDeleteRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class Repository {

    private final static Logger log = LoggerFactory.getLogger(Repository.class);

    private final List<Tour> tours = new ArrayList<>();
    private final List<TourDeleteRequest> processedTourDeleteRequests = new ArrayList<>();
    private final List<TourDeleteRequest> waitingTourDeleteRequests = new ArrayList<>();
    private int tourDeleteRequestIdAutoIncrement = 1;

    @PostConstruct
    public void init() {
        Calendar calendar1 = new GregorianCalendar(2020, Calendar.NOVEMBER, 21);
        List<String> customers1 = Arrays.asList("Chuck Norris", "Elon Musk");
        String location1 = "Bali";
        Tour t1 = new Tour(1, calendar1.getTime(), location1, customers1);

        Calendar calendar2 = new GregorianCalendar(2021, Calendar.APRIL, 1);
        List<String> customers2 = Collections.singletonList("Ladislav Vagner");
        String location2 = "Progtestland";
        Tour t2 = new Tour(2, calendar2.getTime(), location2, customers2);

        Calendar calendar3 = new GregorianCalendar(2021, Calendar.JULY, 5);
        List<String> customers3 = Arrays.asList("Miloš Zeman", "Jiří Ovčáček");
        String location3 = "Lipno";
        Tour t3 = new Tour(3, calendar3.getTime(), location2, customers2);

        tours.add(t1);
        tours.add(t2);
        tours.add(t3);
    }

    public List<Tour> getTours() {
        return tours;
    }

    public Tour getTour(int id) {
        return tours.stream().filter(t -> t.getId() == id).findAny().orElse(null);
    }

    public void addTour(Tour tour) {
        tours.add(tour);
    }

    public void deleteTour(int id) {
        tours.removeIf(t -> t.getId() == id);
    }

    public List<TourDeleteRequest> getTourDeleteRequests() {
        List<TourDeleteRequest> tourDeleteRequests = new ArrayList<>();
        tourDeleteRequests.addAll(processedTourDeleteRequests);
        tourDeleteRequests.addAll(waitingTourDeleteRequests);
        return tourDeleteRequests;
    }

    public TourDeleteRequest getTourDeleteRequest(int id) {
        List<TourDeleteRequest> tourDeleteRequests = new ArrayList<>();
        tourDeleteRequests.addAll(processedTourDeleteRequests);
        tourDeleteRequests.addAll(waitingTourDeleteRequests);
        return tourDeleteRequests.stream().filter(tdr -> tdr.getId() == id).findAny().orElse(null);
    }

    public TourDeleteRequest createTourDeleteRequest(int id) {
        Optional<Tour> tour = tours.stream().filter(t -> t.getId() == id).findAny();
        if (!tour.isPresent()) {
            return null;
        }
        TourDeleteRequest request = new TourDeleteRequest(
                tourDeleteRequestIdAutoIncrement,
                "waiting",
                new Date(),
                tour.get().getId()
        );
        waitingTourDeleteRequests.add(request);
        tourDeleteRequestIdAutoIncrement++;
        log.info("New tour delete request created (tourId = {}).", id);
        return request;
    }

    public int processWaitingTourDeleteRequests() {
        int size = waitingTourDeleteRequests.size();
        waitingTourDeleteRequests.forEach(tdr -> {
            tdr.setStatus("processed");
            deleteTour(tdr.getTourId());
        });
        processedTourDeleteRequests.addAll(waitingTourDeleteRequests);
        waitingTourDeleteRequests.clear();
        return size;
    }

}
