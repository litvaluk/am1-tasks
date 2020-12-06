package cz.fit.litvaluk.am1.conditionalgetservice.controller;

import cz.fit.litvaluk.am1.conditionalgetservice.entity.Tour;
import cz.fit.litvaluk.am1.conditionalgetservice.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.concurrent.TimeUnit;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class TourController {

    @Autowired
    private TourRepository repository;

    @GetMapping(value = "/tour")
    public ResponseEntity<CollectionModel<Tour>> getTours(WebRequest wr,
            @RequestParam(name = "eTagValidation",required = false) String eTagValidation) {
        if (wr.getHeader(HttpHeaders.IF_NONE_MATCH) != null) {
            if (eTagValidation != null
                    && eTagValidation.equals("weak")
                    && wr.checkNotModified(repository.getWeakETag())) {
                return getToursNotModifiedResponseEntity();
            } else if (wr.checkNotModified(repository.getStrongETag())) {
                return getToursNotModifiedResponseEntity();
            }
        }
        if (wr.getHeader(HttpHeaders.IF_MODIFIED_SINCE) != null
                && wr.checkNotModified(repository.getLastModified())) {
            return getToursNotModifiedResponseEntity();
        }
        if (eTagValidation != null && eTagValidation.equals("weak")) {
            return getToursResponseEntity(true);
        }
        return getToursResponseEntity(false);
    }

    private ResponseEntity<CollectionModel<Tour>> getToursResponseEntity(boolean weakETag) {
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
                .lastModified(repository.getLastModified())
                .eTag(weakETag ? repository.getWeakETag() : repository.getStrongETag())
                .cacheControl(CacheControl.maxAge(10, TimeUnit.SECONDS))
                .body(tours);
    }

    private ResponseEntity<CollectionModel<Tour>> getToursNotModifiedResponseEntity() {
        return ResponseEntity
                .status(HttpStatus.NOT_MODIFIED)
                .lastModified(repository.getLastModified())
                .eTag(repository.getStrongETag())
                .cacheControl(CacheControl.maxAge(10, TimeUnit.SECONDS))
                .build();
    }

    @PostMapping("/tour")
    public ResponseEntity<?> createTour(@RequestBody Tour tour) {
        repository.addTour(tour);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "/tour/" + tour.getId())
                .build();
    }

    @GetMapping(value = "/tour/{id}")
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

    @DeleteMapping(value = "/tour/{id}")
    public ResponseEntity<?> deleteTour(@PathVariable int id) {
        if (!repository.removeTour(id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

}
