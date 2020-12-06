package cz.fit.litvaluk.am1.conditionalgetservice.repository;

import cz.fit.litvaluk.am1.conditionalgetservice.entity.Tour;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.*;

@Component
public class TourRepository {

    private final List<Tour> tours = new ArrayList<>();
    private long lastModified = Instant.now().toEpochMilli();

    @PostConstruct
    public void init() {
        Tour t1 = new Tour(1, "Bali", Arrays.asList("Chuck Norris", "Elon Musk"));
        Tour t2 = new Tour(2, "Progtestland", Collections.singletonList("Ladislav Vagner"));
        Tour t3 = new Tour(3, "Lipno", Arrays.asList("Miloš Zeman", "Jiří Ovčáček"));
//        addTour(t1);
//        addTour(t2);
//        addTour(t3);
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void addTour(Tour tour) {
        tours.add(tour);
        lastModified = Instant.now().toEpochMilli();
    }

    public Tour getTour(int id) {
        return tours.stream().filter(t -> t.getId() == id).findAny().orElse(null);
    }

    public boolean removeTour(int id) {
        boolean isRemoved = tours.removeIf(t -> t.getId() == id);
        if(isRemoved) {
            lastModified = Instant.now().toEpochMilli();
        }
        return isRemoved;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    public String getWeakETag() {
        StringJoiner sj = new StringJoiner("-");
        tours.forEach(t -> {
            sj.add(t.getId() + "-" + t.getName());
        });
        return sj.toString();
    }

    public String getStrongETag() {
        return String.valueOf(hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourRepository that = (TourRepository) o;
        return lastModified == that.lastModified &&
                tours.equals(that.tours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tours, lastModified);
    }

}
