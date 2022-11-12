FROM openjdk:17-alpine
VOLUME /tmp
COPY target/billing-service-0.0.1-SNAPSHOT.jar /billing-service.jar
CMD ["java","-jar","/billing-service.jar","--spring.profiles.active=prod"]
EXPOSE 8083