# Show locations for given country

Show locations for given country.

**URL** : `/location/byCountry`

**URL Query Parameters** : `id=[integer]` where `id` is the ID of the country for which the locations are to be shown

**Method** : `GET`

## Success Response

**Code** : `200 OK`

**Content** : In this example, there is 1 location for country with `id=1` present.

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
    }
  ],
  "_links": {
    "self": {
      "href": "http://t-a.cz/location/byCountry?id=1"
    }
  }
}
```
