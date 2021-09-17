# Sport_Concussion_Assessment_System
A project created for CSE598 Software Analysis and Design.

Sport concussion Assessment System (SCAS) is an application that help athletes and medical staff to diagnose symptoms of concussion. The project is implemented in Java and the class diagram is developed using Astah.

### Run it locally

Download the zip file or clone the project
```
gh repo clone peggiezx/Sport_Concussion_Assessment_System
```
Build and run the main.java in your local IDE

### Example

#### Welcome Page

Welcome to Sport Concussion Assessment System!

******** Please select one of the following options ********
1. Enter Symptoms - Enter [1]
2. Display Symptoms Summary - Enter [2]
3. Am I at Risk? - Enter [3]
4. Exit - Type [quit]

#### If Option 1 is selected, twenty-two questions will be prompted for user input
******** Evaluation Form ********

How do you feel? Score yourself on the following symptoms listed below, based on how you feel now.

Please Enter a Score from [0] to [6].
Note: None [0], Mild[1-2], Moderate[3-4], Severe[5-6]

Q1: Headache: 

Q2: Pressure in head: 

Q3: Neck pain: 

Q4: Nausea or vomiting: 

Q5: Dizziness: 

Q6: Blurred vision: 

...

#### The app will store data for the five most recent input. Athletes can see the symptoms summary for each game by selection Option 2, which includes

* Total number of symptoms
* Symptom severity score (sum of the score for individual symptoms)
* Overall rating ("no difference", "very different", "unsure") - by comparing the current input with the previous input


