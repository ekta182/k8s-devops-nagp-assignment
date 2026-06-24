# ---- Stage 1: build the jar ------------------------------------------------
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /build
# Cache dependencies first for faster rebuilds
COPY pom.xml .
RUN mvn -q dependency:go-offline
COPY src ./src
RUN mvn -q clean package -DskipTests

# ---- Stage 2: minimal runtime ---------------------------------------------
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Run as a non-root user (security + some clusters enforce it)
RUN useradd -r -u 1001 appuser
COPY --from=build /build/target/k8s-finops-api-1.0.0.jar app.jar
USER appuser

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
