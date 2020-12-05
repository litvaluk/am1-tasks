# Create country

Create a new country (automatic id generation).

**URL** : `/country`

**Method** : `POST`

**Data constraints**

Provide name of country to be created.

```json
{
  "name": "[unicode 64 chars max]"
}
```

**Data example**

```json
{
  "name": "China"
}
```

## Success Response

**Condition** : If everything is OK.

**Code** : `201 CREATED`

**Headers** : `Location: http://t-a.cz/country/4`

**Content example**

```json
{
  "id": 4,
  "name": "China",
  "_links": {
    "GET": {
      "href": "http://t-a.cz/country/4"
    },
    "PUT": {
      "href": "http://t-a.cz/country/4"
    },
    "DELETE": {
      "href": "http://t-a.cz/country/4"
    }
  }
}
```

## Error Response

**Condition** : If any field is missing.

**Code** : `400 BAD REQUEST`

**Content example**

```json
{
  "name": [
    "This field is required."
  ]
}
```
