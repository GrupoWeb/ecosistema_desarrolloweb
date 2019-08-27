FROM frolvlad/alpine-oraclejre8:latest 

EXPOSE 8889

# install

# label for the image
LABEL Description="Book" Version="0.0.1"

VOLUME data

ADD . /build

# RUN sh -c 'touch /app.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/build/bookstore-1.0.0-SNAPSHOT.jar"]