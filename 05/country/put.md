# Update country

Update the country.

**URL** : `/country/{id}`

**URL Parameters** : `id=[integer]` where `id` is the ID of the country to be updated

**Method** : `PUT`

**Data constraints**

```json
{
  "id": [integer],
  "name": "[unicode 64 chars max]",
}
```

**Data example**

```json
{
  "id": "4",
  "name": "Spain",
}
```

## Success Response

**Condition** : Update can be performed.

**Code** : `200 OK`

**Content example** :

```json
{
  "id": 4,
  "name": "Spain"
}
```

## Error Responses

**Condition** : Country does not exist.

**Code** : `404 NOT FOUND`

**Content** : 
```json
{}
```

### OR

**Condition** : If the country with the `id` is already present.

**Code** : `409 CONFLICT`

**Content example**

```json
{}
```