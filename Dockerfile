FROM openjdk:17
EXPOSE 8095

ADD target/MSStock-0.0.1-SNAPSHOT.jar MSStock.jar
ENTRYPOINT ["java","-jar","MSStock.jar"]