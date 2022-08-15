FROM openjdk:17
#COPY ./build/libs/tasks-0.0.1-SNAPSHOT.war
COPY ./out/production/LibraryApplication/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","HelloWorld"]

FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

COPY build/dependency/BOOT-INF/lib /app/lib
COPY build/dependency/META-INF /app/META-INF
COPY build/dependency/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","hello.Application"]