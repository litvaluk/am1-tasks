# Task 1

Simple microservice that transforms input from one format to another. It is written as a simple Spring application. The transform feature is available as a `POST` request at `/transform` which consumes `text/plain` and produces `application/json`. There is one test implemented (using Spring Boot), which tests two requests (one provided, one custom).

Example input:
```
Dear Sir or Madam,

please find the details about my booking below:

===
Tour id: "1"
Location: "Bohemian Switzerland"
Person: "Jan Novak"
===

Regards,
Jan Novak
```

Example output:
```json
{
  "person": {
    "surname": "Novak",
    "name": "Jan"
  },
  "location": "Bohemian Switzerland",
  "id": "1"
}
```