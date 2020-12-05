# Update location

Update the location.

**URL** : `/location/{id}`

**URL Parameters** : `id=[integer]` where `id` is the ID of the location to be updated

**Method** : `PUT`

**Data constraints**

```json
{
  "id": [integer],
  "name": "[unicode 64 chars max]",
  "countryId": [integer]
}
```

**Data example**

```json
{
  "id": "5",
  "name": "Varadero",
  "countryId": 2
}
```

## Success Response

**Condition** : Update can be performed.

**Code** : `200 OK`

**Content example** :

```json
{
  "id": "5",
  "name": "Varadero",
  "countryId": 2
}
```

## Error Responses

**Condition** : Location does not exist.

**Code** : `404 NOT FOUND`

**Content** : 
```json
{}
```

### OR

**Condition** : If the location with the `id` is already present.

**Code** : `409 CONFLICT`

**Content example**

```json
{}
```

### OR

**Condition** : If the `countryId` does not match any country that is in the database.

**Code** : `422 UNPROCESSABLE ENTITY`

**Content example** In this example, field `countryId` does not match any country in the database.

```json
{
  "countryId": [
    "Does not match any country"
  ]
}
```