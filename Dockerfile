FROM tomcat:10.1.40-jre21-temurin
COPY target/eshop.war /usr/local/tomcat/webapps/eshop.war
EXPOSE 8080
CMD ["catalina.sh", "run"]