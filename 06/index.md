# Asynchronous tour delete REST service

Simple REST service that simulates an asynchronous tour deletion. When the `DELETE /tour/{id}` is called, it creates an entry in tour delete requests. All `waiting` requests are being processed every 20 second (changes the request status to `processed` and actually deletes the tour).

## Documenation

Full documentation in OpenAPI specification is available in [doc/openapi.json](doc/openapi.json) or at `http://localhost:8080/v3/api-docs` when running the service at `localhost`. The documentation can be previewed online for example by the swagger editor (at `https://editor.swagger.io/`).

### Endpoints
* Show all tours : `GET /tour`
* Show tour : `GET /tour/{id}`
* Create tour : `POST /tour`
* Delete tour : `DELETE /tour/{id}`
* Show all tour delete requests : `GET /tour/tourDeleteRequest`
* Show tour delete request : `GET /tour/tourDeleteRequest/{id}`

## Example

1) Create a tour at 
`/tour` using `POST` method
```json
{
  "id": 4,
  "date": "2020-12-06T12:13:35.117Z",
  "location": "Prague",
  "customers": [
    "Miloš Zeman"
  ]
}
```

2) Create a delete request at `/tour/4` using `DELETE` method
3) Newly created request can be viewed at `/tour/tourDeleteRequest/1` using `GET` (Location of the request is in the header `Location` in the delete response)
```json
{
    "id": 1,
    "status": "waiting",
    "issuedAt": "2020-12-06T12:15:46.467+00:00",
    "tourId": 4,
    "_links": {
        "self": {
            "href": "http://localhost:8080/tour/tourDeleteRequest/1"
        }
    }
}
```
4) The requests are being processed every 20 second, so after maximum of 20 seconds the request should change its status from `waiting` to `processed` and the tour should be deleted (not present in tours).
