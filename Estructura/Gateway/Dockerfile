FROM frolvlad/alpine-oraclejre8:latest 

EXPOSE 8887

# install

# label for the image
LABEL Description="Gateway" Version="0.0.1"

VOLUME data

ADD build/gateway-1.0.0-SNAPSHOT.jar app.jar

# touch the archive for timestamp
RUN sh -c 'touch /app.jar'

# entrypoint to the image on run
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]