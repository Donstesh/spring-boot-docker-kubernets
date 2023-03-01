FROM openjdk

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]
#
#EXPOSE 8080
#ADD target/Error-Handling-0.0.1-SNAPSHOT.jar error-eandling-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java", "-jar", "target/Error-Handling-0.0.1-SNAPSHOT.jar"]