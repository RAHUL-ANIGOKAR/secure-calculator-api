# =========================
# Stage 1: Build the app
# =========================
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# =========================
# Stage 2: Runtime image
# =========================
FROM eclipse-temurin:17-jre

# Create non-root user (security best practice)
RUN useradd -m appuser

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

RUN chown -R appuser:appuser /app
USER appuser

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
