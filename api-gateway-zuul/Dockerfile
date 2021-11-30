FROM 101.201.152.218/micro-service/openjdk:8u312-oraclelinux7
MAINTAINER 王攀 wangpan961023@foxmail.com

COPY target/api-gateway-zuul-1.0-SNAPSHOT.jar /api-gateway-zuul.jar

ENTRYPOINT ["java","-jar","/api-gateway-zuul.jar"]