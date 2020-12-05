# Show customers

Show all customers.

**URL** : `/customer`

**Method** : `GET`

## Success Response

**Code** : `200 OK`

**Content** : In this example, there are 2 customers present.

```json
{
  "customers": [
    {
      "id": 3,
      "firstName": "James",
      "lastName": "Bond",
      "yearOfBirth": "1960",
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
    },
    {
      "id": 5,
      "firstName": "Gordon",
      "lastName": "Ramsay",
      "yearOfBirth": "1968",
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
  ],
  "_links": {
    "self": {
      "href": "http://t-a.cz/customer"
    }
  }
}
```
