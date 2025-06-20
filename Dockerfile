FROM tomcat:10.1.40-jre21-temurin

# Remove default webapps to avoid conflicts
RUN rm -rf /usr/local/tomcat/webapps/*

# Deploy WAR
COPY target/eshop.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
