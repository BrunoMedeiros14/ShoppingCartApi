<h1 align="center">
  Juju market
</h1>

<p align="center">
  <img src="https://img.shields.io/badge/v1.8.22-orange?logo=kotlin&logoColor=white&label=Docker" alt="Gradle" />
  <img src="https://img.shields.io/badge/v3.1.2-green?logo=spring&logoColor=white&label=Spring-boot" alt="Spring Boot" />
  <img src="https://img.shields.io/badge/v8.1.2-blue?logo=gradle&logoColor=white&label=Gradle" alt="Gradle" />
  <img src="https://img.shields.io/badge/v20.10.24-blue?logo=docker&logoColor=white&label=Docker" alt="Gradle" />
  <img src="https://img.shields.io/static/v1?label=Juju_Market&message=v1.0.0&color=8257E5" alt="Demo" />
</p>

Projeto realizado para completar o desafio TQI após a finalização do bootcamp disponibilizado na plataforma [DIO](https://www.dio.me/ 'Site da DIO').

## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Gradle](https://gradle.org)
- [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#data.sql.jpa-and-spring-data)
- [Validation](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#io.validation)
- [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#web)
- [Flyway Migration](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#howto.data-initialization.migration-tool.flyway)

- [Docker Compose](https://docs.docker.com/compose/)

## Proposta de aplicativo

Conforme pode ser visualizada na [imagem da proposta](./assets/challenge.png).

O desafia se basei em um aplicativo para auto-atendimento de um comércio, no qual é possível:

1. Cadastrar categoria de produto;
2. Cadastrar produtos;
3. Adicionar produtos a um carrinho;
4. Realizar pagamento do carrinho retornando o valor total do carrinho.

Para realizar o desafio, foi feito um projeto contendo as tecnologias citadas acima, sendo assim, foi desenvolvido um diagrama de classe facilitar o desenvolvimento, conforme a imagem a seguir:

![./assets/JuMarket_diagram.png](./assets/JuMarket_diagram.png 'Diagrama de classe')

Com esse relacionamento, foi desenvolvido vários endpoints para cada entidade, sendo:

- Category:
  - **GET** `/api/v1/category` -> Retorna todas as categoria cadastradas, retornando erro se não houver.
  - **DELETE** `/api/v1/category/{1}` -> Retorna um corpo vazio com status 200.
  - **POST** `/api/v1/category` -> Retorna a categoria salva em caso de sucesso, retornando erro em caso de já haver uma categoria igual.
- Product:
  - **GET** `/api/v1/product` -> Retorna todos os produtos cadastrados, retornando erro se não houver.
  - **GET** `/api/v1/product/{id}` -> Retorna o produto cadastrado pelo id, retornando erro se não houver.
  - **POST** `/api/v1/product` -> Retorna todos o produto salvo no banco de dados.
  - **PUT** `/api/v1/product` -> Retorna todos o produto alterado no banco de dados.
  - **DELETE** `/api/v1/product` -> Retorna um corpo vazio com status 200.
- Cart:
  - **POST** `/api/v1/cart` -> Retorna um carrinho criado.
  - **POST** `/api/v1/cart/pay?id={cartID}&paymentMethod={paymentMethod}` -> finaliza o pagamento de um carrinho, alterando seu enum para pago e retornando o valor total da compra e bloqueando o carrinho para alterações por estar finalizada a compra.
  - **GET** `/api/v1/cart` -> Retorna todos os carrinhos salvos, retornando erro se não houver nenhum cadastrado.
  - **GET** `/api/v1/cart/{id}` -> Retorna o carrinho pelo id informado, retornando um erro se não for encontrado.
  - **DELETE** `/api/v1/cart` -> Retorna um corpo vazio com status 200.
- Product Cart
  - **POST** `/api/v1/product-cart` -> Adiciona produtos no carrinho conforme a quantidade e produto informado.
  - **DELETE** `/api/v1/product-cart` -> Remove produtos do carrinho conforma e quantidade e produto informado, retornando erro se não houver o produto no carrinho.

Para facilitar o teste do aplicativo e [clique aqui](./assets/TQI_challenge.postman_collection.json 'Coleção de teste api no postman') para baixar a coleção de testes listada no postman.

E também há o json para gerar documentação Open Api Swagger desse projeto [aqui](./assets/openapi.json 'Coleção open api').

Tendo um fluxo esperado de incluir uma categoria -> incluir um produto -> criar um carrinho -> adicionar produto no carrinho -> realizar pagamento no carrinho informando seu id e o método de pagamento.

## Como Executar

- Clonar repositório git:

```bash
git clone https://github.com/BrunoMedeiros14/tqi_Kotlin_backend_developer_2023.git
```

- Com o java 17 instalado na máquina e o Java Home configurado, execute o gradle com o comando `gradlew.bat bootRun` no **windows** ou o comando `./gradlew bootRun` no **linux**.

- Com o docker instalado rodar o banco de dados com o comando:

```bash
docker run -d --rm  --name postgres  -e POSTGRES_DB=juju_market  -e POSTGRES_USER=root  -e POSTGRES_PASSWORD=juju  -p 5432:5432  postgres:latest
```

- Sendo possível também executar o docker compose que contém tanto executa o banco de dados e compila o jar para executá-lo, com o comando:

```bash
docker-compose up
```
