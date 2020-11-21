FROM openjdk:8
COPY dates.jar /

#Just for HEROKU
CMD gunicorn --bind 0.0.0.0:$PORT wsgi

ENTRYPOINT java -jar dates.jar
