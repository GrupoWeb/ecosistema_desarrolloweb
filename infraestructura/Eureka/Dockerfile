FROM creams/base-container:1.2.5


EXPOSE 8761

# install

# label for the image
LABEL Description="Eureka Server" Version="0.0.1"

# the version of the archive
ARG VERSION=0.0.1

# mount the temp volume
VOLUME eureka_data

# Add the service as app.jar
ADD build/discovery-1.0.0-SNAPSHOT.jar app.jar

# touch the archive for timestamp
RUN sh -c 'touch /app.jar'

# entrypoint to the image on run
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]