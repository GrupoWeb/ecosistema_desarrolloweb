# ecosistema_desarrolloweb

-Exec Keycloak and  Postgres

$ docker-compose -f compose-postgres.yaml up

Entrar a Postgres

- entrar a exec con bach al server
$ docker exec -it ecosistemadesarrolloweb_postgres_1 bash

Ejecutar:
$ psql -U keycloak -W
Listar Databases:

$ \l


-- Dockerfile de Eureka

$ docker build -t <name_container> .

$ docker run -d -p 8761:8761 --net <name_red> --ip <ip_red> --name <name_container> <container>

-- docker-compose mysql

$ docker-compose -f compose-mysql.yaml up


-- docker-compose mongo

$ docker-compose -f compose-mongo.yaml up

-- node

$ docker pull node
