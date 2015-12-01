Assignment 03: SOAP Web Services - Server

**Introduction to Service Design and Engineering | University of Trento |** 

**Name:** Rodrigo Sestari

**Description:**

In this assignment is implemented a server and a client calling this server. 
The server was deployed on Heroku **http://rodrigo-sestari-soap-server.herokuapp.com/ws/people?wsdl**.
Instead the client was implemented to call Heroku server. 




**Code:**


* **introsde.assignment.soap.bean:** Classes to manage the mapping operation.
* **introsde.assignment.soap.dao:** Classe DAO "data access object"
* **introsde.assignment.soap.model:** Classes to represent your domain model.
* **introsde.assignment.soap.mapping** Classes to manage what and how the domain model is going to be mapped to the presentation layer.
* **introsde.assignment.soap.endpoint** Standalone HTTP Server
* **introsde.assignment.soap.ws** Implementation WS





**Tasks Server:**


* **Request #1:** readPersonList() => List | should list all the people in the database (see below Person model to know what data to return here) in your database
* **Request #2:** readPerson(Long id) => Person | should give all the Personal information plus current measures of one Person identified by {id} (e.g., current measures means current healthProfile)
* **Request #3**: updatePerson(Person p) => Person | should update the Personal information of the Person identified by {id} (e.g., only the Person's information, not the measures of the health profile)
* **Request #4:** createPerson(Person p) => Person | should create a new Person and return the newly created Person with its assigned id (if a health profile is included, create also those measurements for the new Person).
* **Request #5:** deletePerson(Long id) should delete the Person identified by {id} from the system
* **Request #6:** readPersonHistory(Long id, String measureType) => List should return the list of values (the history) of {measureType} (e.g. weight) for Person identified by {id}
* **Request #7:** readMeasureTypes() => List should return the list of measures
* **Request #8:**  readPersonMeasure(Long id, String measureType, Long mid) => Measure should return the value of {measureType} (e.g. weight) identified by {mid} for Person identified by {id}
* **Request #9:** savePersonMeasure(Long id, Measure m) =>should save a new measure object {m} (e.g. weight) of Person identified by {id} and archive the old value in the history
* **Request #10:** updatePersonMeasure(Long id, Measure m) => Measure | should update the measure identified with {m.mid}, related to the Person identified by {id}


* **The minimal model supported by your service should include:**
 ```
public class Person {
 Long id;
 String firstname;
 String lastname;
 List<Measure> currentHealth; // one for each type of measure
 List<Measure> healthHistory; // all measurements
}

public class Measure {
 Long mid,
 Date dateRegistered;
 String measureType;
 String measureValue;
 String measureValueType; // string, integer, real
}
```


**How to run:**

Running the project requires java and ant.

Ant source file build.xml is annotated. 
* Main target is: 
* **start:** To start the local server.





**References:**

https://sites.google.com/a/unitn.it/introsde_2015-16/lab-sessions/assignments/assignment-3

