FROM openjdk:17
EXPOSE 9564
ADD target/microo-0.0.1-SNAPSHOT.jar microo-docker.jar
ENTRYPOINT ["java", "-jar", "microo-docker.jar"]
