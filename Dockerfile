FROM eclipse-temurin:21.0.2_13-jdk-jammy
WORKDIR /app
COPY /target/*.jar app.jar
ENV GREETING="Bonjour"
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]