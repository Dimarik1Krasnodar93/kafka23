FROM gradle:latest AS BUILD
RUN mkdir -p /app
ARG SERVICE_DIR

COPY $SERVICE_DIR/ /home/app/
RUN cd /home/app/ && gradle build
FROM openjdk:21
COPY --from=build /home/app/build/libs .
ARG JAR_NAME
ENTRYPOINT ["java", "-jar", "${JAR_NAME}"]
#ENTRYPOINT ["java", "-jar", "producer-0.0.1-SNAPSHOT.jar"]
