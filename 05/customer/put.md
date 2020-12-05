# Update customer

Update the customer.

**URL** : `/customer/{id}`

**URL Parameters** : `id=[integer]` where `id` is the ID of the customer to be updated

**Method** : `PUT`

**Data constraints**

```json
{
  "id": [integer],
  "firstName": "[unicode 64 chars max]",
  "lastName": "[unicode 64 chars max]",
  "yearOfBirth": [integer]
}
```

**Data example**

```json
{
  "id": "5",
  "firstName": "Jamie",
  "lastName": "Oliver",
  "yearOfBirth": "1971"
}
```

## Success Response

**Condition** : Update can be performed.

**Code** : `200 OK`

**Content example** :

```json
{
  "id": "5",
  "firstName": "Jamie",
  "lastName": "Oliver",
  "yearOfBirth": "1971",
  "_links": {
    "self": {
      "href": "http://t-a.cz/customer/5"
    },
    "PUT": {
      "href": "http://t-a.cz/customer/5"
    },
    "DELETE": {
      "href": "http://t-a.cz/customer/5"
    }
  }
}
```

## Error Responses

**Condition** : Customer does not exist.

**Code** : `404 NOT FOUND`

**Content** : 
```json
{}
```

### OR

**Condition** : If the customer with the `id` is already present.

**Code** : `409 CONFLICT`

**Content example**

```json
{
  "id": "5",
  "firstName": "Elon",
  "lastName": "Musk",
  "yearOfBirth": "1975",
  "_links": {
    "GET": {
      "href": "http://t-a.cz/customer/5"
    },
    "PUT": {
      "href": "http://t-a.cz/customer/5"
    },
    "DELETE": {
      "href": "http://t-a.cz/customer/5"
    }
  }
}
```