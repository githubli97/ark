FROM java:8-jdk-alpine

COPY ./target/ark-identify-starter-1.0-SNAPSHOT.jar /usr/ark/

WORKDIR /usr/ark

RUN sh -c 'touch ark-identify-starter-1.0-SNAPSHOT.jar'

ENTRYPOINT ["java", "-jar", "ark-identify-starter-1.0-SNAPSHOT.jar"]