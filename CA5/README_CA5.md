# devops-23-24-JPE-1141142

# Student - Tomás Ferreira nº1141142

# CA4 PART 1



1. Started by intalling jenkins through docker with the following steps:
1.1. On the computer terminal (PowerShell) used the command "docker pull jenkins/jenkins:lts-jdk17".
1.2. On the docker desktop application i ran the pulled image on the port 8280.
1.3. Accessed Jenkins Manager through http://localhost:8280.
1.4. Followed the steps provided to configure the admin user and the port to access the manager.

2. To create the pipeline, i followed the tutorial in the lecture pdf and altered the script to to the following:

pipeline {
    agent any
    tools {
        gradle 8.8 
    }
    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out...'
                git branch: 'main', url: 'https://github.com/1141142TF/devops-23-24-JPE-1141142.git'
            }
        }
        stage('Assemble') {
            steps {
                echo 'Assembling...'
                dir('CA2 Part1/gradle_basic_demo'){
                sh 'gradle init'
                sh 'gradle wrapper build'
                sh 'chmod +x ./gradlew'
                sh './gradlew assemble'
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                dir('CA2 Part1/gradle_basic_demo'){
                sh './gradlew test'
                junit 'build/test-results/test/*.xml'
                }
            }
        }
        stage('Archiving') {
            steps {
                echo 'Archiving...'
                dir('CA2 Part1/gradle_basic_demo'){
                archiveArtifacts 'build/libs/*.jar'
                }
            }
        }
    }
}

2.1. Jenkins shows the build proceeded without any issues with a green check mark, and we can check the report of the test pusblished in the job's front page.

2.2 Then to add and commit the JenkinsFile with the script above, i followed these steps:

- Opened bash in CA2 Part1/gradle_basic_demo in my local repository.
- Added a text file with the name JenkinsFile with the script inside it.
- git add .
- git commit -m  "Updated CA5 Part1 Jenkinsfile to rebuild wrapper." 
- git push origin main

2.3 To test if the jenkins file is working, i did the following steps:

- Created a pipeline job same as before.
- Instead of a basic pipeline script, we choose the option "Pipeline script from SCM"
- Introduced the correct repository to recover the project.
- Chose the correct branch.
- Updated the path for the jenkinsfile  adn the pressed save.
- On the job main page, i pressed build now.
- After the build was deemed sucessfull i check for the test report which was present.

3. For the 2nd exercise, we need some puglins in order to work with docker and to create javadocs:
    - HTML Publisher plugin
    - Docker API Plugin
    - Docker Commons Plugin
    - Docker plugin
    - Docker pipeline
    
3.1. In order to publish our docker imgae file, we need to set up our docker hub credentials on jenkins:
 - Went to "manage jenkins", on the security tab pressed "credentials".
 - Clicked "System" and then "Global credentials".
 - Now pressed add credentials.
 - Filled the username and the password, and set the id to "docker-hub-credentials".

4. The part2 script is the following:


pipeline {
    agent any
	tools {
        gradle 8.8 
    }
    environment {
        DOCKER_CREDENTIALS_ID = 'docker-hub-credentials'
        DOCKER_IMAGE = '1141142/devops1141142'
        DOCKER_TAG = "${env.BUILD_ID}"
    }

    stages {
        stage('Checkout') {
             steps {
                 echo 'Checking out...'
                 git branch: 'main', url: 'https://github.com/1141142TF/devops-23-24-JPE-1141142.git'
               }
        }

        stage('Assemble') {
            steps {
						echo 'Assembling...'
						dir('CA2 Part2/react-and-spring-data-rest-basic') {
						sh 'gradle init'
						sh 'gradle wrapper build'
						sh 'chmod +x gradlew'
                        sh './gradlew assemble'
                    }
            }
        }

        stage('Test') {
            steps {
					echo 'Testing...'
					dir('CA2 Part2/react-and-spring-data-rest-basic') { 
                    sh './gradlew test'
                }
            }
        }

        stage('Javadoc') {
            steps {
				echo 'Generating Javadoc...'
                dir('CA2 Part2/react-and-spring-data-rest-basic') {
                    sh './gradlew javadoc'
                    publishHTML(target: [
                        allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: true,
                        reportDir: 'build/docs/javadoc',
                        reportFiles: 'index.html',
                        reportName: 'Javadoc'
                    ])
                }
            }
        }

        stage('Archive') {
            steps {
				echo 'Archiving...'
                dir('CA2 Part2/react-and-spring-data-rest-basic') {
					archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
                }
            }
        }

        stage('Create Dockerfile') {
            steps {
                dir('CA2 Part2/react-and-spring-data-rest-basic') {
                    script {
                        def dockerfileContent = """
                        FROM gradle:jdk17
                        WORKDIR /app
						COPY . /app
						EXPOSE 8080
						RUN chmod +x gradle
						RUN gradle clean build
						CMD gradle bootRun
                        """
                        writeFile file: 'Dockerfile', text: dockerfileContent
                    }
                }
            }
        }

        stage('Build and publish Image') {
            steps {
                script {
                    echo 'Building and publishing Docker image...'
                    docker.withRegistry('https://index.docker.io/v1/', "${DOCKER_CREDENTIALS_ID}") {
                        dir('CA2 Part2/react-and-spring-data-rest-basic') {
                            def localImage = docker.build("${DOCKER_IMAGE}:${DOCKER_TAG}")
                            localImage.push()
                            localImage.push('latest')
                        }
                    }
                }
            }
        }

        stage('Run Container') {
            steps {
                script {
                    echo 'Running Docker container...'
                    sh "docker run -d -p 8080:8080 ${DOCKER_IMAGE}:latest"
                }
            }
        }
    }
}


5. Added jenkins file to repository.