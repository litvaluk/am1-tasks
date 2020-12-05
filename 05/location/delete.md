# Delete location

Delete a specific location.

**URL** : `/location/{id}`

**URL Parameters** : `id=[integer]` where `id` is the ID of the location to be deleted

**Method** : `DELETE`

## Success Response

**Condition** : If the location exists.

**Code** : `204 NO CONTENT`

**Content** : 
```json
{}
```

## Error Response

**Condition** : If there is no location with the specified ID available to delete.

**Code** : `404 NOT FOUND`

**Content** : 
```json
{}
```

### OR

**Condition** : If the location is present in any tour in the database, so it cannot be deleted.

**Code** : `409 CONFLICT`

**Content example** In this example, tour with `id=2` contains the location that is to be deleted.

```json
[
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
  }
]
```