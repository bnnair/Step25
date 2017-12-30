# for jar files
#FROM java:8
#ADD spring-boot-first-web-application.jar app.jar
#RUN bash -c 'touch /app.jar'
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-jar","/app.jar" ]

# for war files
FROM tomcat:8.5-alpine
COPY spring-boot-first-web-application.war /usr/local/tomcat/webapps/app.war
RUN sh -c 'touch /usr/local/tomcat/webapps/app.war'
ENTRYPOINT ["sh","-c","java -Dspring.profiles.active=container -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/app.war" ]

