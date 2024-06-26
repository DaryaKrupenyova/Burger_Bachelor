FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY . /app

RUN chmod +x gradlew && ./gradlew build && ls

EXPOSE 8081

ENTRYPOINT [ "java","-jar","/app/build/libs/BurgerBachelor-0.0.1-SNAPSHOT.jar" ]