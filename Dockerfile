FROM maven:3.6.3-jdk-8-slim AS maven_build

COPY pom.xml /tmp/

COPY src /tmp/src/

WORKDIR /tmp/

RUN mvn package

FROM openjdk:8-jdk-alpine

EXPOSE 8080

CMD java -jar covid-1.0-SNAPSHOT.jar

COPY --from=maven_build /tmp/target/covid-1.0-SNAPSHOT.jar covid-1.0-SNAPSHOT.jar