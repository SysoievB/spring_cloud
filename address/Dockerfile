#Start with a base image containing Java runtime
FROM openjdk:21-jdk-slim

# Add the application's jar to the image
COPY target/address-0.0.1-SNAPSHOT.jar address-0.0.1-SNAPSHOT.jar

# execute the application
ENTRYPOINT ["java", "-jar", "address-0.0.1-SNAPSHOT.jar"]