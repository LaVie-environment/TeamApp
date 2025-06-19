FROM tomcat:10.1.40-jre21-temurin

# Remove default Tomcat apps (optional)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your WAR file (matches POM's <finalName>eshop</finalName>)
COPY target/eshop.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]