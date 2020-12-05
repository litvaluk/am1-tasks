# Show customer

Show a specific customer.

**URL** : `/customer/{id}`

**URL Parameters** : `id=[integer]` where `id` is the ID of the customer to be shown

**Method** : `GET`

## Success Response

**Condition** : If customer with the specified ID exists.

**Code** : `200 OK`

**Content** :

```json
{
  "id": 3,
  "firstName": "James",
  "lastName": "Bond",
  "yearOfBirth": "1960",
  "_links": {
    "self": {
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

**Condition** : If customer does not exist with the specified `id`.

**Code** : `404 NOT FOUND`

**Content** : 
```json
{}
```