# devops-23-24-JPE-1141142

# Student - Tomás Ferreira nº1141142

# CA2 PART 1

1. Inside my local repository folder, i created a new folder with the name CA2 Part1.

2. Opened bash inside the folder.

3. With Bash inside the folder, i used the following commands:
- git clone https://bitbucket.org/pssmatos/gradle_basic_demo

4. Deleted the .git file inside the tutorial folder.

5. Builded the gradle demo using the command ./gradlew build in the bash window.

6. Ran the server using the command java -cp build/libs/basic_demo-0.1.0.jar basic_demo.ChatServerApp 59001.

7. Ran the client in another window using the command ./gradlew runClient

8. Experimented the app with 2 client windows and it worked properly.

9. Created issue #4 Add a new task to build.gradle to execute the server.

10. The code used to create the task is the following:

task runServer(type:JavaExec, dependsOn: classes){
    group = "DevOps"
    description = "Launches a server that is located on localhost:59001 "

    classpath = sourceSets.main.runtimeClasspath

    mainClass = 'basic_demo.ChatServerApp'

    args '59001'
}

11. Ran ./gradlew runServer and tested its functionality.

12. Then i used the following commands in bash to commit my changes:
- git add .
- git commit -m  "Closes #4 Add new task to execute server"
- git push origin main

13. Created issue #5 Add a test class and implement junit dependencies.

14. Added junit dependencies through the following lines in hte file build.gradle:

test {
    useJUnitPlatform()
}

dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.1'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'
}

15. Implemented class as shown in slides. And tested if test ran properly.

16. Then i used the following commands in bash to commit my changes:
- git add .
- git commit -m  "Closes #5 Add a test class and implement junit dependencies."
- git push origin main

17. Created issue #6 Add a new task of type Copy to be used to make a backup of the sources of the application.

18. Added following task to build.gradle:

task copySourceFiles(type:Copy, dependsOn: classes){
   from 'src/'
    into('Backup')
}

19. Then i used the following commands in bash to commit my changes:
- git add .
- git commit -m  "Closes #6 Add a new task of type Copy to be used to make a backup of the sources of the application."
- git push origin main

20. Created issue #7 Add a new task of type Zip to be used to make an archive (i.e., zip file) of the
sources of the application.

21. Added following task to build.gradle:

task zipSourceFiles(type: Zip) {
    archiveFileName = "BackupZipped.zip"
    destinationDirectory = file("/Backup")

    from "src"
}

22. Then i used the following commands in bash to commit my changes:
- git add .
- git commit -m  "Closes #7 Add a new task of type Zip to be used to make an archive (i.e., zip file) of the
sources of the application."
- git push origin main

23. Marked my repository with the following commands:
- git tag ca2-part1
- git push origin ca2-part1

