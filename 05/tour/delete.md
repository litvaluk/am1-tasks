# Delete tour

Delete a specific tour.

**URL** : `/tour/{id}`

**URL Parameters** : `id=[integer]` where `id` is the ID of the tour to be deleted

**Method** : `DELETE`

## Success Response

**Condition** : If the tour exists.

**Code** : `204 NO CONTENT`

**Content** : 
```json
{}
```

## Error Response

**Condition** : If there is no tour with the specified ID available to delete.

**Code** : `404 NOT FOUND`

**Content** : 
```json
{}
```
