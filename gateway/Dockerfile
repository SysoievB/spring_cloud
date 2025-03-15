#Start with a base image containing Java runtime
FROM openjdk:21-jdk-slim

# Add the application's jar to the image
COPY target/gateway-0.0.1-SNAPSHOT.jar gateway-0.0.1-SNAPSHOT.jar

# execute the application
ENTRYPOINT ["java", "-jar", "gateway-0.0.1-SNAPSHOT.jar"]