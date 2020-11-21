FROM openjdk:8
COPY dates.jar /

# Fire up our Spring Boot app by default, for heroku
CMD [ "sh", "-c", "java -Dserver.port=$PORT -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8 -XX:+UseContainerSupport -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

#ENTRYPOINT ["java", "-jar", "dates.jar"]
