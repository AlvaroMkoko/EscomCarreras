FROM eclipse-temurin:21-jdk-alpine
VOLUME /temp
COPY target/*.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]
EXPOSE 10000