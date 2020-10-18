package cz.cvut.fit.niam1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

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

        Path pathInput1 = ResourceUtils.getFile(this.getClass().getResource("/test_input_1.txt")).toPath();
        Path pathInput2 = ResourceUtils.getFile(this.getClass().getResource("/test_input_2.txt")).toPath();
        Path pathExpectedOutput1 = ResourceUtils.getFile(this.getClass().getResource("/expected_output_1.json")).toPath();
        Path pathExpectedOutput2 = ResourceUtils.getFile(this.getClass().getResource("/expected_output_2.json")).toPath();

        String testInput1 = new String(Files.readAllBytes(pathInput1));
        String testInput2 = new String(Files.readAllBytes(pathInput2));
        String expectedOutput1 = new String(Files.readAllBytes(pathExpectedOutput1));
        String expectedOutput2 = new String(Files.readAllBytes(pathExpectedOutput2));

        ResponseEntity<String> response1 = template.postForEntity(base.toString() + path, testInput1, String.class);
        ResponseEntity<String> response2 = template.postForEntity(base.toString() + path, testInput2, String.class);

        assertThat(response1.getBody()).isEqualTo(expectedOutput1);
        assertThat(response2.getBody()).isEqualTo(expectedOutput2);
    }

}