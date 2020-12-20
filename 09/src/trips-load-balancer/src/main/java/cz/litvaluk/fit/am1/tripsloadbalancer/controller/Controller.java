package cz.litvaluk.fit.am1.tripsloadbalancer.controller;

import cz.litvaluk.fit.am1.tripsloadbalancer.loadbalancer.LoadBalancer;
import cz.litvaluk.fit.am1.tripsloadbalancer.loadbalancer.NoAvailableResourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class Controller {

    private static final Logger LOG = LoggerFactory.getLogger(Controller.class);

    @Autowired
    LoadBalancer loadBalancer;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/trips")
    public ResponseEntity<String> getTrips() throws NoAvailableResourceException, URISyntaxException {
        ResponseEntity<String> response;
        try {
            URI uri = loadBalancer.getNextResourceURI();
            LOG.info("Using: {}", uri.toString());
            response = restTemplate.getForEntity(uri, String.class);
        } catch (Exception e) {
            LOG.info("Error occured, updating load balancer and trying again...");
            loadBalancer.update();
            URI uri = loadBalancer.getNextResourceURI();
            LOG.info("Using: {}", uri.toString());
            response = restTemplate.getForEntity(uri, String.class);
        }
        return response;
    }

}
