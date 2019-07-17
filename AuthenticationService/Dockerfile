FROM java:8-jre
WORKDIR usr/src
ENV MYSQL_DATABASE=duckstersdb
ENV MYSQL_USER=app_root
ENV MYSQL_PASSWORD=root
ENV MYSQL_CI_URL=jdbc:mysql://localhost:3306/duckstersdb
ADD ./target/AuthenticationService-0.0.1-SNAPSHOT.jar /usr/src/AuthenticationService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","AuthenticationService-0.0.1-SNAPSHOT.jar"]
