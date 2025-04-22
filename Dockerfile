FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM amazoncorretto:17-alpine-jdk
WORKDIR /app
COPY --from=build /app/target/WorkSpaceBlogs-0.0.1-SNAPSHOT.jar api-v1.jar
ENTRYPOINT ["java", "-jar", "api-v1.jar"]
