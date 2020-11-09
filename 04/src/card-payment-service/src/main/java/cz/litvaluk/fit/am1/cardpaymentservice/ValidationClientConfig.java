package cz.litvaluk.fit.am1.cardpaymentservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ValidationClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("https.courses_fit_cvut_cz.ni_am1.hw.web_services");
        return marshaller;
    }

    @Bean
    public ValidationClient validationClient(Jaxb2Marshaller marshaller) {
        ValidationClient client = new ValidationClient();
        client.setDefaultUri("http://147.32.233.18:8888/NI-AM1-CardValidation/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
