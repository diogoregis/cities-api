# cities-api



### Esse projeto utiliza:

- Spring Boot
- Maven
- Swagger
- Java 8
- Conexão ao PostgreSQL



Essa API visa realizar o cálculo da distancia entre duas cidades, considerando suas longitudes e latitudes, utilizando apenas GET. (Retorna a distância em Metros, Quilômetros e Milhas)

Após populado o banco e startado, API pode ser acessada browser:

http://localhost:8080/swagger.html



## DataBase

### Postgres



```shell script
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres:13.2-alpine
```

### Populate

* [data](https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL)

```shell script
cd ~/workspace/sql-paises-estados-cidades/PostgreSQL

docker run -it --rm --net=host -v $PWD:/tmp postgres:13.2-alpine /bin/bash

psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql

psql -h localhost -U postgres_user_city cities

CREATE EXTENSION cube; 
CREATE EXTENSION earthdistance;
```



*** O banco utiliza apenas cidades do Brasil.