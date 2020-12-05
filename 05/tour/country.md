# Show tours for given country

Show tours for given country.

**URL** : `/tour/byCountry`

**URL Query Parameters** : `id=[integer]` where `id` is the ID of the country for which the tours are to be shown

**Method** : `GET`

## Success Response

**Code** : `200 OK`

**Content** : In this example, there is 1 tour for country with `id=2` present.

```json
{
  "tours": [
    {
      "id": 1,
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
      "href": "http://t-a.cz/tour/byCountry?id=2"
    }
  }
}
```
