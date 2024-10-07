# syntax = docker/dockerfile:1.2
#
# Build stage
#
FROM maven:3.8.6-openjdk-18 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package assembly:single -DskipTests

#
# Package stage
#
FROM openjdk:18-jdk-slim
WORKDIR /app
COPY --from=build /app/target/DeccoSalud-1.0-SNAPSHOT-jar-with-dependencies.jar DeccoSalud.jar
# Establecer el puerto por defecto
ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "DeccoSalud.jar"]
