# Show locations

Show all locations.

**URL** : `/location`

**Method** : `GET`

## Success Response

**Code** : `200 OK`

**Content** : In this example, there are 2 locations present.

```json
[
  {
    "id": 2,
    "name": "Death Valley",
    "country": {
      "id": 1,
      "name": "USA"
    }
  },
  {
    "id": 3,
    "name": "Krkonoše",
    "country": {
      "id": 3,
      "name": "Czech republic"
    }
  }
]
```
