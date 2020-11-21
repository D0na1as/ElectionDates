FROM openjdk:8
COPY  dates.jar /Docker-compose/dates/
ENTRYPOINT ["java", "-jar", "dates.jar"]