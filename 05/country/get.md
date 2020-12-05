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
  "id": 4,
  "name": "USA"
}
```
## Error Response

**Condition** : If country does not exist with the specified `id`.

**Code** : `404 NOT FOUND`

**Content** : 
```json
{}
```