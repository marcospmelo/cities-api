<h1 align="center">API REST de Consulta de Cidades do Brasil</h1>
# DIO Cities API

##### Endpoints
[/cities](https://cities-api-dio-java.herokuapp.com/cities "/cities")
<br />
[/countries](https://cities-api-dio-java.herokuapp.com/countries?page=5&size=50&sort=id,asc "/countries")
<br />
[/countries/{id}](https://cities-api-dio-java.herokuapp.com/countries/1 "/countries/{id}")
<br />
[/states](https://cities-api-dio-java.herokuapp.com/states "/states")
<br />
[/distances/by-cube](https://cities-api-dio-java.herokuapp.com/distances/by-cube?from=4929&to=5254 "/distances/by-cube")
<br />
[/distances/by-points](https://cities-api-dio-java.herokuapp.com/distances/by-points?from=4929&to=5254 "/distances/by-points")

##### Framework do Projeto
- [Spring Initializr](https://start.spring.io/ "Spring Initializr")
- **Project:** Gradle-Groovy Project
- **Language:** Java
- **Spring Boot:** 2.7.7

##### Project Metadata
- **Group:** com.github.marcospmelo
- **Artifact:** cities-api
- **Name:** cities-api
- **Description:** Demo Project for Spring Boot
- **Package name:** com.github.marcospmelo.cities-api
- **Packaging:** Jar
- **Java:** 8

##### Dependencies
- Spring Web
- Spring Data JPA
- PostgreSQL Driver

## Requirements

* Linux
* Git
* Java 8
* Docker
* IntelliJ Community
* Heroku CLI

## DataBase

### Postgres

* [Postgres Docker Hub](https://hub.docker.com/_/postgres)

```shell script
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres
```

### Populate

* [data](https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL)

```shell script
cd ~/workspace/sql-paises-estados-cidades/PostgreSQL

docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash

psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql

psql -h localhost -U postgres_user_city cities

CREATE EXTENSION cube; 
CREATE EXTENSION earthdistance;
```

### Windows
```
docker run -it --rm --net=host -v C:\dio\workspace\sql-paises-estados-cidades\PostgreSQL:/tmp postgres /bin/bash 
```

* [Postgres Earth distance](https://www.postgresql.org/docs/current/earthdistance.html)
* [earthdistance--1.0--1.1.sql](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.0--1.1.sql)
* [OPERATOR <@>](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.1.sql)
* [postgrescheatsheet](https://postgrescheatsheet.com/#/tables)
* [datatype-geometric](https://www.postgresql.org/docs/current/datatype-geometric.html)

### Access

```shell script
docker exec -it cities-db /bin/bash

psql -U postgres_user_city cities
```

### Query Earth Distance

Point
```roomsql
select ((select lat_lon from cidade where id = 4929) <@> (select lat_lon from cidade where id=5254)) as distance;
```

Cube
```roomsql
select earth_distance(
    ll_to_earth(-21.95840072631836,-47.98820114135742), 
    ll_to_earth(-22.01740074157715,-47.88600158691406)
) as distance;
```

## Spring Boot

* [https://start.spring.io/](https://start.spring.io/)

+ Java 8
+ Gradle Project
+ Jar
+ Spring Web
+ Spring Data JPA
+ PostgreSQL Driver

### Spring Data

* [jpa.query-methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods)

### Properties

* [appendix-application-properties](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html)
* [jdbc-database-connectio](https://www.codejava.net/java-se/jdbc/jdbc-database-connection-url-for-common-databases)

### Types

* [JsonTypes](https://github.com/vladmihalcea/hibernate-types)
* [UserType](https://docs.jboss.org/hibernate/orm/3.5/api/org/hibernate/usertype/UserType.html)

## Heroku

* [DevCenter](https://devcenter.heroku.com/articles/getting-started-with-gradle-on-heroku)

## Code Quality

### PMD

+ https://pmd.github.io/pmd-6.8.0/index.html

### Checkstyle

+ https://checkstyle.org/

+ https://checkstyle.org/google_style.html

+ http://google.github.io/styleguide/javaguide.html

```shell script
wget https://raw.githubusercontent.com/checkstyle/checkstyle/master/src/main/resources/google_checks.xml
```

