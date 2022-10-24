How to run the Spring Boot application
=====================================
1. Run the application using maven
   $ mvn spring-boot:run
2. Open your browser at http://localhost:8080/swagger-ui.html
   There you can see the REST API documentation and try out the REST API.
3. Open your browser at http://localhost:8080/h2-console
    There you can see the H2 database console and inspect the data stored in the database.
3. You can also test the application using curl or postman
   $ curl http://localhost:8080/prices?brandId=1&productId=35455& date=2020-06-14T10:00:00.00
        The response will be a JSON with the price information for the requested price.
   $ curl http://localhost:8080/prices/all
       The response will be a JSON with all the prices stored in the database.


PROJECT STRUCTURE
=================
The project is structured in the following packages:
- com.example.demo: Main package. Contains the Spring Boot Application.
- com.example.demo.controller: Package with the REST controllers.
- com.example.demo.model: Package with the model classes.
- com.example.demo.repository: Package with the Spring Data JPA repositories.
- com.example.demo.service: Package with the service classes and custom exceptions.
- com.

- src/test/java: Package with the unit tests.
- src/test/resources: Package with the test configuration files.


DATABASE
========
The application uses an H2 database. The database is initialized using a bean method that is executed at startup. The bean method creates some sample data
that can be used to test the application.

The database can be accessed using the h2 console at http://localhost:8080/h2-console

The database is configured to be in memory, so the data is lost when the application is stopped.

The prices are stored in the price table. The price table has the following columns:
- id: The price id.
- brand_id: The brand id.
- product_id: The product id.
- price_list_id: The price list id.
- start_date: The start date of the price.
- end_date: The end date of the price.
- price: The price value.
- currency: The currency of the price.


REST API
========
The application exposes the following REST API:
- GET /prices: Returns the price information for the requested price.
- GET /prices/all: Returns all the prices stored in the database.

The REST API is documented using Swagger. You can see the documentation and try out the REST API using the following URL: http://localhost:8080/swagger-ui.html


TESTS
=====
The application has unit tests for the service classes. The tests are stored in the src/test/java folder.

The tests are executed using maven:
$ mvn test


DEPLOYMENT
==========
The application can be deployed using maven:
$ mvn clean package


AUTHOR
======
Ibrahima Sory Diallo (github.com/sorydi3)


LICENSE
=======
This project is licensed under the terms of the MIT license.









      




