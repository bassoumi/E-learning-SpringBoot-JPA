From openjdk:17-jdk

WORKDIR /app
COPY jpa/target/jpa-0.0.1-SNAPSHOT.jar /app/springdemo.jar

EXPOSE 8080

CMD ["java","-jar","springdemo.jar"]
