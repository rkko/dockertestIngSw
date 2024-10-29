# Usa una imagen de JDK para construir la aplicación
FROM maven:3.8.6-openjdk-11 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Usa una imagen de JRE para ejecutar la aplicación
FROM openjdk:11-jre-slim
COPY --from=build /app/target/myApp-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
