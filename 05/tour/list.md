# Show tours

Show all tours.

**URL** : `/tour/`

**Method** : `GET`

## Success Responses

**Code** : `200 OK`

**Content** : In this example, there are 2 tours present.

```json
[
  {
    "id": 1,
    "customers": [
      {
        "id": 3,
        "firstName": "James",
        "lastName": "Bond",
        "yearOfBirth": "1960"
      },
      {
        "id": 5,
        "firstName": "Gordon",
        "lastName": "Ramsay",
        "yearOfBirth": "1968"
      }
    ],
    "location": {
      "id": 2,
      "name": "Death Valley",
      "country": {
        "id": 1,
        "name": "USA"
      }
    }
  },
  {
    "id": 2,
    "customer": {
      "id": 5,
      "firstName": "Gordon",
      "lastName": "Ramsay",
      "yearOfBirth": "1968"
    },
    "location": {
      "id": 5,
      "name": "Varadero",
      "country": {
        "id": 2,
        "name": "Cuba"
      }
    }
  },
]
```
