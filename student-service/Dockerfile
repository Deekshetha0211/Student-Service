FROM openjdk
LABEL maintainer = "abc@gmail.com"
EXPOSE 8083
WORKDIR /app
COPY target/Student.jar /app/Student.jar
ENTRYPOINT ["java", "-jar","Student.jar"]