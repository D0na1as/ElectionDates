FROM openjdk:8
COPY dates.jar /
ENTRYPOINT ["java", "-jar", "dates.jar"]

#Just for HEROKU
CMD gunicorn --bind 0.0.0.0:$PORT wsgi