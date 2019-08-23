# ecosistema_desarrolloweb

# Create Network Name

$ docker network create --driver=bridge --subnet=150.168.0.0/16 projectdw2019_mongo_net

# Exec Keycloak and  Postgres

$ docker-compose -f compose-keycloak.yaml up

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


*****************************************************************************************
*****************************************************************************************

###Configuration Guide                                                                  *
                                                                                        *
****https://scalac.io/user-authentication-keycloak-1/                                   *
                                                                                        *
## Keycloak in Laravel                                                                  *
****https://github.com/robsontenorio/laravel-keycloak-guard                             *

## Container Redis
 $ docker run --name some-redis -p --net projectdw2019_mongo_net 6379:6379 -d redis