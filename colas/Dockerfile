FROM bellsoft/liberica-openjdk-alpine:latest
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/colas-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} colas.jar
ENTRYPOINT ["java", "-jar", "colas.jar"]

EXPOSE 8081

