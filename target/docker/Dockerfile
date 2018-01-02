# for jar files
#FROM java:8
#ADD spring-boot-first-web-application.jar app.jar
#RUN bash -c 'touch /app.jar'
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-jar","/app.jar" ]

# for war files
FROM tomcat:8.5-alpine
COPY spring-boot-first-web-application.war /usr/local/tomcat/webapps/app.war
ADD wrapper.sh wrapper.sh
RUN bash -c 'chmod +x wrapper.sh' 
RUN bash -c 'touch /usr/local/tomcat/webapps/app.war'
ENTRYPOINT ["/bin/bash","wrapper.sh"]

