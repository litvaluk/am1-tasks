# Conditional GET tours REST service

Simple REST service for adding/listing/deleting tours. It emphasizes the cacheability using `If-Modified-Since`/`Last-Modified` and `If-None-Match`/`ETag` headers (`Cache-Control` max-age = 10 seconds). 

## Documenation

Full documentation in OpenAPI specification is available in [doc/openapi.json](doc/openapi.json) or at `http://localhost:8080/v3/api-docs` when running the service at `localhost`. The documentation can be previewed online for example by the swagger editor (at `https://editor.swagger.io/`).

### Endpoints
* Show all tours : `GET /tour`
* Show tour : `GET /tour/{id}`
* Create tour : `POST /tour`
* Delete tour : `DELETE /tour/{id}`

## Example
1) Add one tour
```sh
curl --location --request POST 'http://localhost:8080/tour' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 1,
    "name": "Prague",
    "customers": ["Chuck Norris", "Elon Musk"]
}'
```
```
NO CONTENT
```
```
201 Created
```
2) List tours
```sh
curl --location --request GET 'http://localhost:8080/tour'
```
```json
{
    "_embedded": {
        "tourList": [
            {
                "id": 1,
                "name": "Prague",
                "customers": [
                    "Chuck Norris",
                    "Elon Musk"
                ],
                "_links": {
                    "GET": {
                        "href": "http://localhost:8080/1"
                    },
                    "DELETE": {
                        "href": "http://localhost:8080/1"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080"
        }
    }
}
```
```
200 OK
```
3) List tours with parameter eTagValidation="weak" (returns header `ETag` with weak ETag)
```sh
curl --location --request GET 'http://localhost:8080/tour?eTagValidation=weak'
```
```json
{
    "_embedded": {
        "tourList": [
            {
                "id": 1,
                "name": "Prague",
                "customers": [
                    "Chuck Norris",
                    "Elon Musk"
                ],
                "_links": {
                    "GET": {
                        "href": "http://localhost:8080/1"
                    },
                    "DELETE": {
                        "href": "http://localhost:8080/1"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080"
        }
    }
}
```
```
200 OK
```
4) List tours with If-Modified-Since (date after last modified)
```sh
curl --location --request GET 'http://localhost:8080/tour' \
--header 'If-Modified-Since: Sun, 06 Dec 2020 21:10:00 GMT'
```
```
NO CONTENT
```
```
304 Not Modified
```
5) List tours with If-None-Match (matching strong ETag)
```sh
curl --location --request GET 'http://localhost:8080/tour' \
--header 'If-None-Match: "-1911418363"'
```
```
NO CONTENT
```
```
304 Not Modified
```
6) List tours with If-None-Match header and parameter eTagValidation="weak" (matching weak ETag)
```sh
curl --location --request GET 'http://localhost:8080/tour?eTagValidation=weak' \
--header 'If-None-Match: "1-Prague"'
```
```
NO CONTENT
```
```
304 Not Modified
```
7) Add another tour
```sh
curl --location --request POST 'http://localhost:8080/tour' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 2,
    "name": "Brno",
    "customers": ["Miloš Zeman", "Jiří Ovčáček"]
}'
```
```
NO CONTENT
```
```
201 Created
```
8) List tours (if `If-Modified-Since` header is a date before the date, when the list was modified or the `If-None-Match` does not match the weak/strong ETag, it should list the tours)
```sh
curl --location --request GET 'http://localhost:8080/tour' \
--header 'If-Modified-Since: Sun, 06 Dec 2020 21:10:00 GMT'
```
```json
{
    "_embedded": {
        "tourList": [
            {
                "id": 1,
                "name": "Prague",
                "customers": [
                    "Chuck Norris",
                    "Elon Musk"
                ],
                "_links": {
                    "GET": {
                        "href": "http://localhost:8080/1"
                    },
                    "DELETE": {
                        "href": "http://localhost:8080/1"
                    }
                }
            },
            {
                "id": 2,
                "name": "Brno",
                "customers": [
                    "Miloš Zeman",
                    "Jiří Ovčáček"
                ],
                "_links": {
                    "GET": {
                        "href": "http://localhost:8080/2"
                    },
                    "DELETE": {
                        "href": "http://localhost:8080/2"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080"
        }
    }
}
```
```
200 OK
```
