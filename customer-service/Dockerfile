FROM openjdk:17-alpine
VOLUME /tmp
COPY target/customer-service-0.0.1-SNAPSHOT.jar /app.jar
CMD ["java","-jar","/app.jar","--spring.profiles.active=prod"]
EXPOSE 8082