package cz.cvut.fit.niam1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void test() throws Exception {
        String path = "transform/";

        String testInput1 = new String(Files.readAllBytes(Paths.get("/Users/litvaluk/Documents/School/AM1/litvaluk/01/src/task1/src/test/java/cz/cvut/fit/niam1/test_input_1.txt")));
        String expectedOutput1 = new String(Files.readAllBytes(Paths.get("/Users/litvaluk/Documents/School/AM1/litvaluk/01/src/task1/src/test/java/cz/cvut/fit/niam1/expected_output_1.json")));

        String testInput2 = new String(Files.readAllBytes(Paths.get("/Users/litvaluk/Documents/School/AM1/litvaluk/01/src/task1/src/test/java/cz/cvut/fit/niam1/test_input_2.txt")));
        String expectedOutput2 = new String(Files.readAllBytes(Paths.get("/Users/litvaluk/Documents/School/AM1/litvaluk/01/src/task1/src/test/java/cz/cvut/fit/niam1/expected_output_2.json")));

        ResponseEntity<String> response1 = template.postForEntity(base.toString() + path, testInput1, String.class);
        ResponseEntity<String> response2 = template.postForEntity(base.toString() + path, testInput2, String.class);

        assertThat(response1.getBody()).isEqualTo(expectedOutput1);
        assertThat(response2.getBody()).isEqualTo(expectedOutput2);
    }

}