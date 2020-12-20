package cz.litvaluk.fit.am1.tripsloadbalancer.loadbalancer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class LoadBalancer {

    private static final Logger LOG = LoggerFactory.getLogger(LoadBalancer.class);

    private static final String RESOURCE_1 = "http://147.32.233.18:8888/MI-MDW-LastMinute1/list";
    private static final String RESOURCE_2 = "http://147.32.233.18:8888/MI-MDW-LastMinute2/list";
    private static final String RESOURCE_3 = "http://147.32.233.18:8888/MI-MDW-LastMinute3/list";

    private List<URI> usableURIs = new ArrayList<>();
    private int index = 0;

    @Autowired
    RestTemplate restTemplate;

    public URI getNextResourceURI() throws NoAvailableResourceException {
        if (index == -1) {
            throw new NoAvailableResourceException("No resource is available at the moment...");
        }
        URI uri = usableURIs.get(index);
        index++;
        if (index >= usableURIs.size()) {
            index = 0;
        }
        return uri;
    }

    @Scheduled(initialDelay = 100, fixedDelay = 10000)
    public void update() throws URISyntaxException {
        LOG.info("Updating load balancer...");
        usableURIs = new ArrayList<>();
        Arrays.asList(new URI(RESOURCE_1), new URI(RESOURCE_2), new URI(RESOURCE_3)).forEach(uri -> {
            if (getResourceStatusCode(uri) == HttpStatus.OK) {
                usableURIs.add(uri);
                LOG.info("--- {} available", uri.toString());
            } else {
                LOG.info("--- {} NOT available", uri.toString());
            }
        });
        index = usableURIs.size() > 0 ? 0 : -1;
    }

    private HttpStatus getResourceStatusCode(URI uri) {
        ResponseEntity<String> response;
        try {
            response = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);
        } catch (HttpStatusCodeException e) {
            return e.getStatusCode();
        }
        return response.getStatusCode();
    }

}
