FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/MyWebsite2Application.jar MyWebsite2Application.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "MyWebsite2Application.jar"]