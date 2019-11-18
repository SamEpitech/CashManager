FROM openjdk:8 AS build
ENV APP_HOME=/usr/app/
WORKDIR /usr/app/
COPY build.gradle settings.gradle gradlew $APP_HOME
COPY gradle $APP_HOME/gradle
RUN ./gradlew build || return 0
COPY . .
RUN ./gradlew build -x test

FROM openjdk:8
ENV ARTIFACT_NAME=cashmanager-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY --from=build $APP_HOME/build/libs/$ARTIFACT_NAME .
EXPOSE 8080
CMD java -jar ${ARTIFACT_NAME}