FROM openjdk:8u312-oraclelinux7
MAINTAINER 王攀 wangpan961023@foxmail.com

COPY target/user-thrift-service-1.0-SNAPSHOT.jar /user-service.jar

ENTRYPOINT ["java","-jar","/user-service.jar"]