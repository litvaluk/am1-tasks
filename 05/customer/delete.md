# Delete customer

Delete a specific customer.

**URL** : `/customer/{id}`

**URL Parameters** : `id=[integer]` where `id` is the ID of the customer to be deleted

**Method** : `DELETE`

## Success Response

**Condition** : If the customer exists.

**Code** : `204 NO CONTENT`

**Content** : 
```json
{}
```

## Error Response

**Condition** : If there is no customer with the specified ID available to delete.

**Code** : `404 NOT FOUND`

**Content** : 
```json
{}
```
