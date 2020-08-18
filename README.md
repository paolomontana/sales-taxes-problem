# sales-taxes-problem

> Exercise by Xpeppers



## Table of Contents

- [Requirement](#requirement)
- [Run](#run)
- [Usage](#usage)



---

## Requirement

- Java 11
- Apache Maven 3.6

---

## Run

- Open terminal
- Change directory to root project
- Digit "java -jar salestaxes-0.1.jar"

If you want compile: go to the root project and digit: "mvn package"

---

## Usage
- Make sure you have port 8080 free, alternatively you can change it from file "application.yml"
- With any client, you can make an http call like this:

```

Type: GET
Url: localhost:8080/receipt
Headers: [Content-Type: application/json]
Body (Example): {
  "products": [
    {
      "name": "book",
      "quantity": 2,
      "originalPrice": 12.49,
      "imported": false,
      "taxed": false
    },
    ....
  ]
}
```

---
