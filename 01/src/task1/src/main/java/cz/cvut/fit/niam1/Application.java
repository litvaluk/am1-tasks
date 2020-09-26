package cz.cvut.fit.niam1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;


@RestController
@EnableAutoConfiguration
public class Application {

    private Transformer transformer = new Transformer();

    @PostMapping(value = "/transform", consumes = "text/plain", produces = "application/json")
    String transform(@RequestBody String input) {
        return transformer.transform(input);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}