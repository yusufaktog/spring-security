FROM openjdk:17-jdk-slim AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:17-jdk-slim
WORKDIR spring-security
COPY --from=build target/*.jar spring-security.jar
ENTRYPOINT ["java", "-jar", "spring-security.jar"]