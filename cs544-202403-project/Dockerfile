FROM openjdk:21-jdk
WORKDIR /app
RUN ls
COPY cs544-202403-project-2.0.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "--add-opens", "java.base/java.lang=ALL-UNNAMED", "-Xmx256m", "-XX:MaxMetaspaceSize=128m", "-Xss256k", "-jar", "app.jar"]
