FROM openjdk:17-alpine
VOLUME /tmp
COPY target/gateway-service-0.0.1-SNAPSHOT.jar /gateway.jar
CMD ["java","-jar","/gateway.jar","--spring.profiles.active=prod"]
EXPOSE 8082