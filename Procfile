#web: java -Dserver.port=$PORT -jar target/tdd-service-0.0.1-SNAPSHOT.war
web: java $JAVA_OPTS -jar target/*.war -Dserver.port=$PORT $JAR_OPTS
#web: java -Dspring.profiles.active=default -Dserver.port=$PORT -jar target/*.war