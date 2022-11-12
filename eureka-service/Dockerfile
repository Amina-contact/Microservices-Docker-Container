FROM openjdk:17-alpine
VOLUME /tmp
COPY target/eureka-service-0.0.1-SNAPSHOT.jar /eureka-service.jar
CMD ["java","-jar","/eureka-service.jar","--spring.profiles.active=prod"]
EXPOSE 8761