FROM bellsoft/liberica-openjdk-alpine:latest
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/validadores-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} validadores.jar
ENTRYPOINT ["java", "-jar", "validadores.jar"]

EXPOSE 8083

