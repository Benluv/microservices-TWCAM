FROM bellsoft/liberica-openjdk-alpine:latest
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/mongo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} mongo.jar
ENTRYPOINT ["java", "-jar", "mongo.jar"]

EXPOSE 27018

