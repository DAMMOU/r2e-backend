FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copier d'abord seulement le POM (pour mieux utiliser le cache Docker)
COPY pom.xml .

# Puis copier le code source
COPY src ./src

# Builder l'application
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar", "--spring.profiles.active=prod"]