# Delete country

Delete a specific country.

**URL** : `/country/{id}`

**URL Parameters** : `id=[integer]` where `id` is the ID of the country to be deleted

**Method** : `DELETE`

## Success Response

**Condition** : If the country exists.

**Code** : `204 NO CONTENT`

**Content** : 
```json
{}
```

## Error Response

**Condition** : If there is no country with the specified ID available to delete.

**Code** : `404 NOT FOUND`

**Content** : 
```json
{}
```

### OR

**Condition** : If the country is present in any location in the database, so it cannot be deleted.

**Code** : `409 CONFLICT`

**Content example** In this example, location with `id=2` contains the country that is to be deleted.

```json
[
  {
    "id": 2,
    "name": "Death Valley",
    "country": {
      "id": 1,
      "name": "USA"
    }
  }
]
```
