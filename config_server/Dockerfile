#Start with a base image containing Java runtime
FROM openjdk:21-jdk-slim

# Add the application's jar to the image
COPY target/config_server-0.0.1-SNAPSHOT.jar config_server-0.0.1-SNAPSHOT.jar

# execute the application
ENTRYPOINT ["java", "-jar", "config_server-0.0.1-SNAPSHOT.jar"]

# Expose the application port
EXPOSE 8012