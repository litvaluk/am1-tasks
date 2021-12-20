# Task 5 - Travel Service REST API

Where full URLs are provided in responses they will be rendered as if service
is running on `http://t-a.org/`

## Endpoints
All endpoints produce `application/hal+json` and requests with `POST`/`PUT` method consume `application/json`.

### Tour related

* [Show tours](tour/list.md) : `GET /tour`
* [Create a new tour](tour/create.md) : `POST /tour`
* [Show tour](tour/get.md) : `GET /tour/{id}`
* [Update tour](tour/put.md) : `PUT /tour/{id}`
* [Delete tour](tour/delete.md) : `DELETE /tour/{id}`
* [Show tours for given customer](tour/customer.md) : `GET /tour/byCustomer`
* [Show tours for given location](tour/location.md) : `GET /tour/byLocation`
* [Show tours for given country](tour/country.md) : `GET /tour/byCountry`

### Customer related

* [Show customers](customer/list.md) : `GET /customer`
* [Create a new customer](customer/create.md) : `POST /customer`
* [Show customer](customer/get.md) : `GET /customer/{id}`
* [Update customer](customer/put.md) : `PUT /customer/{id}`
* [Delete customer](customer/delete.md) : `DELETE /customer/{id}`

### Location related

* [Show locations](location/list.md) : `GET /location`
* [Create a new location](location/create.md) : `POST /location`
* [Show location](location/get.md) : `GET /location/{id}`
* [Update location](location/put.md) : `PUT /location/{id}`
* [Delete location](location/delete.md) : `DELETE /location/{id}`
* [Show locations for given country](location/country.md) : `GET /location/byCountry`

### Country related

* [Show countries](country/list.md) : `GET /country`
* [Create a new country](country/create.md) : `POST /country`
* [Show country](country/get.md) : `GET /country/{id}`
* [Update country](country/put.md) : `PUT /country/{id}`
* [Delete country](country/delete.md) : `DELETE /country/{id}`
