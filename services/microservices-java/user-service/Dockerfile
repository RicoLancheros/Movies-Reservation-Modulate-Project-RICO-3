# Utilizar una imagen oficial de Maven para compilar el proyecto
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copiar el pom.xml padre y el pom.xml del módulo
COPY pom.xml .
COPY services/microservices-java/user-service/pom.xml ./services/microservices-java/user-service/

# Descargar las dependencias
RUN mvn dependency:go-offline -f services/microservices-java/user-service/pom.xml

# Copiar el código fuente
COPY services/microservices-java/user-service/src ./services/microservices-java/user-service/src

# Compilar el proyecto
RUN mvn package -f services/microservices-java/user-service/pom.xml -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copiar el JAR generado
COPY --from=build /app/services/microservices-java/user-service/target/user-service-*.jar user-service.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "user-service.jar"]