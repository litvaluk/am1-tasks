# Update tour

Update the tour.

**URL** : `/tour/{id}`

**URL Parameters** : `id=[integer]` where `id` is the ID of the tour to be updated

**Method** : `PUT`

**Data constraints**

```json
{
  "id": [integer],
  "locationId": [integer],
  "customerIds": [[integer], [integer], ...]
}
```

**Data example**

```json
{
  "id": 1,
  "locationId": 3,
  "customerIds": [5]
}
```

## Success Response

**Condition** : Update can be performed.

**Code** : `200 OK`

**Content example** :

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
    }
  ],
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

## Error Responses

**Condition** : Tour does not exist.

**Code** : `404 NOT FOUND`

**Content** : 
```json
{}
```

### OR

**Condition** : If the tour with the `id` is already present.

**Code** : `409 CONFLICT`

**Content example**

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

### OR

**Condition** : If the `locationId` does not match any location that is in the database or an id from the `customerIds` does not match any customer that is in the database.

**Code** : `422 UNPROCESSABLE ENTITY`

**Content example** In this example, there is an id in `customerIds` that does not match with any customer in the database.

```json
{
  "customerIds": [
    "Contains id that does not match any customer"
  ]
}
```