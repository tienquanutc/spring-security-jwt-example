FROM eclipse-temurin:17-jre-alpine
COPY build/libs/spring-security-jwt-example.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]