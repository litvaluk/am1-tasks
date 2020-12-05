# Show countries

Show all countries.

**URL** : `/country`

**Method** : `GET`

## Success Response

**Code** : `200 OK`

**Content** : In this example, there are 3 countries present.

```json
{
  "countries": [
    {
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
    {
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
    {
      "id": 3,
      "name": "Czech republic",
      "_links": {
        "GET": {
          "href": "http://t-a.cz/country/3"
        },
        "PUT": {
          "href": "http://t-a.cz/country/3"
        },
        "DELETE": {
          "href": "http://t-a.cz/country/3"
        }
      }
    }
  ],
  "_links": {
    "self": {
      "href": "http://t-a.cz/country"
    }
  }
}
```
