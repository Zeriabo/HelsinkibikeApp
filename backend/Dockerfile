FROM eclipse-temurin:17.0.5_8-jre-alpine@sha256:02c04793fa49ad5cd193c961403223755f9209a67894622e05438598b32f210e
ARG JAR_FILE=target/bikeapp-0.0.1-SNAPSHOT.jar
COPY backend/target/bikeapp-0.0.1-SNAPSHOT.jar /
ENTRYPOINT ["java", "-jar", "bikeapp-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080