package cz.litvaluk.fit.am1.orderprocessor;

import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class OrderProcessor {

    private static final Logger LOG = LoggerFactory.getLogger(OrderProcessor.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue bookingQueue;

    @Autowired
    private Queue tripQueue;

    @Bean
    public Queue bookingQueue() {
        return new ActiveMQQueue("bookingQueue");
    }

    @Bean
    public Queue tripQueue() {
        return new ActiveMQQueue("tripQueue");
    }

    @JmsListener(destination = "orderQueue")
    public void processOrder(String order) {
        switch (order){
            case "booking":
                LOG.info("Forwarding order (order -> bookingQueue)");
                jmsTemplate.convertAndSend(bookingQueue, order);
                break;
            case "trip":
                LOG.info("Forwarding order (order -> tripQueue)");
                jmsTemplate.convertAndSend(tripQueue, order);
                break;
        }
    }

}
