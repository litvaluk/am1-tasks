# Task 9 - Trip Service (Load Balancer)

Simple REST service for listing trips. When the `GET` request at `/trips` is initiated, the service chooses among the available endpoints. The availability of the endpoints is updated every 10 seconds or when an error occurs on a first try (the target endpoint may get unavailable between the availability checks).

## Example
```sh
curl --location --request GET 'http://localhost:8080/trips'
```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<records>
    <record type="trip">
      <id>1</id>
      <location>Bohemian Switzerland</location>
      <capacity>5</capacity>
      <occupied>1</occupied>
    </record>
</records>
```
