# sales-taxes-problem

> Exercise by Xpeppers



## Table of Contents

- [Requirement](#requirement)
- [Run](#run)
- [Usage](#usage)
- [License](#license)



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

## License
Copyright 2020 Paolo Montana

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
