            ecosistema_desarrolloweb
====================================================

***Create Network Name***
```
$ docker network create --driver=bridge --subnet=150.168.0.0/16 projectdw2019_mongo_net
```

***Run Keycloak and  Postgres***
```
$ docker-compose -f compose-keycloak.yaml up
```
1. Entrar a Postgres
=================
```
- entrar a exec con bach al server
$ docker exec -it ecosistemadesarrolloweb_postgres_1 bash

Ejecutar:

$ psql -U keycloak -W

Listar Databases:
    $ \l
```

***Dockerfile de Eureka***

```
$ docker build -t <name_container> .

$ docker run -d -p 8761:8761 --net projectdw2019_mongo_net --ip 192.168.1.150 --name aureka eureka
$ docker run -d -p 8761:8761 --net projectdw2019_mongo_net --ip 151.168.1.150 --name aureka eureka


```

***docker-compose mysql***

```
$ docker-compose -f compose-mysql.yaml up

$ docker exec -it mysq mysql -uroot -p

-- GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'secret' WITH GRANT OPTION;

```

***docker-compose mongo***

```
$ docker-compose -f compose-mongo.yaml up

```

***node***

```
$ docker pull node

```

***book prueba***

```

$ docker build -t book .

$ docker run -d --net projectdw2019_mongo_net --ip 192.168.1.151 --name book  frolvlad/alpine-oraclejre8:lates

--- docker tools
$ docker run -d --net projectdw2019_mongo_net --ip 151.168.1.151 --name books  book

```

***Run Container Gateway***

```
$ docker build -t gateway .

$ docker run -d --net projectdw2019_mongo_net --ip 151.168.1.160 --name gateway  gateway2

```

***redis***
```
 $ docker run --name some-redis -p  6379:6379 -d redis

 ```
*****************************************************************************************
*****************************************************************************************
```
###Configuration Guide                                                                  *
                                                                                        *
****https://scalac.io/user-authentication-keycloak-1/                                   *
                                                                                        *
## Keycloak in Laravel                                                                  *
****https://github.com/robsontenorio/laravel-keycloak-guard                             *

## configurar keycloak 2
******https://medium.com/@bcarunmail/securing-rest-api-using-keycloak-and-spring-oauth2-6ddf3a1efcc2
******https://github.com/spring-projects/spring-security/tree/master/samples/boot/oauth2login
******https://github.com/hantsy/keycloak-springsecurity5-sample/blob/master/src/main/resources/application.yml

## Container Redis
```
--También necesitará una instancia de redis en ejecución (en el puerto 6379) para habilitar el limitador de solicitud de la puerta de enlace. El wat más fácil es girar una instancia de redis en el contenedor docker:



docker-compose stop && docker-compose -f docker-compose.yml rm -f
// para detener la pila
docker-compose -f docker-compose.yaml rm -f

https://www.npmjs.com/package/eureka-js-client