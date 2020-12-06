package cz.fit.litvaluk.am1.asyncdeleteservice.controller;

import cz.fit.litvaluk.am1.asyncdeleteservice.entity.Tour;
import cz.fit.litvaluk.am1.asyncdeleteservice.entity.TourDeleteRequest;
import cz.fit.litvaluk.am1.asyncdeleteservice.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/tour")
public class TourController {

    @Autowired
    private Repository repository;

    @GetMapping
    public ResponseEntity<CollectionModel<Tour>> getTours() {
        CollectionModel<Tour> tours = CollectionModel.of(repository.getTours());
        tours.removeLinks();
        tours.add(linkTo(TourController.class).withSelfRel());
        tours.getContent().forEach(t -> {
            t.removeLinks();
            t.add(linkTo(TourController.class).slash(t.getId()).withRel("GET"));
            t.add(linkTo(TourController.class).slash(t.getId()).withRel("DELETE"));
        });
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tours);
    }

    @PostMapping
    public ResponseEntity<?> createTour(@RequestBody Tour tour) {
        repository.addTour(tour);
        tour.removeLinks();
        tour.add(linkTo(TourController.class).slash(tour.getId()).withRel("GET"));
        tour.add(linkTo(TourController.class).slash(tour.getId()).withRel("DELETE"));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "/tour/" + tour.getId())
                .build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tour> getTour(@PathVariable int id) {
        Tour tour = repository.getTour(id);
        if (tour == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        tour.removeLinks();
        tour.add(linkTo(TourController.class).slash(tour.getId()).withSelfRel());
        tour.add(linkTo(TourController.class).slash(tour.getId()).withRel("DELETE"));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tour);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteTour(@PathVariable int id) {
        TourDeleteRequest request = repository.createTourDeleteRequest(id);
        if (request == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Location", "/tourDeleteRequest/" + request.getId())
                .build();
    }

    @GetMapping(value = "/tourDeleteRequest")
    public ResponseEntity<CollectionModel<TourDeleteRequest>> getTourDeleteRequests() {
        CollectionModel<TourDeleteRequest> tourDeleteRequests = CollectionModel.of(repository.getTourDeleteRequests());
        tourDeleteRequests.removeLinks();
        tourDeleteRequests.add(linkTo(TourController.class).slash("tourDeleteRequest").withSelfRel());
        tourDeleteRequests.getContent().forEach(tdr -> {
            tdr.removeLinks();
            tdr.add(linkTo(TourController.class)
                    .slash("tourDeleteRequest")
                    .slash(tdr.getId())
                    .withRel("GET")
            );
        });
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tourDeleteRequests);
    }

    @GetMapping(value = "/tourDeleteRequest/{id}")
    public ResponseEntity<TourDeleteRequest> getTourDeleteRequest(@PathVariable int id) {
        TourDeleteRequest tourDeleteRequest = repository.getTourDeleteRequest(id);
        if (tourDeleteRequest == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        tourDeleteRequest.removeLinks();
        tourDeleteRequest.add(linkTo(TourController.class)
                .slash("tourDeleteRequest")
                .slash(tourDeleteRequest.getId())
                .withSelfRel());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tourDeleteRequest);
    }

}
