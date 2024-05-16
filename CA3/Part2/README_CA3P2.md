# devops-23-24-JPE-1141142

# Student - Tomás Ferreira nº1141142

# CA2 PART 2

1. Created a temp folder in my desktop.

2. Placed the Vagrantfile clone from https://bitbucket.org/pssmatos/vagrant-multi-spring-tut-demo.git in the folder.

3. Opened the file and did the following changes:
3.1. Change jdk to version 17.
3.2. Added the line ./gradlew bootRun
3.3. 

4. With the virtualbox opened, i navigated to where i placed the vagrant file and ran the following command:
 - vagrant up 

5. Checked the link http://192.168.56.10:8080/ to see if the and the table was created and filled.

6. I used the following commands in bash to commit the readme file:
- Created the folders ca3/part2
- Added this readme file and the vagrant file.
- git add .
- git commit -m  "Added CA3 Part 2 Readme file, and vagrant file."
- git push origin main
- git tag ca3-part2
- git push origin ca3-part2