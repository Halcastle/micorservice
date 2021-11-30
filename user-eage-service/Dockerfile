FROM 101.201.152.218/micro-service/openjdk:8u312-oraclelinux7
MAINTAINER 王攀 wangpan961023@foxmail.com

COPY target/user-eage-service-1.0-SNAPSHOT.jar /user-edge-service.jar

ENTRYPOINT ["java","-jar","/user-edge-service.jar"]