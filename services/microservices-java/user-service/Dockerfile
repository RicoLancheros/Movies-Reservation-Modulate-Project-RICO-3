# Utilizar una imagen oficial de Maven para compilar el proyecto
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY . .

RUN mvn package -DskipTests

FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY --from=build /app/target/user-service-*.jar user-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "user-service.jar"]
