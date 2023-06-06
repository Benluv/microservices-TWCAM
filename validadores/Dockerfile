FROM openjdk:latest
RUN groupadd -r spring && useradd -r -g spring spring
USER spring:spring
ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} TWCAM-MultiDB-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java","-jar","TWCAM-PRODUCTOR-0.0.1-SNAPSHOT.jar" ]

EXPOSE 8083