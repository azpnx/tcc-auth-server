FROM adoptopenjdk/openjdk11:slim
ARG JAR_FILE=psi-auth/target/*.jar
COPY ${JAR_FILE} app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]