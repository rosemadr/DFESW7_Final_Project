# Library Project
Final project from my DFE Software Development Bootcamp.

## Contents
1. [Why are we doing this?](https://github.com/rosemadr/DFESW7_Final_Project/edit/documentation/README.md#why-are-we-doing-this)
2. [How I expected the challenge to go](https://github.com/rosemadr/DFESW7_Final_Project/blob/main/README.md#how-i-expected-the-challenge-to-go)
3. [What went well? / What didn't go as planned?](https://github.com/rosemadr/DFESW7_Final_Project/blob/main/README.md#what-went-well--what-didnt-go-as-planned)
4. [Possible improvements for future revisions of the project](https://github.com/rosemadr/DFESW7_Final_Project/edit/documentation/README.md#possible-improvements-for-future-revisions-of-the-project)
5. [Screenshots showing postman requests and the output from the API](https://github.com/rosemadr/DFESW7_Final_Project/blob/main/README.md#screenshots-showing-your-postman-requests-and-the-output-from-the-api)
6. [Screenshots of database to prove that data is being persisted](https://github.com/rosemadr/DFESW7_Final_Project/blob/main/README.md#screenshots-of-your-database-to-prove-that-data-is-being-persisted)
7. [Screenshot of test results, including coverage report](https://github.com/rosemadr/DFESW7_Final_Project/blob/main/README.md#screenshot-of-your-test-results-including-coverage-report)
8. [Jira board link](https://github.com/rosemadr/DFESW7_Final_Project/edit/documentation/README.md#jira-board-link)

## Why are we doing this?
The final part of my QA Academy DFE Software Development Bootcamp was a practical project. This piece would combine and demonstrate the methodologies and technologies learnt throughout the course.

The objective of the project was to create a Spring Boot API (application programming interface), a software interface that could provide services to another piece of software (probably a front-end).

The specifics of the objectives were
> “an application back-end developed using the language from your Programming Fundamentals module (e.g. Java)
> a managed database hosted locally or within the Cloud Provider examined during your Cloud Fundamentals module (e.g. H2 or MySQL (local / GCP) 
> a means of making API calls (Postman) and a means of checking persistence (Workbench/H2 console)”

### Project requirements and technologies used
<details>
<summary>The project requirements were:</summary>

* Code fully integrated into a Version Control System using the feature-branch model: main/dev/multiple features.
* A project management board with full expansion on user stories, acceptance criteria and tasks needed to complete the project.
* A risk assessment which outlines the issues and risks faced during the project timeframe.
* A relational database, locally or within the Cloud, which is used to persist data for the project. 
* A functional application ‘back-end’, written in a suitable framework of the language covered in training (Java/Spring Boot), which meets the requirements set on your Scrum Kanban board.
* A build (.jar) of your application, including any dependencies it might need, produced using an integrated build tool (Maven).
* A series of API calls designed with postman, used for CRUD functionality. (Create, Read, Update, Delete)
* Fully designed test suite for the application you are creating, including both unit and integration tests.

</details>

For my project I stuck with what I know and built on earlier work I had done during my bootcamp, choosing to make a simple library api. Due to the simplicity of the project, perhaps “book database” would be more apt. I was also inspired by the amazing ebook manager [calibre](https://github.com/kovidgoyal/calibre).

#### Technologies used:
<details>
<summary>Table of technologies used:</summary>

|Technology |Function|Version|Website/download link|Eclipse Marketplace link/Maven dependency link|
|:---       |:---      |:---   |:---   |:---           |
|Java |Programming language|Java 11 |[download](https://www.java.com/en/download/manual.jsp)| |
|Spring Boot|Framework and inversion of control container for Java |2.6.3 |[website](https://spring.io/projects/spring-boot) |[link](https://marketplace.eclipse.org/content/spring-tools-4-aka-spring-tool-suite-4) |
|H2 database |Java database |mangaed by Spring Boot |[website](https://h2database.com/html/main.html) | |
|Maven |Build automation tool |3.8.4 |[download](https://maven.apache.org/download.cgi) | |
|Postman |API development support app |9.12.0 |[download](https://www.postman.com/downloads/) | |
|Git |Version control |2.24.3 |[website](https://git-scm.com/) | |
|JUnit |Testing Framework |managed by Spring Boot |[website](https://junit.org/junit5/) |[maven repository link](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api)|
|Jacoco |Code coverage library |managed by Spring Boot |[website](https://www.jacoco.org/jacoco/) |[eclipse market place link for EclEmma code coverage tool](https://marketplace.eclipse.org/content/eclemma-java-code-coverage) | |
|Mockito |Mocking framework for unit tests |managed by Spring Boot |[website](https://site.mockito.org/) | |
|Jira |Online project management tool | |[website](https://www.atlassian.com/software/jira) | |
|GNU Bash |shell script |3.2.57(1) |[website](https://www.gnu.org/software/bash/) | |


</details>

## How I expected the challenge to go

I think I expected the project to go fairly well, even though I was less confident in, and had less experience of the Spring Boot framework than I might have liked. I had been using git and pushing my code up to GitHub over the last three weeks so I felt fairly confident in using git and GitHub. Whilst I still felt a bit unsure about my Java and testing skills, I did feel like I had a fairly robust theoretical knowledge and good notes and resources to rely on.

## What went well? / What didn't go as planned?

### Strengths:
I chose to build up the app from a very basic functioning version containing only controller and entity classes, without repository or service classes. This meant the project took longer than it might have done because it added more steps, the initial code contained some elements that were not used in the final product and conversely, the final product with the integrated service and repository classes contained some new code not in this first version. However, despite the time and effort this process took, I believe it was well spent as it meant I had a functioning app pretty much all the way along, apart from some odd bugs. I refactored my code incrementally and made sure new components were fully integrated into a functioning app before expanding further.

### Weaknesses and troubleshooting:
As could have been predicted, I think some of the weakest areas of my project were the ones where my learning was quite a while ago, or I had spent less time on the topics. Apart from git, which I had been practicing, my knowledge of Jira software and the epic, user story and task model was rusty. Similarly, using the Spring Boot system was slower, as my theoretical understanding of the frameworks was less cemented.

Some problems cannot be predicted as such. On the afternoon of day three of doing my project my laptop died. The hard drive failed and then failed to boot or even recognise that it existed.

#### The saga of my computer issues
<details>
	<summary>Further details</summary>

Luckily, I had been regularly pushing all my code to GitHub, so only lost the code for one test method. This mitigation ****** was exactly what I had written on my risk assessment two days prior. 

Whilst I had not lost much work, I had to 1) find a new computer to use, and 2) set up a workable environment on said computer. I here would like to give great thanks to my brother for lending me his computer. Luckily it has the same OS as mine so that made everything easier.

The set up of my work environment probably took at least four hours. I had to do the following:
* installing my IDE Eclipse
* setting up an SSH key for my computer for GitHub access
* cloning my project down from GitHub
* installing MicrosoftTeams (for taking part in scrum meetings with course mates and tutors)
* installing Spring Boot
* installing Maven
* adding Maven to the machine path
* setting the path for $JAVA_HOME because that had not been set
* configuring Eclipse so that it found the JDK so I could get the basic JRE libraries
* installing EclEmma Jacoco coverage viewer
* installing Postman

Overall I feel I dealt with this setback well and was very resourceful. Reinstalling and setting up my work environment also refreshed my setup knowledge for the technologies I was using. Ultimately, my project did not hugely suffer from my computer issues. The main impacts were:
* Not having time to install and set up MySQL, therefore using H2 as my primary database.
* Losing screenshots of Postman showing (almost) complete functionality from day two of my project work.
* Having no time to add any, even minor, additional functionality.
	</details>
	
In adition to a predictable amount of bugs that cropped up in my code which I was able to analyse and rectify (sometimes with support from colleagues and tutors), a few cropped up which I don't understand, but I still fixed:
* At one early point my Spring Boot application was failing to boot, the application context wouldn't load. After some troubleshooting, we found that removing a Spring Fox dependency I had resolved the issue. [It was probably this bug or something similar](https://debugah.com/springboot2-6-use-springfox-error-documentationpluginsbootstrapper-22827/).
* I was having trouble getting my H2 database to persist. I could see in the console output that the database kept dropping and then recreating itself on each start up. I tried a few configurations of my [application-dev.properties](../../blob/src/main/resouces/application-dev.properties) file. In the end we fixed this issue by designating a file rather than the in-memory location, as explained [here](https://www.baeldung.com/h2-embedded-db-data-storage), which fixed the issue.

## Possible improvements for future revisions of the project.

A few smaller functional changes which I would have liked to implement, had I more time are:
* Utilising optionals so that incorrect requests would not cause a program shutdown.
* Implementing custom exceptions.
* Adding functionality to check the validity of an ISBN (International Standard Book Number) entered. This could be use a [regex](https://www.oracle.com/technical-resources/articles/java/regex.html) package, or could be a script like [this](https://www.geeksforgeeks.org/program-check-isbn/).

Some more advanced improvements for an expanded project:
* Adding custom queries for returning books of the same genre code (I used the [Thema subject categories scheme](https://ns.editeur.org/thema/en)) such that one could do a GET request to a url such as “/books/genre/general-fiction” and receive a list of all books with the genre code “FB”. (As I am using a recognised system like Thema, that data may be available online in a way that could potentially be collected and used automatically). Though the request in itself would not be hard, it would be the mapping of the genre url text and the genre code which would take more time.
* As implied above, my Library project is very basic and is currently functioning more as book metadata storage. Therefore, further improvements would be adding user and loan entities and connecting them so that users could have loans of specific books.
* Another avenue for expansion is that ISBNs actually contain quite a bit of data (see image below). Contained in the number sequence are values that map to a publishers, terretories or language groups and more. If my project could access such data then it would be possible to automate fields such as “publisher”.
<img align="centre" width="300" alt="Data elements contained in an 10 and 13 digit ISBN" src="https://upload.wikimedia.org/wikipedia/commons/8/84/ISBN_Details.svg">

## Screenshots showing postman requests and the output from the API.

Whilst I did have screenshots of Postman showing (almost) complete functionality from day two of my project work, these have been lost as they were on my computer desktop ([see above](https://github.com/rosemadr/DFESW7_Final_Project/edit/documentation/README.md#the-saga-of-my-computer-issues)). Whilst those would have been nice to have the following screenshots demonstrate full CRUD (create, read, update, delete) functionality for my api.
<details>
	<summary>Screenshots</summary>

#### Create functionality

![Screenshot 2022-02-05 at 15 21 25](https://user-images.githubusercontent.com/25704939/152648118-06910dff-1328-42ee-8695-9f9c47c369bf.png)
Adding the book *V for Vendetta* using a POST request to localhost:8080/books. The request response is a 201 Created status and the book which has been inputted.

#### Read functionality
![Screenshot 2022-02-05 at 15 21 39](https://user-images.githubusercontent.com/25704939/152648120-ee4e6f72-b7d6-4043-bcad-76ca020e0397.png)
A GET request to localhost:8080/books, which gets a list of all books and a 200 OK status. You can see the newly added *V for Vendetta*.

#### Delete functionality
![Screenshot 2022-02-05 at 15 23 42](https://user-images.githubusercontent.com/25704939/152648123-d0c4eb95-5568-4eea-a240-e6c09afe4809.png)
A DELETE request to localhost:8080/books/9780316449052. That is the ISBN of *Rosewater*. The response is a 202 Accepted status with no body data.

![Screenshot 2022-02-05 at 15 23 48](https://user-images.githubusercontent.com/25704939/152648124-947b92d6-f97c-4ef3-8060-eb1a7dac5c6e.png)
The previous DELETE request has worked and *Rosewater* is no longer returned in a GET to localhost:8080/books.

#### Update functionality
![Screenshot 2022-02-05 at 15 28 00](https://user-images.githubusercontent.com/25704939/152648128-d73d4bdd-3778-4fc0-b23c-d56b9cf45188.png)
*The Heart of the Race* has been posted to the api.

![Screenshot 2022-02-05 at 15 29 56](https://user-images.githubusercontent.com/25704939/152648130-9281df78-f627-4e88-b121-009e5f1a2827.png)
A PUT request is used to edit the data for *Heart of the Race*. It returns a 202 Accepted status and the updated book data.

#### Read functionality
![Screenshot 2022-02-05 at 15 43 13](https://user-images.githubusercontent.com/25704939/152648507-a0108f18-9b60-4a9a-9f2b-292468267eaf.png)
A GET request to localhost:8080/books/9781786635860, which retrieves a 200 OK status and *The Heart of the Race* with updated author fields.
</details>
	
## Screenshots of database to prove that data is being persisted
<details>
	<summary>Screenshots</summary>

![Screenshot 2022-02-03 at 13 54 51](https://user-images.githubusercontent.com/25704939/152552234-27723577-cf54-49c1-82ae-db7b0e13bafd.png)
*The Catcher in the Rye* has been added to the database on 3/2/2022.

![Screenshot 2022-02-05 at 15 45 52](https://user-images.githubusercontent.com/25704939/152648588-15726028-3d73-46c5-9852-d8aeb67721fa.png)
A SELECT * FROM Books query shows all books in the database on 5/2/2022, including *The Catcher in the Rye* which was added two days prior.
</details>

## Screenshot of test results, including coverage report
<details>
	<summary>Screenshots</summary>

![Screenshot 2022-02-04 at 11 36 50](https://user-images.githubusercontent.com/25704939/152546616-e6d3e182-12ea-4727-9ff1-0a3185ab4edc.png)
20/20 tests passing, including web integration, system integration and unit testing.

![Screenshot 2022-02-04 at 11 36 42](https://user-images.githubusercontent.com/25704939/152546608-9790f431-dda4-43a8-b1bd-11ab4a6e3a94.png)

89.1% test coverage.
	</details>


## [Jira Board Link](https://countzero.atlassian.net/jira/software/projects/DFPM/)
