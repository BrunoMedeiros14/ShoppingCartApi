<h1 align="center">
  Juju market
</h1>

<p align="center">
  <img src="https://img.shields.io/badge/v1.8.22-orange?logo=kotlin&logoColor=white&label=Kotlin" alt="Kotlin" />
  <img src="https://img.shields.io/badge/v3.1.2-green?logo=spring&logoColor=white&label=Spring-boot" alt="Spring Boot" />
  <img src="https://img.shields.io/badge/v8.1.2-blue?logo=gradle&logoColor=white&label=Gradle" alt="Gradle" />
  <img src="https://img.shields.io/badge/v20.10.24-blue?logo=docker&logoColor=white&label=Docker" alt="Docker" />
  <img src="https://img.shields.io/static/v1?label=Juju%20Market&message=v1.0.0&color=8257E5" alt="Juju Market" />
</p>

Project carried out to complete the TQI challenge after completing the bootcamp provided on the [DIO](https://www.dio.me/ 'DIO website') platform.

[click here](./README.pt-br.md) to see the documentation in Portuguese :brazil:

## Technologies

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Gradle](https://gradle.org)
- [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#data.sql.jpa-and-spring-data)
- [Validation](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#io.validation)
- [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#web)
- [Flyway Migration](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#howto.data-initialization.migration-tool.flyway)

- [Docker Compose](https://docs.docker.com/compose/)

## Application Proposal

As can be seen in the [proposal image](./assets/challenge.png).

The challenge is based on a self-service commerce application, where it is possible to:

1. Register a product category;
2. Register products;
3. Add products to a cart;
4. Make payment for the cart, returning the total value of the cart.

To meet the challenge, a project containing the technologies mentioned above was developed, and a class diagram was created to facilitate development, as shown in the following image:

![./assets/JuMarket_diagram.png](./assets/JuMarket_diagram.png 'Class Diagram')

With this relationship, several endpoints were developed for each entity, as follows:

- Category:
  - **GET** `/api/v1/category` -> Returns all registered categories, returning an error if none exist.
  - **DELETE** `/api/v1/category/{1}` -> Returns an empty body with status 200.
  - **POST** `/api/v1/category` -> Returns the saved category in case of success, returning an error if a similar category already exists.
- Product:
  - **GET** `/api/v1/product` -> Returns all registered products, returning an error if none exist.
  - **GET** `/api/v1/product/{id}` -> Returns the product registered by the id, returning an error if not found.
  - **POST** `/api/v1/product` -> Returns all the product saved in the database.
  - **PUT** `/api/v1/product` -> Returns all the product changed in the database.
  - **DELETE** `/api/v1/product` -> Returns an empty body with status 200.
- Cart:
  - **POST** `/api/v1/cart` -> Returns a created cart.
  - **POST** `/api/v1/cart/pay?id={cartID}&paymentMethod={paymentMethod}` -> Completes the payment of a cart, changing its enum to paid and returning the total value of the purchase, and blocking the cart for changes as the purchase is completed.
  - **GET** `/api/v1/cart` -> Returns all saved carts, returning an error if none are registered.
  - **GET** `/api/v1/cart/{id}` -> Returns the cart by the specified id, returning an error if not found.
  - **DELETE** `/api/v1/cart` -> Returns an empty body with status 200.
- Product Cart
  - **POST** `/api/v1/product-cart` -> Adds products to the cart according to the quantity and product provided.
  - **DELETE** `/api/v1/product-cart` -> Removes products from the cart according to the quantity and product provided, returning an error if the product is not in the cart.

To facilitate testing of the application, [click here](./assets/TQI_challenge.postman_collection.json 'Postman test collection') to download the test collection listed in Postman.

There is also the JSON to generate Swagger Open API documentation for this project [here](./assets/openapi.json 'Open API collection').

Having an expected flow to include a category -> include a product -> create a cart -> add a product to the cart -> make a payment in the cart by informing its id and payment method.

## How to Run

- Clone git repository:

```bash
git clone https://github.com/BrunoMedeiros14/tqi_Kotlin_backend_developer_2023.git
```

- With Java 17 installed on the machine and Java Home configured, run Gradle with the command `gradlew.bat bootRun` on Windows or the command `./gradlew bootRun` on **Linux**.

- With Docker installed, run the database with the command:

```bash
docker run -d --rm  --name postgres  -e POSTGRES_DB=juju_market  -e POSTGRES_USER=root  -e POSTGRES_PASSWORD=juju  -p 5432:5432  postgres:latest
```

- It is also possible to run the docker-compose, which both runs the database and compiles the JAR to execute it, with the command:

```bash
docker-compose up
```
