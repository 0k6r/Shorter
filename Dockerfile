FROM java:8-jre
MAINTAINER Konstantin Petrov <oku6er@gmail.com>

# Copy .jar file in app folder
ADD ./target/shorter.jar /app/

CMD ["java", "-jar", "/app/shorter.jar"]
EXPOSE 8080