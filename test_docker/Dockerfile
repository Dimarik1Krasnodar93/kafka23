FROM openjdk:21
RUN mkdir app
#ARG SERVICE_DIR
#ENV SERVICE_DIR=${SERVICE_DIR}
#COPY $SERVICE_DIR/*.jar /app/main3.jar
COPY producer/build/libs/*.jar /app/main5.jar
ENTRYPOINT ["java", "-jar", "/app/main5.jar"]
