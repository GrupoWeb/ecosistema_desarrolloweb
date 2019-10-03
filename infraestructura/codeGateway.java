# hystrix.command.fallbackcmd.execution.isolation.thread.timeoutInMilliseconds: 2000
# hystrix.command.default.execution.isolation.strategy: THREAD

kc:
  #base-url: http://192.168.99.100:8080/auth
  base-url: http://172.20.0.8:8080/auth
  realm: dev
  realm-url: ${kc.base-url}/realms/${kc.realm}

hystrix:
    command:
        fallbackcmd:
            execution:
                isolation:
                    thread:
                        timeoutInMilliseconds: 5000
spring:
  application:
    name: api-gateway
  cloud:
    gateway:
      routes:

        - id: book-store
          uri: lb://book-store
          predicates:
            - Path=/api/books/**
          filters:
            - name: RequestRateLimiter
              args:
                key-resolver: '#{@userKeyResolver}'
                redis-rate-limiter.replenishRate: 2
                redis-rate-limiter.burstCapacity: 2
            - RewritePath=/api/(?<books>.*), /$\{books}
            - name: Hystrix
              args:
                name: booksFallbackCommand
                fallbackUri: forward:/fallback/books


        - id: movie-store
          uri: lb://movie-store
          predicates:
            - Path=/api/movies/**
          filters:
            - name: RequestRateLimiter
              args:
                key-resolver: '#{@userKeyResolver}'
                redis-rate-limiter.replenishRate: 2
                redis-rate-limiter.burstCapacity: 2
            - RewritePath=/api/(?<movies>.*), /$\{movies}
            - AddResponseHeader=X-Some-Header, aboullaite.me


        # - id: car-inventory
        #   #uri: lb://car-inventory
        #   uri: http://localhost:8010/api/cars/
        #   predicates:
        #     - Path=/api/cars/**
        #   filters:
        #     - name: RequestRateLimiter
        #       args:
        #         key-resolver: '#{@userKeyResolver}'
        #         redis-rate-limiter.replenishRate: 2
        #         redis-rate-limiter.burstCapacity: 2
        #     - TokenRelay=
        #     - RewritePath=/api/(?<cars>.*), /$\{cars}

  redis:
    host: 172.20.0.2
    port: 6379
    jedis:
      pool:
        max-active: 100
        max-idle: 100

  autoconfigure:
    # TODO: remove when fixed https://github.com/spring-projects/spring-security/issues/6314
    exclude: org.springframework.boot.actuate.autoconfigure.security.reactive.ReactiveManagementWebSecurityAutoConfiguration



  security:
    oauth2:
      client:
        registration:
          keycloak:
            client-id: dev-umg
            # client-name: service-book
            client-secret: 94c3c371-e488-491d-b58a-4c5f4d871782
            provider: keycloak
            # authorization-grant-type: authorization_code
            authorization-grant-type: authorization_code
            scope: openid, profile
            redirectUri: '{baseUrl}/login/oauth2/code/{registrationId}'
            # redirect-uri-template: ${kc.realm-url}/account/
            # redirect-uri-template: "${kc.realm-url}/account"
            # redirectUri: ${kc.realm-url}/account
            # redirect-uri-template: "http://localhost:8889/books/"
            # redirect-uri-template: '{baseUrl}/login/oauth2/code/{registrationId}'
            # redirect-uri-template: 'https://www.google.com/'
        provider:
          keycloak:
            token-uri: ${kc.realm-url}/protocol/openid-connect/token
            authorization-uri: ${kc.realm-url}/protocol/openid-connect/auth
            user-info-uri: ${kc.realm-url}/protocol/openid-connect/userinfo
            jwk-set-uri: ${kc.realm-url}/protocol/openid-connect/certs
            user-name-attribute: preferred_username
            # authorization-uri: http://192.168.99.100:8080/auth/realms/dev/protocol/openid-connect/auth
            # token-uri: http://192.168.99.100:8080/auth/realms/dev/protocol/openid-connect/token
            # user-info-uri: http://192.168.99.100:8080/auth/realms/dev/protocol/openid-connect/userinfo
            # jwk-set-uri: http://192.168.99.100:8080/auth/realms/dev/protocol/openid-connect/certs
          #  user-info-uri: ${kc.realm-url}/protocol/openid-connect/userinfo ----- publi-clent=false
            # principal-attibute=preferred_username, autodetect-bearer-only=true



server:
  port: 8887

eureka:
 client:
   serviceUrl:
    #  defaultZone: http://localhost:8761/eureka
    # defaultZone: http://192.168.99.100:8761/eureka
      defaultZone: http://172.20.0.5:8761/eureka
 instance:
   preferIpAddress: true

management:
  endpoints:
    web:
      exposure:
        include: "*"
        #include: hystrix.stream


logging:
  level:
    root: INFO
    org.springframework.web: INFO
    org.springframework.security: INFO
    # org.springframework.security: INFO
    org.springframework.boot.autoconfigure: DEBUG
 