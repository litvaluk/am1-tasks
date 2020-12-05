# Show tour

Show a specific tour.

**URL** : `/tour/{id}`

**URL Parameters** : `id=[integer]` where `id` is the ID of the tour to be shown

**Method** : `GET`

## Success Response

**Condition** : If tour with the specified ID exists.

**Code** : `200 OK`

**Content** :

```json
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
    "self": {
      "href": "http://t-a.cz/tour/1"
    },
    "PUT": {
      "href": "http://t-a.cz/tour/1"
    },
    "DELETE": {
      "href": "http://t-a.cz/tour/1"
    }
  }
}
```

## Error Response

**Condition** : If tour does not exist with the specified `id`.

**Code** : `404 NOT FOUND`

**Content** : 
```json
{}
```