# Base image: uses Oracle's official OpenJDK 17 image as the starting point
FROM eclipse-temurin:17-jre

# Creates a mount point at /tmp — Spring Boot uses this dir for embedded Tomcat temp files
VOLUME /tmp

# Copies the built JAR file from your local target/ folder into the container, renamed to app.jar
COPY target/*.jar app.jar

# Defines the command that runs when the container starts — launches the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
