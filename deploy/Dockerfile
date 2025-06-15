FROM registry.cn-hangzhou.aliyuncs.com/mqxu/openjdk:17-jdk-slim
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
ARG JAR_FILE
COPY ${JAR_FILE} /app/app.jar
ENTRYPOINT ["java", "-server", "-Xms512M", "-Xmx512M", "-Dfile.encoding=UTF-8", "-jar", "/app/app.jar"]