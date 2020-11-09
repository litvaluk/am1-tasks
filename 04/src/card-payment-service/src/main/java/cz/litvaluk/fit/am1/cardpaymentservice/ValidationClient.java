package cz.litvaluk.fit.am1.cardpaymentservice;

import https.courses_fit_cvut_cz.ni_am1.hw.web_services.ValidateCardRequest;
import https.courses_fit_cvut_cz.ni_am1.hw.web_services.ValidateCardResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class ValidationClient extends WebServiceGatewaySupport {

    public ValidateCardResponse validateCard(String cardNumber, String cardOwner) {
        ValidateCardRequest request = new ValidateCardRequest();
        request.setCardNumber(cardNumber);
        request.setCardOwner(cardOwner);
        return (ValidateCardResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

}
