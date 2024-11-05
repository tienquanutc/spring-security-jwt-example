FROM eclipse-temurin:17-jre-alpine
COPY build/libs/location*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]