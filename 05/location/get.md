# Show location

Show a specific location.

**URL** : `/location/{id}`

**URL Parameters** : `id=[integer]` where `id` is the ID of the location to be shown

**Method** : `GET`

## Success Response

**Condition** : If location with the specified ID exists.

**Code** : `200 OK`

**Content** :

```json
{
  "id": 2,
  "name": "Death Valley",
  "country": {
    "id": 1,
    "name": "USA"
  }
}
```

## Error Response

**Condition** : If location does not exist with the specified `id`.

**Code** : `404 NOT FOUND`

**Content** : 
```json
{}
```