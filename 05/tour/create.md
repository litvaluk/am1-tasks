# Create tour

Create a new tour (automatic id generation).

**URL** : `/tour`

**Method** : `POST`

**Data constraints**

Provide name of the tour, id of the location and ids of the customers.

```json
{
  "countryId": [integer],
  "customerIds": [[integer], [integer], ...]
}
```

**Data example**

```json
{
  "countryId": 1,
  "customerIds": [3, 5]
}
```

## Success Response

**Condition** : If everything is OK.

**Code** : `201 CREATED`

**Headers** : `Location: http://t-a.cz/tour/1`

**Content example**

```json
{
  "id": 1,
  "customers": [
    {
      "id": 3,
      "firstName": "James",
      "lastName": "Bond",
      "yearOfBirth": "1960"
    },
    {
      "id": 5,
      "firstName": "Gordon",
      "lastName": "Ramsay",
      "yearOfBirth": "1968"
    }
  ],
  "location": {
    "id": 2,
    "name": "Death Valley",
    "country": {
      "id": 1,
      "name": "USA"
    }
  }
}
```

## Error Response

**Condition** : If any field is missing.

**Code** : `400 BAD REQUEST`

**Content example** In this example, field `countryId` is missing.

```json
{
  "countryId": [
    "This field is required."
  ]
}
```

### OR

**Condition** : If the `locationId` does not match with any location that is in the database or an id from the `customerIds` does not match with any customer that is in the database.

**Code** : `422 UNPROCESSABLE ENTITY`

**Content example** In this example, there is an id in `customerIds` that does not match with any customer in the database.

```json
{
  "customerIds": [
    "Contains id that does not match any customer"
  ]
}
```