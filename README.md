# Java-Microservices

Using diferent frameworks for microservice

reference book "Microservices for Java Developers - 2nd edition"

Technologies:
- Spring-boot
- OpenJDK 11
- Docker
- Kubernetes

Using Visual code with devcontainer for fast work...


## Communication:
![alt text](images/Microservices.JPG)


## The SpringBoot Microservices

Detail:
Using Spring-Boot CLI for init project.
Using REST Template to handle the Backend response
Using Rest Controllers for Rest 
USing Properties vars for ENVS (it's can be changed when build or call de Docker image).

Run
    
    mvn clean spring-boot:run

## The Backend (with maven wildfly)

Backend using servlet, code from book.

Run:

    mvn wildfly:run


Result