FROM openjdk:21-jdk
WORKDIR /app
RUN ls
COPY cs544-202403-project-2.0.0-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD java --add-opens java.base/java.lang=ALL-UNNAMED -Dserver.port=$PORT -Xmx384m -jar app.jar
