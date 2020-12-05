# Create location

Create a new location (automatic id generation).

**URL** : `/location`

**Method** : `POST`

**Data constraints**

Provide name of the location and id of the country.

```json
{
  "name": "[unicode 64 chars max]",
  "countryId": [integer]
}
```

**Data example**

```json
{
  "name": "Death Valley",
  "countryId": 1
}
```

## Success Response

**Condition** : If everything is OK.

**Code** : `201 CREATED`

**Headers** : `Location: http://t-a.cz/location/1`

**Content example**

```json
{
  "id": 2,
  "name": "Death Valley",
  "country": {
    "id": 1,
    "name": "USA"
  },
  "_links": {
    "GET": {
      "href": "http://t-a.cz/location/2"
    },
    "PUT": {
      "href": "http://t-a.cz/location/2"
    },
    "DELETE": {
      "href": "http://t-a.cz/location/2"
    }
  }
}
```

## Error Response

**Condition** : If any field is missing.

**Code** : `400 BAD REQUEST`

**Content example** In this example, field `name` is missing.

```json
{
  "name": [
    "This field is required."
  ]
}
```

### OR

**Condition** : If the `countryId` does not match with any country that is in the database.

**Code** : `422 UNPROCESSABLE ENTITY`

**Content example** In this example, field `countryId` does not match with any country in the database.

```json
{
  "countryId": [
    "Does not match any country"
  ]
}
```