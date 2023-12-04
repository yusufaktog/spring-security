FROM maven:3.9.5-sapmachine-21 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package test -DskipTests
EXPOSE 1035
ENTRYPOINT ["java","-jar","/home/app/target/security-trial-0.0.1-SNAPSHOT.jar"]