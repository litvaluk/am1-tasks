package cz.litvaluk.fit.am1.orderprocessor;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.region.policy.PolicyEntry;
import org.apache.activemq.broker.region.policy.PolicyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {

//    @Bean
//    public BrokerService broker() throws Exception {
//        BrokerService brokerService = new BrokerService();
//        brokerService.addConnector("tcp://localhost:5000");
//        brokerService.setPersistent(false);
//        brokerService.setDestinationPolicy(policyMap());
//        return brokerService;
//    }
//
//    @Bean
//    public PolicyMap policyMap(){
//        PolicyMap destinationPolicy = new PolicyMap();
//        List<PolicyEntry> entries = new ArrayList<>();
//        PolicyEntry queueEntry = new PolicyEntry();
//        queueEntry.setQueue(">");
//        queueEntry.setStrictOrderDispatch(false);
//        entries.add(queueEntry);
//        destinationPolicy.setPolicyEntries(entries);
//        return destinationPolicy;
//    }

}
