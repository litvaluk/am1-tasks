package cz.litvaluk.fit.am1.orderclient;

import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.Random;

@Component
public class ProduceOrderTask {

    private static final Logger LOG = LoggerFactory.getLogger(ProduceOrderTask.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue orderQueue;

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("orderQueue");
    }

    @Scheduled(initialDelay = 3000, fixedDelay = 3000)
    public void produceOrder() {
        switch(new Random().nextInt(2)) {
            case 0:
                LOG.info("Producing new order (booking)");
                jmsTemplate.convertAndSend(orderQueue, "booking");
                break;
            case 1:
                LOG.info("Producing new order (trip)");
                jmsTemplate.convertAndSend(orderQueue, "trip");
                break;
        }
    }

}
