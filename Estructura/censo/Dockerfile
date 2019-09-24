FROM frolvlad/alpine-oraclejre8:latest 

EXPOSE 8889

# install

# label for the image
LABEL Description="Censo" Version="0.0.1"

# VOLUME data

ADD build/demo-0.0.1-SNAPSHOT.jar app.jar

RUN sh -c 'touch /app.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]