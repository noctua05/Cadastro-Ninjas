

FROM eclipse-temurin:21
LABEL maintainer="pedrocatarino246@gmail.com"
WORKDIR /app
COPY target/*.jar /app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]
ENV DATABASE_URL="jdbc:h2:file:./data/NinjasBD;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE"
ENV DATABASE_USERNAME="Ninja_bd"
ENV DATABASE_PASSWORD="admin"

EXPOSE 8080
