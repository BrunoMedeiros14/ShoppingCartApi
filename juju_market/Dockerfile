FROM gradle:8.2.1-jdk17-alpine as build
WORKDIR /app/juju_market
COPY ./src /app/juju_market/src
COPY ./build.gradle.kts /app/juju_market
COPY ./settings.gradle.kts /app/juju_market
RUN gradle build

FROM openjdk:17-jdk-alpine
expose 8080
COPY --from=build /app/juju_market/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
