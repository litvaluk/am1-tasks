# Show tours for given customer

Show tours for given customer.

**URL** : `/tour/byCustomer`

**URL Query Parameters** : `id=[integer]` where `id` is the ID of the customer for which the tours are to be shown

**Method** : `GET`

## Success Response

**Code** : `200 OK`

**Content** : In this example, there are 2 tours for customer with `id=5` present.

```json
{
  "tours": [
    {
      "id": 1,
      "customers": [
        {
          "id": 3,
          "firstName": "James",
          "lastName": "Bond",
          "yearOfBirth": "1960",
          "_links": {
            "GET": {
              "href": "http://t-a.cz/customer/3"
            },
            "PUT": {
              "href": "http://t-a.cz/customer/3"
            },
            "DELETE": {
              "href": "http://t-a.cz/customer/3"
            }
          }
        },
        {
          "id": 5,
          "firstName": "Gordon",
          "lastName": "Ramsay",
          "yearOfBirth": "1968",
          "_links": {
            "GET": {
              "href": "http://t-a.cz/customer/5"
            },
            "PUT": {
              "href": "http://t-a.cz/customer/5"
            },
            "DELETE": {
              "href": "http://t-a.cz/customer/5"
            }
          }
        }
      ],
      "location": {
        "id": 2,
        "name": "Death Valley",
        "country": {
          "id": 1,
          "name": "USA",
          "_links": {
            "GET": {
              "href": "http://t-a.cz/country/1"
            },
            "PUT": {
              "href": "http://t-a.cz/country/1"
            },
            "DELETE": {
              "href": "http://t-a.cz/country/1"
            }
          }
        },
        "_links": {
          "GET": {
            "href": "http://t-a.cz/location/2"
          },
          "PUT": {
            "href": "http://t-a.cz/location/2"
          },
          "DELETE": {
            "href": "http://t-a.cz/location/2"
          }
        }
      },
      "_links": {
        "GET": {
          "href": "http://t-a.cz/tour/1"
        },
        "PUT": {
          "href": "http://t-a.cz/tour/1"
        },
        "DELETE": {
          "href": "http://t-a.cz/tour/1"
        }
      }
    },
    {
      "id": 2,
      "customer": {
        "id": 5,
        "firstName": "Gordon",
        "lastName": "Ramsay",
        "yearOfBirth": "1968",
        "_links": {
            "GET": {
              "href": "http://t-a.cz/customer/5"
            },
            "PUT": {
              "href": "http://t-a.cz/customer/5"
            },
            "DELETE": {
              "href": "http://t-a.cz/customer/5"
            }
          }
      },
      "location": {
        "id": 5,
        "name": "Varadero",
        "country": {
          "id": 2,
          "name": "Cuba",
          "_links": {
            "GET": {
              "href": "http://t-a.cz/country/2"
            },
            "PUT": {
              "href": "http://t-a.cz/country/2"
            },
            "DELETE": {
              "href": "http://t-a.cz/country/2"
            }
          }
        },
        "_links": {
          "GET": {
            "href": "http://t-a.cz/location/5"
          },
          "PUT": {
            "href": "http://t-a.cz/location/5"
          },
          "DELETE": {
            "href": "http://t-a.cz/location/5"
          }
        }
      },
      "_links": {
        "GET": {
          "href": "http://t-a.cz/tour/2"
        },
        "PUT": {
          "href": "http://t-a.cz/tour/2"
        },
        "DELETE": {
          "href": "http://t-a.cz/tour/2"
        }
      }
    }
  ],
  "_links": {
    "self": {
      "href": "http://t-a.cz/tour/byCustomer?id=5"
    }
  }
}
```
