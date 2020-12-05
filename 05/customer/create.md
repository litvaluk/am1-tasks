# Create customer

Create a new customer (automatic id generation).

**URL** : `/customer`

**Method** : `POST`

**Data constraints**

Provide first name, last name and year of birth of the customer to be created.

```json
{
  "firstName": "[unicode 64 chars max]",
  "lastName": "[unicode 64 chars max]",
  "yearOfBirth": [integer]
}
```

**Data example**

```json
{
  "name": "James",
  "name": "Bond",
  "yearOfBirth": 1960
}
```

## Success Response

**Condition** : If everything is OK.

**Code** : `201 CREATED`

**Headers** : `Location: http://t-a.cz/customer/3`

**Content example**

```json
{
  "id": 3,
  "name": "James",
  "name": "Bond",
  "yearOfBirth": 1960,
  "_links": {
    "GET": {
      "href": "http://t-a.cz/customer/3"
    },
    "PUT": {
      "href": "http://t-a.cz/customer/3"
    },
    "DELETE": {
      "href": "http://t-a.cz/customer/3"
    }
  }
}
```

## Error Response

**Condition** : If any field is missing.

**Code** : `400 BAD REQUEST`

**Content example** In this example, field `firstName` is missing.

```json
{
  "firstName": [
    "This field is required."
  ]
}
```
