# JDK を指定
FROM amazoncorretto:21-alpine

# アプリケーションを非ルートユーザーとして実行
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

ARG GIT_COMMIT
ARG APP_VERSION
LABEL git-commit=${GIT_COMMIT} \
        app-version=${APP_VERSION} \
        authors="semba-yui"

ENTRYPOINT ["java","-jar","/app.jar"]
