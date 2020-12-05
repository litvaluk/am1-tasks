# Show locations

Show all locations.

**URL** : `/location`

**Method** : `GET`

## Success Response

**Code** : `200 OK`

**Content** : In this example, there are 2 locations present.

```json
{
  "locations": [
    {
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
    {
      "id": 3,
      "name": "Krkonoše",
      "country": {
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
      },
      "_links": {
        "GET": {
          "href": "http://t-a.cz/location/3"
        },
        "PUT": {
          "href": "http://t-a.cz/location/3"
        },
        "DELETE": {
          "href": "http://t-a.cz/location/3"
        }
      }
    }
  ],
  "_links": {
    "self": {
      "href": "http://t-a.cz/location"
    }
  }
}
```
