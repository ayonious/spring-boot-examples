# Test Project4

## Build and run from jar
    mvn clean package
    java -jar learn-spring/target/learn-spring.jar

## Run through maven command
    mvn spring-boot:run

## Test if your spring-boot application is running

Run some other tests
```
    http://localhost:3194/test1
    #see only one value in the list, if activate both profiles you will see 2 values
```

Override the variables inside yml files
```
mvn spring-boot:run -Dspring.profiles.active="dev,prod"
http://localhost:3194/test1


env SPRING_PROFILES_ACTIVE=dev mvn spring-boot:run
http://localhost:3194/test1
```
