# Final Project
Final project from my DFE Software Development Bootcamp.

## Why are we doing this?
The final part of my QA Academy DFE Software Development Bootcamp was a practical project. This piece would combine and demonstrate the methodologies and technologies learnt throughout the course.

The objective of the project was to create a Spring Boot API (application programming interface), a software interface that could provide services to another piece of software (probably a front-end).

The specifics of the objectives were
> “an application back-end developed using the language from your Programming Fundamentals module (e.g. Java)
> a managed database hosted locally or within the Cloud Provider examined during your Cloud Fundamentals module (e.g. H2 or MySQL (local / GCP) 
> a means of making API calls (Postman) and a means of checking persistence (Workbench/H2 console)”

# Project requirements and technologies used
The project requirements were:
* Code fully integrated into a Version Control System using the feature-branch model: main/dev/multiple features.
* A project management board with full expansion on user stories, acceptance criteria and tasks needed to complete the project.
* A risk assessment which outlines the issues and risks faced during the project timeframe.
* A relational database, locally or within the Cloud, which is used to persist data for the project. 
* A functional application ‘back-end’, written in a suitable framework of the language covered in training (Java/Spring Boot), which meets the requirements set on your Scrum Kanban board.
* A build (.jar) of your application, including any dependencies it might need, produced using an integrated build tool (Maven).
* A series of API calls designed with postman, used for CRUD functionality. (Create, Read, Update, Delete)
* Fully designed test suite for the application you are creating, including both unit and integration tests.

For my project I stuck with what I know and built on earlier work I had done during my bootcamp, choosing to make a simple library api. Due to the simplicity of the project, perhaps “book database” would be more apt.

My project used:

|Technology |Function|Version|Website/download link|Eclipse Marketplace link/Maven dependency link|
|:---       |:---      |:---   |:---   |:---           |
|Java |Programming language|Java 11 |[download](https://www.java.com/en/download/manual.jsp)| |
|Spring Boot|Framework and inversion of control container for Java |2.6.3 |[website](https://spring.io/projects/spring-boot) |[link](https://marketplace.eclipse.org/content/spring-tools-4-aka-spring-tool-suite-4) |
|H2 database |Java database |mangaed by Spring Boot |[website](https://h2database.com/html/main.html) | |
|Maven |Build automation tool |3.8.4 |[download](https://maven.apache.org/download.cgi) | |
|Postman |API development support app |9.12.0 |[website](https://www.postman.com/) | |
|Git |Version control |2.24.3 |[website](https://git-scm.com/) | |
|JUnit |Testing Framework |managed by Spring Boot??[website](https://junit.org/junit5/) |[maven repository link](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api)|
|Jacoco |Code coverage library |??|[website](https://www.jacoco.org/jacoco/) |[eclipse market place link for EclEmma code coverage tool](https://marketplace.eclipse.org/content/eclemma-java-code-coverage) | |
|Mockito |Mocking framework for unit tests |??? |[website](https://site.mockito.org/) | |



https://www.postman.com/downloads/

## How I expected the challenge to go.

I think I expected the project to go fairly well, even though I was less confident in, and had less experience of the Spring Boot framework than I might have liked. I had been using git and pushing my code up to GitHub over the last three weeks so I felt fairly confident in using git and GitHub. Whilst I still felt a bit unsure about my Java and testing skills, I did feel like I had a fairly robust theoretical knowledge and good notes and resources to rely on.

## What went well? / What didn't go as planned?

### Strengths:
I chose to build up the app from a very basic functioning version containing only controller and entity classes, without repository or service classes. This meant the project took longer than it might have done because it added more steps, the initial code contained some elements that were not used in the final product and conversely, the final product with the integrated service and repository classes contained some new code not in this first version. However, despite the time and effort this process took, I believe it was well spent as it meant I had a functioning app pretty much all the way along, apart from some odd bugs. 

### Weaknesses and troubleshooting:
As could have been predicted, I think some of the weakest areas of my project were the ones where my learning was quite a while ago, or I had spent less time on the topics. Apart from git, which I had been practicing, my knowledge of Jira software and the epic, user story and task model was rusty. Similarly, using the Spring Boot system was slower, as my theoretical understanding of the frameworks was less cemented.

Some problems cannot be predicted as such. On the afternoon of day three of doing my project my laptop died. The hard drive failed and then failed to boot or even recognise that it existed.

Luckily, I had been regularly pushing all my code to GitHub, so only lost the code for one test method. This mitigation ****** was exactly what I had written on my risk assessment two days prior. 

Whilst I had not lost much work, I had to 1) find a new computer to use, and 2) set up a workable environment on said computer. I here would like to give great thanks to my brother for lending me his computer. Luckily it has the same OS as mine so that made everything easier.

The set up of my work environment probably took at least four hours. 
	⁃	installing my IDE Eclipse
	⁃	setting up an SSH key for my computer for GitHub access
	⁃	cloning my project down from GitHub
	⁃	installing MicrosoftTeams (for taking part in scrum meetings with course mates and tutors
	⁃	installing Spring Boot
	⁃	installing Maven
	⁃	adding Maven to the machine path
	⁃	setting the path for $JAVA_HOME because that had not been set
	⁃	configuring Eclipse so that it found the JDK so I could get the basic JRE libraries
	⁃	installing Jacoco coverage viewer

Overall I feel I dealt with this setback well and was very resourceful. Reinstalling and setting up my work environment also refreshed my setup knowledge for the technologies I was using.

## Possible improvements for future revisions of the project.

A few smaller functional changes which I would have liked to implement, had I more time are:
	⁃	Utilising optionals so that incorrect requests would not cause a program shutdown.
	⁃	Implementing custom exceptions.
	⁃	adding a RegeX or similar function to check the validity of an Isbn entered. It is possible to logically check whether a ISBN is valid with some simple maths, so it would be nice to have this.
	⁃	adding custom queries for returning books of the same genre code (I used the Thema system[link]), such that one could do a GET request to a url such as “/books/genre/modern-fiction” and receive a list of all books with the genre code “FB”. (As I am using a recognised system like Thema, that data may be available online in a way that could potentially be collected and used automatically).

As I implied above, my Library project is very basic and is currently functioning more as book metadata storage. Therefore, further improvements would be adding user and loan entities and contenting them so that users could have loans of specific books.

Another avenue for expansion is that ISBNs () actually contain quite a bit of data. Contained in the number sequence are values that map to a publishing house [? Anything else]. If my project could access such data then it would be possible to automate fields such as “publisher”. 

## Screenshots showing your postman requests and the output from the API.

Whilst I did have screenshots of Postman showing (almost) complete functionality from day two of my project work, these have been lost as they were on my computer desktop.



## Screenshots of your database to prove that data is being persisted.

## Screenshot of your test results, including coverage report.


## Jira Board 
https://countzero.atlassian.net/jira/software/projects/DFPM/
