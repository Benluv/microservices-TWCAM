FROM bellsoft/liberica-openjdk-alpine:latest
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/consumidores-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} consumidores.jar
ENTRYPOINT ["java", "-jar", "consumidores.jar"]

EXPOSE 8082

