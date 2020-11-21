FROM openjdk:8
COPY dates.jar /

# Fire up Spring Boot app by default
CMD [ "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar dates.jar" ]

#ENTRYPOINT ["java", "-jar", "dates.jar"]
