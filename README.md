## Run The server
mvn spring-boot:run

## Run The Data Store
Postgres needs to be installed and the following properties need to be changed in the 
`application.properties` file

```$xslt
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username= sanyogeetalawande
spring.datasource.password=
```

## Test
The BE-assignment.html file can be used for testing the end points.
