	# devops-23-24-JPE-1141142

# Student - Tomás Ferreira nº1141142

# CA3 PART 1

1. Followed the steps described in the lecture to set up the VM:
1.1. Downloaded the most recent version of VirtualBox (version 7.0.18)
1.2. Downloaded the most recent version of Ubuntu Server (version 24.04)
1.3. Started the VM and installed Ubuntu.
1.4. After installing ubuntu, i ran the following commands in the terminal:
 - sudo apt update
 - sudo apt upgrade -y
 1.5. To setup the network, i ran the following commands:
 - sudo apt install net-tools
 - sudo nano /etc/netplan/01-netcfg.yaml
 - Added the following text to the file:
 
 network:
	version: 2
	renderer: networkd
	ethernets:
		enp0s3:
			dhcp4: yes
		enp0s8:
			addresses:
				- 192.168.241.5/24

- Applied the new changes with the command:
- sudo netplan apply

2. To setup an ssh server, i used the following commands:
 - sudo apt install openssh-server
 - Enabled password authentication by:
 - sudo nano /etc/ssh/sshd_config
 - Uncommented the line PasswordAuthentication yes
 - sudo service ssh restart
 
3. Installed an ftp server:
 - sudo apt install vsftpd
 - Enabled write access for vsftpd:
 - sudo nano /etc/vsftpd.conf
 - Uncommented the line write_enable=yes
 - sudo service vsftpd restart
 
4. Installed git:
  - sudo apt install git
  
5. Installed java develpment kit:
  - sudo apt install openjdk-21-jdk-headless
  
6. Installed the dependencies of the projects we want to run:

	For maven:
 - sudo apt install maven
 
	For gradle i used the following tutorial:
	https://linuxize.com/post/how-to-install-gradle-on-ubuntu-20-04/

  
6. With the VM ready, i cloned my repository to a new folder.
 
7. Set my repository to public, so i could clone it. (Without any extra steps)

8. To test CA1 Spring boot tutorial basic i followed these steps:
Used the command chmod +x mvnw to enable permission.
8.1. Navigated to the CA1/basic folder inside the repository
8.2. Ran ./mvnw spring-boot:run
8.3. Opened a browser in my host machine and checked the link: http://192.168.241.5:8080/
8.4. The table appeared with the expected information.
 
 
9. To test CA2 Part 1 , i followed these steps:
Used the command chmod +x gradlew to enable permission.
9.1. Navigated to the CA2 Part1/gradle_basic_demo
9.2. Used the command gradle wrapper to set the version of the gradle used.
9.3. Ran ./gradlew runServer to start the server.
9.4. On the host machine, i changed the runClient ip entry argument to 192.168.241.5 to connect to the VM server.
9.5. After opening the client on the host, the VM server recognized the new user.

10. to test CA2 Part2, i followed these steps:
Used the command chmod +x gradlew to enable permission.
10.1 Ran ./gradlew build
10.2 Ran ./gradlew bootRun
10.3 Checked the link http://192.168.241.5:8080/ to see if it was sucessfull.

11. I used the following commands in bash to commit the readme file:
- Created the folders ca3/part1
- Added this readme file.
- git add .
- git commit -m  "Added CA3 Part 1 Readme file"
- git push origin main
- git tag ca3-part1
- git push origin ca3-part1



