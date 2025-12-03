FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app

# 필요한 최소 패키지 설치 후 캐시 정리
RUN apt-get update \
 && apt-get install -y --no-install-recommends wget unzip \
 && rm -rf /var/lib/apt/lists/*

# 프로젝트가 backend/ 폴더에 있는 경우(루트에 Dockerfile 유지)
COPY ./ /app/

# Gradle wrapper 실행 권한 및 빌드
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar -x test --no-daemon

FROM eclipse-temurin:21-jdk

RUN apt-get update \
 && rm -rf /var/lib/apt/lists/*
COPY --from=builder /app/build/libs/*.jar /app/app.jar


ENTRYPOINT ["java","-jar","/app/app.jar"]
