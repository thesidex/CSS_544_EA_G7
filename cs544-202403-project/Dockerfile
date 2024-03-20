FROM openjdk:21-jdk
WORKDIR /app
RUN ls
COPY cs544-202403-project-2.0.0-SNAPSHOT.jar app.jar
RUN jar tf app.jar | grep '.env'
EXPOSE 8080
ENTRYPOINT ["sleep", "infinity"]
