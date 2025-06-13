# 1. Build-Stage: mit Gradle das Projekt bauen
FROM gradle:8.4-jdk21 AS build
WORKDIR /app
COPY . .
RUN gradle installDist

# 2. Runtime-Stage: nur das Nötigste mitnehmen
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/build/install/ktor-sample /app
CMD ["./bin/ktor-sample"]
