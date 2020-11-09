package cz.litvaluk.fit.am1.cardpaymentservice;

import https.lukaslitvan_com.card_payment_service.AddPaymentRequest;
import https.lukaslitvan_com.card_payment_service.AddPaymentResponse;
import https.lukaslitvan_com.card_payment_service.GetPaymentsRequest;
import https.lukaslitvan_com.card_payment_service.GetPaymentsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@org.springframework.ws.server.endpoint.annotation.Endpoint
public class Endpoint {

    @Autowired
    private Repository repository;

    @Autowired
    private ValidationClient client;

    @PayloadRoot(namespace = "https://lukaslitvan.com/card-payment-service/", localPart = "getPaymentsRequest")
    @ResponsePayload
    public GetPaymentsResponse getPayments(@RequestPayload GetPaymentsRequest request) {
        GetPaymentsResponse response = new GetPaymentsResponse();
        response.getPayments().addAll(repository.getPayments());
        return response;
    }

    @PayloadRoot(namespace = "https://lukaslitvan.com/card-payment-service/", localPart = "addPaymentRequest")
    @ResponsePayload
    public AddPaymentResponse addPayment(@RequestPayload AddPaymentRequest request) {
        AddPaymentResponse response = new AddPaymentResponse();
        String cardNumber = request.getPayment().getCardNumber();
        String cardOwner = request.getPayment().getCardOwner();
        if (client.validateCard(cardNumber, cardOwner).isResult()) {
            repository.addPayment(request.getPayment());
        }
        return response;
    }

}
