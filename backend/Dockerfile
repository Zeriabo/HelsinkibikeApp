FROM eclipse-temurin:17.0.5_8-jre-alpine@sha256:02c04793fa49ad5cd193c961403223755f9209a67894622e05438598b32f210e
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/bikeapp-0.0.1-SNAPSHOT.jar
COPY backend/src/main/resources /app/resources
COPY backend/target/bikeapp-0.0.1-SNAPSHOT.jar /
ENV file.path1=app/resources/2021-05.csv
ENV file.path2=app/resources/2021-06.csv
ENV file.path3=app/resources/2021-07.csv
ENV file.path4=app/resources/Helsingin_ja_Espoon_kaupunkipy_asemat_avoin.csv
ENTRYPOINT ["java", "-jar", "bikeapp-0.0.1-SNAPSHOT.jar"]
