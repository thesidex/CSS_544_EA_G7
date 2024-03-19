FROM openjdk:21-jdk
WORKDIR /app
COPY target/cs544-202403-project-2.0.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
