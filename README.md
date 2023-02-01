# DD2480 - Group 1

### Members
* Edward
* Erik
* Hampus
* Pauline

## Project 1: Launch Interceptor Program

This program is part of an anti-missile system and implements the function DECIDE, which determines whether an interceptor should be
launched based upon input radar tracking information. The project is an implementation of the following specification: Launch Interceptor Program: Requirements
Specification
J. C. Knight and N. G. Leveson
(adapted by John Regehr and Martin Monperrus)
June 16, 2016.  

### Folder structure
```
root  
├── README.md  
├── DECIDE  
│   ├── src  
|   |   └── ...
|   |       ├── Decide.java
|   |       ├── InitialSettings.java
|   |       ├── LogicalOperator.java
|   |       └── Point.java
│   ├── tests  
│   └── README.md  
├── ...
...

```

### Use project, compile, test and run

The project is not meant to be run as is, but is mean to be used as a library for other projects. Download the project/source code and use the Decide class in your project to decide if missiles can be sent or not. Create an instance of the class initialized with parameters representing the observed environment (these are specified using an instance of the InitialSettings class), then call the decide() method. The decide() method will then either print out "YES" or "NO". This corresponds to if missles are allowed to be launched or not.  

The project is built using Maven and created using IntelliJ. The easiest way to test the project is therefore probably by using IntelliJ to open up the project and let IntelliJ figure out of the run the tests or run the program. However, it is also possible to use maven to compile/test the project. See info below.  

Java version:  This project is written for Java 17, but other versions may work as well.

Build the program with:
`$ mvn compile --file decide/pom.xml`

Test the program with:
`$ mvn test --file decide/pom.xml`


### Statement of contributions

We decided as a group to divide the work by assigning one person to the testing,
and then working equally on all conditions and on all intermediate computations for the three remaining members.
We assessed groups of conditions which had common tasks such as evaluating the area of a triangle, computing an angle, etc. 
This lead to the following repartition of the work:

* Edward: wrote all tests for conditions and main DECIDE function along with their comments
* Erik: wrote conditions 2, 3, 9, 14 and commented all conditions
* Hampus: set the project up, wrote conditions 0, 6, 7, 12 and CMV computation
* Pauline: wrote conditions 1, 4, 5, 8, 11, 13 and computation of PUM and FUV

The reviewing part of the work as well as the fixing of bugs could be taken by any member of the group on any issue, so that we ended up doing a lot of pair programming in different configurations, which was very rewarding: we learned a lot from working with people of different work methodology and skills, especially when it came to learning how to handle Git.  
We feel that this project really helped setting up our way of working as a group: we feel more confident in the practices we want to follow concerning the division of the work, the respect of Git commit, issue tracker and PR conventions. We also have an idea of what we would want to improve for the next projects, for instance a better repartition of the work on tests, while respecting basic principles for writing independant and unbiased tests. 

### Essence: assessment of our Way of Working

We think that our team has reached the "In Use" state of the Essence Way of Working progression, but there is still at least one point holding us from reaching the next state.

#### Principles established

We feel that we check the items for this step because we know exactly what kind of work we need to do thanks to the assignment description, 
and we are aware of the constraints such as the limited amount of time or the need to use a version control tool in a systematic way. We didn't really consider the stakeholders since that would probably be the teacher here which gave us clear indications of how to work and guidelines for the context.

#### Foundation Established

We also think that we filled the requirements for this step since we agreed on some key practices such as regular online communication and real life meetings and on some guidelines for the use of Git. We identified the tools we wanted to work with, such as Discord for communication, Git for version control, Java and Maven for code. We did not identify a gap between tools needed and tools available since Git offers all we need with support for CI in our case. 
However, we identified the gap in our capabilities in the sense that we know some of us are not so at ease with the use of Git or with Java and its build tools. There is seemingly no gap when it comes to communication practices.

#### In Use

We also check this step since we got some real work done, we regularly discuss how to use git or Java and inspect our practices when reviewing others but also when we meet on Discord or in person, we ask questions when we are unsure and we adapted some practices when needed, for instance we added the project panel to follow reviews because we felt that we had trouble finding a good review cycle. Our practices and tool definitely support us: we can communicate easily and git allows for efficient collaboration.

However, there may be a point that we don't completely check here: we don't really have procedures to handle feedback because we still do it in an informal way.

#### In Place

We feel that we still check many items in this step, such as everyone using the practices and tools appropriately at the end of the project. We also all have access to what we need to work efficiently.

However, once again we didn't really think of how to take new ideas from everyone on our Way of Working. 

#### Working well

We are not yet there, for instance we still don't apply our practices without thinking, it will likely take some more time on the second project for that.

#### Conclusion

We assessed that we stand in the "In Use" state, we there is still one particular point on which we should work in the future to get to the next step, which is a procedure to take feedback and all actively participate on the evaluation of our practices and our way of working in general. Maybe we should have some sort of feedback chain, or take some time discussing it at each meeting. 


### Conventions (suggested)
Branch namings: `<name>/<type>/<issue-number>-<descriptive branch name>`  
Example: `sven/fix/1-change-color-of-button`


Commits follow: https://www.conventionalcommits.org/en/v1.0.0/  
| Where | Naming Convention |
| -- | -- |
| Variables | camelCase |
| functions/methods | camelCase |
| constants | CONSTANTS |
| classes | PascalCase |




