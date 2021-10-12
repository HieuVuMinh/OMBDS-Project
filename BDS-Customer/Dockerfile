FROM openjdk:8-jdk-alpine
ADD target/docker-spring-boot.jar docker-spring-boot.jar
EXPOSE 8080
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","docker-spring-boot.jar"]
