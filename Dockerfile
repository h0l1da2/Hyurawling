FROM eclipse-temurin:17-jdk-jammy AS builder

WORKDIR /app

COPY src ./src
COPY build/libs/*.jar hyu.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "hyu.jar"]