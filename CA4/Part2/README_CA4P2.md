# devops-23-24-JPE-1141142

# Student - Tomás Ferreira nº1141142

# CA4 PART 2


1. Opened my IDE inside the CA2 Part2 folder, inside react-and-spring-data-rest-basic.

2. Created a dockerfile for DB with the following text taken from https://bitbucket.org/atb/docker-compose-spring-tut-demo/src/master/db/Dockerfile example:

FROM ubuntu

RUN apt-get update && \
  apt-get install -y openjdk-8-jdk-headless && \
  apt-get install unzip -y && \
  apt-get install wget -y

RUN mkdir -p /usr/src/app

WORKDIR /usr/src/app/

RUN wget https://repo1.maven.org/maven2/com/h2database/h2/1.4.200/h2-1.4.200.jar

EXPOSE 8082
EXPOSE 9092

CMD java -cp ./h2-1.4.200.jar org.h2.tools.Server -web -webAllowOthers -tcp -tcpAllowOthers -ifNotExists

2.1 The location of this Dockerfile is in a folder named web

3. Created a dockerfile to run the web app with the following text:

# syntax=docker/dockerfile:1
FROM gradle:jdk17
WORKDIR /app
COPY . /app
EXPOSE 8080
RUN chmod +x gradle
RUN gradle clean build
CMD gradle bootRun

3.1. This dockerfile location is at the root of the project, so it can copy its contents in order to build the application.

4. For the Docker-compose file, i have used the following text:

version: '3'
services:
  web:
    build:
      context: .
      dockerfile: Dockerfile-web
    ports:
      - "8080:8080"
    networks:
      default:
        ipv4_address: 192.168.33.10
    depends_on:
      - "db"
  db:
    build: db
    ports:
      - "8082:8082"
      - "9092:9092"
    volumes:
      - ./data:/usr/src/data-backup
    networks:
      default:
        ipv4_address: 192.168.33.11
networks:
  default:
    ipam:
      driver: default
      config:
        - subnet: 192.168.33.0/24


5. Inside the docker desktop app, we can see the application running on http://localhost:8080/, and the database web console running on http://localhost:8082 .


6. I used the following commands in bash to commit the readme file:
- Created the folders ca4/part2
- Added this readme file, the dockerfiles and the docker-compose file.
- git add .
- git commit -m  "Added CA4 Part 2 Readme file, and docker files."
- git push origin main
- git tag ca4-part2
- git push origin ca4-part2