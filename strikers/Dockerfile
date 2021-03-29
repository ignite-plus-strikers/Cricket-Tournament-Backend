FROM java:8-jdk-alpine

COPY ./target/cassandraspringboot-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch cassandraspringboot-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","cassandraspringboot-0.0.1-SNAPSHOT.jar"]