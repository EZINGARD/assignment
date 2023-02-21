FROM openjdk:17-jdk-alpine
MAINTAINER mansur_muzaffarov@epam.com
COPY target/assignment-1.0.jar assignment-1.0.jar
ENTRYPOINT ["java","-jar","/assignment-1.0.jar"]