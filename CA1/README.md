# devops-23-24-JPE-1141142

# Student - Tomás Ferreira nº1141142

# PART 1 - No branches

1. Created a folder in my Desktop.

2. Opened bash inside the folder.

3. With Bash inside the folder, i used the following commands:
- git init
- echo "# devops-23-24-JPE-1141142" >> README.md
- git clone https://github.com/spring-guides/tut-react-and-spring-data-rest

4. Deleted the .git file inside the tutorial folder.

5. Created subfolder CA1.

6. Copied the basic folder from the tutorial to CA1.

7. Copied the root POM file from the tutorial.

8. Then i used the following commands in bash:
- git branch -M main
- git add README.md
- git add tut-react-and-spring-data-rest/
- git add CA1/
- git commit -m "1st Commit - Tutorial folder + CA1 with basic and POM"
- git remote add origin https://github.com/1141142TF/devops-23-24-JPE-1141142.git
- git push -u origin main

9. To tag the current version, i used the following commands:
- git tag v1.1.0
- git push origin v1.1.0

10. Created issue #1 Add a new field to record the years of the employee in the company.
    Opened my local repository in a IDE to perform the modifications necessary:
    10.1. Add new attribute to Employee class. Update methods to include new attribute.
    10.2. Added Getters and Setters for new attribute.
    10.3. Added isConstructorArgumentsValid() to Employee constructor.
    10.3. Updated DatabaseLoader to take into account new attribute in Employee.
    10.4. Updated client.js to take into account new attribute in Employee.
    10.5. Added new folder for tests.
    10.5. Added EmployeeTest class and respective tests.

11. Ran./mvnw spring-boot:run to test if attribute was well implemented.

12. Then i used the following commands in bash to commit my changes:
- git add .
- git commit -m  "Closes #1 Add new JobYears attribut to Employee"
- git push origin main
- git tag v1.2.0
- git push origin v1.2.0



# PART 2 - Using branches

1. Created issue with new task "Create a branch named ”email-field” to add a new email field to the application."

2. Used the following commands to create new branch:
- git branch email-field
- git checkout email-field

3. Added the following changes to the code:
   3.1. Added method to validate email in Employee.
   3.2. Added new email field to Employee.
   3.3. Updated DatabaseLoader & client.js to take into account email field.
   3.4. Added basic tests.

4.Ran ./mvnw spring-boot:run for a final check.

5. Used the following git commands to merge the email-field to the main branch:
- git add .
- git commit -m "Closes #3 Added extra test for email validation"
- git push origin fix-invalid-email
- git checkout main
- git merge fix-invalid-email
- git push origin main
- git tag v1.3.1
- git push origin v1.3.1
- git tag ca1-part2
- git push origin ca1-part2



# PART 3 - Alternative Solution

An alternative to git can be Fossil.

Simple, high-reliability, distributed software configuration management.
Fossil is a distributed version control system, bug tracking system and wiki software server for use in software development.

Fossil is very similar to Git in terms of commands:
- git init -> fossil init
- git clone -> fossil clone
- git add -> fossil add
- git branch -> fossil branch
- git push -> fossil push



