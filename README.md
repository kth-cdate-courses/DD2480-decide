# DD2480 - Group 1

### Members
* Edward
* Erik
* Hampus
* Pauline

## Project 1: Launch Interceptor Program

This program is part of an anti-missile system and implements the function DECIDE, which determines whether an interceptor should be
launched based upon input radar tracking information.

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

### Compile, test and run

Build the program with:
`$ mvn compile --file decide/pom.xml`

Test the program with:
`$ mvn test --file decide/pom.xml`

Run the program with:


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

TODO: checklist

#### Principles established

#### Foundation Established

#### In Use

#### In Place

#### Working well

TODO: summary of our way of working

### Folder structure
```
root  
├── README.md  
├── DECIDE  
│   ├── src  
│   ├── tests  
│   └── README.md  
├── Continuous Integration  
│   ├── src  
│   ├── tests  
│   └── README.md   
└── Code complexity, coverage  
	├── src  
	├── tests  
	└── README.md   
```

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




