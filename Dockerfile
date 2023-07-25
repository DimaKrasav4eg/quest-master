FROM eclipse-temurin:17-jre-alpine
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", \
                    "-Dbot.token=${BOT_TOKEN}", \
                    "-Dspring.datasource.username=${DB_USERNAME}", \
                    "-Dspring.datasource.password=${DB_PASSWORD}", "-jar", "app.jar"]