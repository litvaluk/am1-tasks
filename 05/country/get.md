# Show country

Show a specific tour.

**URL** : `/tour/{id}`

**URL Parameters** : `id=[integer]` where `id` is the ID of the country to be shown

**Method** : `GET`

## Success Response

**Condition** : If country with the specified ID exists.

**Code** : `200 OK`

**Content** :

```json
{
  "id": 1,
  "name": "USA",
  "_links": {
    "self": {
      "href": "http://t-a.cz/country/1"
    },
    "PUT": {
      "href": "http://t-a.cz/country/1"
    },
    "DELETE": {
      "href": "http://t-a.cz/country/1"
    }
  }
}
```
## Error Response

**Condition** : If country does not exist with the specified `id`.

**Code** : `404 NOT FOUND`

**Content** : 
```json
{}
```