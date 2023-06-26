FROM bellsoft/liberica-openjdk-alpine:latest
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/productores-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} productores.jar
ENTRYPOINT ["java", "-jar", "productores.jar"]

EXPOSE 8080

