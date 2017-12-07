# Test Project5

## Build and run from jar
    mvn clean package
    java -jar learn-spring/target/learn-spring.jar


## Create mysql container
Create mysql docker image and run it as mentioned in folder mysql-docker-image-running


## Run through maven command
    mvn spring-boot:run

## Test some other tests
```
    curl http://localhost:3194/ayontestApp/create/ayon/age/hundred
   	curl http://localhost:3194/ayontestApp/get/ayon
   	curl http://localhost:3194/ayontestApp/update/1/name/ayontwo
   	
   	curl http://localhost:3194/ayontestApp/get/ayon
   	curl http://localhost:3194/ayontestApp/get/ayontwo

    curl http://localhost:3194/ayontestApp/delete/ayontwo
    curl http://localhost:3194/ayontestApp/get/ayontwo
```
