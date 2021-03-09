## SilentEight Recruitment Task

The application enables detecting gender by given name and returning available tokens for each gender. The recruitment application was written using Java 11, Spring, Gradle.

- [x] detecting gender by given name

```request:
  method: POST
  url: /api/gender-detection
  body:
    name: String
  headers:
    Content-Type: application/json
```

- [x] returning available tokens for each gender
```
request:
  method: GET
  url: /api/available-tokens
  headers:
    Content-Type: application/json
```
