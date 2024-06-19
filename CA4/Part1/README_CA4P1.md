# devops-23-24-JPE-1141142

# Student - Tomás Ferreira nº1141142

# CA4 PART 1



1. Opened bash inside the CA2 Part1 folder, inside gradle_basic_demo.

2. Through my IDE , ive created an empty docker file.

3. For the version that builds the chat server "inside" the Dockerfile, ive used the following dockerfile:

# syntax=docker/dockerfile:1
FROM gradle:jdk17
WORKDIR /app
COPY . /app
RUN chmod +x gradle
RUN gradle build
EXPOSE 59001
CMD gradle runServer

4. For the version that copies the pre built version in the host computer "into" the dockerfile, 
	ive used the following dockerfile:
	
# syntax=docker/dockerfile:1
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY ./build/libs/*.jar /app
EXPOSE 59001
CMD ["java", "-cp", "basic_demo-0.1.0.jar","basic_demo.ChatServerApp","59001"]


5. Confirmed both versions used by running the chat client and connecting to both versions.

6. Inside my local repository folder, i created a new folder with the name CA4 Part1.

7. Added the ReadMe file to the folder.

8. Then i used the following commands in bash to commit my changes:
- git add .
- git commit -m  "Add Readme file for CA4 Part 1"
- git push origin main

23. Marked my repository with the following commands:
- git tag ca4-part1
- git push origin ca4-part1