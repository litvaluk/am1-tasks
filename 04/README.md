# Task 4 - Card payment service
Simple SOAP/WSDL Web Service for management of card payments written in Java (Spring). The service itself is using an external SOAP/WSDL Web Service to validate the card number and owner available at `http://147.32.233.18:8888/NI-AM1-CardValidation/ws/card.wsdl`.
When running locally (port `8080`), the `WSDL` for the service is available at `http://localhost:8080/ws/payments.wsdl`.

## Example inputs/outputs

### Listing payments
#### Input
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:card="https://lukaslitvan.com/card-payment-service/">
   <soapenv:Header/>
   <soapenv:Body>
      <card:getPaymentsRequest/>
   </soapenv:Body>
</soapenv:Envelope>
```
#### Output
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:getPaymentsResponse xmlns:ns2="https://lukaslitvan.com/card-payment-service/">
         <ns2:payments>
            <ns2:id>1</ns2:id>
            <ns2:cardNumber>1234-1234-1234-1234</ns2:cardNumber>
            <ns2:cardOwner>CardOwner</ns2:cardOwner>
         </ns2:payments>
         <ns2:payments>
            <ns2:id>42</ns2:id>
            <ns2:cardNumber>1234-1234-1234-1234</ns2:cardNumber>
            <ns2:cardOwner>CardOwner</ns2:cardOwner>
         </ns2:payments>
      </ns2:getPaymentsResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

### Add with valid data
#### Input
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:card="https://lukaslitvan.com/card-payment-service/">
   <soapenv:Header/>
   <soapenv:Body>
      <card:addPaymentRequest>
         <card:payment>
            <card:id>1</card:id>
            <card:cardNumber>1234-1234-1234-1234</card:cardNumber>
            <card:cardOwner>CardOwner</card:cardOwner>
         </card:payment>
      </card:addPaymentRequest>
   </soapenv:Body>
</soapenv:Envelope>
```
#### Output
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:addPaymentResponse xmlns:ns2="https://lukaslitvan.com/card-payment-service/">
         <ns2:added>true</ns2:added>
      </ns2:addPaymentResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

### Add with invalid data
#### Input
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:card="https://lukaslitvan.com/card-payment-service/">
   <soapenv:Header/>
   <soapenv:Body>
      <card:addPaymentRequest>
         <card:payment>
            <card:id>1</card:id>
            <card:cardNumber>1234567890</card:cardNumber>
            <card:cardOwner>JeffBezos</card:cardOwner>
         </card:payment>
      </card:addPaymentRequest>
   </soapenv:Body>
</soapenv:Envelope>
```
#### Output
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:addPaymentResponse xmlns:ns2="https://lukaslitvan.com/card-payment-service/">
         <ns2:added>false</ns2:added>
      </ns2:addPaymentResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```
